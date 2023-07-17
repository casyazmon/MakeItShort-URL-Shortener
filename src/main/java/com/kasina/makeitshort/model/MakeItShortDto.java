package com.kasina.makeitshort.model;

import com.kasina.makeitshort.model.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MakeItShortDto {

    private String url;
    private String shortLink;
    private String expirationDate; //optional
    private User user;
}
