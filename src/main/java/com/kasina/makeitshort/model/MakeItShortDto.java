package com.kasina.makeitshort.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MakeItShortDto {

    private String url;
    private String shortLink;
    private String expirationDate; //optional
}
