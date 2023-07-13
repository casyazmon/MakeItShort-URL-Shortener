package com.kasina.makeitshort.service;

import com.kasina.makeitshort.mode.MakeItShort;
import com.kasina.makeitshort.mode.MakeItShortDto;

public interface MakeItShortService {
    MakeItShort generateShortLink(MakeItShortDto makeItShortDto);
    MakeItShort persistShortLink(MakeItShort makeItShort);
    MakeItShort getEncoderUrl(String url);
    void deleteShortLink(MakeItShort makeItShort);

}
