package com.kasina.makeitshort.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class MakeItShortResponse {

    private String originalUrl;
    private String shortLink;
    private LocalDateTime expirationDate;
}
