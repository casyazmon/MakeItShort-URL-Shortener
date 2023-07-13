package com.kasina.makeitshort.service;

import com.google.common.hash.Hashing;
import com.kasina.makeitshort.mode.MakeItShort;
import com.kasina.makeitshort.mode.MakeItShortDto;
import com.kasina.makeitshort.repository.MakeItShortRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class MakeItShortServiceImpl implements MakeItShortService {
    @Autowired
    private final MakeItShortRepository makeItShortRepository;

    @Override
    public MakeItShort generateShortLink(MakeItShortDto makeItShortDto) {
        if (StringUtils.isNotEmpty(makeItShortDto.getUrl())){
            String encodedUrl = encodeUrl(makeItShortDto.getUrl());

            MakeItShort urlToPersist = new MakeItShort();
            urlToPersist.setCreationDate(LocalDateTime.now());
            urlToPersist.setOriginalUrl(makeItShortDto.getUrl());
            urlToPersist.setShortLink(encodedUrl);
            urlToPersist.setExpirationDate(getExpirationDate(makeItShortDto.getExpirationDate(),
                    urlToPersist.getCreationDate()));
            MakeItShort shortUrl = persistShortLink(urlToPersist);
            if (shortUrl != null){
                return shortUrl;
            }
            return null;
        }
        return null;
    }

    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {
        if(StringUtils.isBlank(expirationDate)){
            return creationDate.plusSeconds(60);
        }
        return LocalDateTime.parse(expirationDate);
    }

    private String encodeUrl(String url) {
        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8).toString();
        return encodedUrl;
    }

    @Override
    public MakeItShort persistShortLink(MakeItShort makeItShort) {
        MakeItShort shortUrl = makeItShortRepository.save(makeItShort);
        return shortUrl;
    }

    @Override
    public MakeItShort getEncoderUrl(String url) {
        return makeItShortRepository.findByShortLink(url);
    }

    @Override
    public void deleteShortLink(MakeItShort makeItShort) {
        makeItShortRepository.delete(makeItShort);
    }
}
