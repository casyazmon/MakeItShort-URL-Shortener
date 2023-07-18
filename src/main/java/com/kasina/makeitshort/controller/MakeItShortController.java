package com.kasina.makeitshort.controller;

import com.kasina.makeitshort.model.MakeItShort;
import com.kasina.makeitshort.model.MakeItShortDto;
import com.kasina.makeitshort.model.MakeItShortResponse;
import com.kasina.makeitshort.model.UrlErrorResponseDto;
import com.kasina.makeitshort.service.MakeItShortServiceImpl;
import com.kasina.makeitshort.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/makeitshort/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MakeItShortController {

    private final MakeItShortServiceImpl makeItShortService;
    private final UserService userService;

    @PostMapping("/generate")
    public ResponseEntity<?> generateShortLink(@RequestBody MakeItShortDto makeItShortDto){
        MakeItShort makeItShort = makeItShortService.generateShortLink(makeItShortDto);
        if (makeItShort != null) {
            MakeItShortResponse makeItShortResponse = new MakeItShortResponse();

            makeItShortResponse.setOriginalUrl(makeItShort.getOriginalUrl());
            makeItShortResponse.setExpirationDate(makeItShort.getExpirationDate());
            makeItShortResponse.setShortLink(makeItShort.getShortLink());
            return new ResponseEntity<>(makeItShortResponse, HttpStatus.OK);
        }
        UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
        urlErrorResponseDto.setStatus("404");
        urlErrorResponseDto.setError("There was an error processing your request. please try again");
        return new ResponseEntity<>(urlErrorResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{shortLink}")
    public ResponseEntity<?> redirectOriginalUrl(@PathVariable String shortLink, HttpServletResponse response) throws IOException {

        if (StringUtils.isEmpty(shortLink)){
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setStatus("Invalid Url");
            urlErrorResponseDto.setError("400");
            return new ResponseEntity<>(urlErrorResponseDto, HttpStatus.OK);

        }

        MakeItShort shortUrl = makeItShortService.getEncoderUrl(shortLink);

        if (shortUrl == null) {
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setStatus("Url does not exist or it might have expired");
            urlErrorResponseDto.setError("400");
            return new ResponseEntity<>(urlErrorResponseDto, HttpStatus.OK);
        }
        if(shortUrl.getExpirationDate().isBefore(LocalDateTime.now())){

            makeItShortService.deleteShortLink(shortUrl.getUrlId());
            UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
            urlErrorResponseDto.setStatus("Url Expired. Please try generating a fresh one");
            urlErrorResponseDto.setError("200");
            return new ResponseEntity<>(urlErrorResponseDto, HttpStatus.OK);
        }
        response.sendRedirect(shortUrl.getOriginalUrl());
        return null;
    }

    @DeleteMapping("/{urlId}")
    public ResponseEntity<?> deleteShortLink(@PathVariable String urlId) {

        makeItShortService.deleteShortLink(urlId);
        return ResponseEntity.ok("Url deleted successfully");
    }

    @GetMapping("/user/urls")
    public ResponseEntity<List<MakeItShort>> getAllUrlsForCurrentUser() {
        List<MakeItShort> urls = userService.getAllUrlsForUser();
        return ResponseEntity.ok(urls);
    }

    @GetMapping
    public ResponseEntity<List<MakeItShort>> getAllUrls() {
        List<MakeItShort> urls = userService.getAllUrls();
        return ResponseEntity.ok(urls);
    }


}
