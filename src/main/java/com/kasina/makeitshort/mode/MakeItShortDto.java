package com.kasina.makeitshort.mode;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MakeItShortDto {
    private String url;
    private String expirationDate; //optional
}
