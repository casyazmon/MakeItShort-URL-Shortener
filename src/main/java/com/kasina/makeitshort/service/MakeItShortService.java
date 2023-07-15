package com.kasina.makeitshort.service;

import com.kasina.makeitshort.model.MakeItShort;
import com.kasina.makeitshort.model.MakeItShortDto;

public interface MakeItShortService {
    MakeItShort generateShortLink(MakeItShortDto makeItShortDto);
    MakeItShort persistShortLink(MakeItShort makeItShort);
    MakeItShort getEncoderUrl(String url);
    void deleteShortLink(String urlId);

}
