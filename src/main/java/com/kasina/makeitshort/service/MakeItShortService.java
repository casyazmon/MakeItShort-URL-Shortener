package com.kasina.makeitshort.service;

import com.kasina.makeitshort.mode.MakeItShort;
import com.kasina.makeitshort.mode.MakeItShortDto;

public interface MakeItShortService {
    public MakeItShort generateShortLink(MakeItShortDto makeItShortDto);
    public MakeItShort persistShortLink(MakeItShort makeItShort);
    public MakeItShort getEncoderUrl(String url);
    public void deleteShortLink(MakeItShort makeItShort);

}
