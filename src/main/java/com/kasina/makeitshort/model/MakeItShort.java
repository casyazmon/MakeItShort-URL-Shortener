package com.kasina.makeitshort.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@Document(collection = "urls")
public class MakeItShort {
    @Id
    private String urlId;

    @Lob
    private String originalUrl;
    private String shortLink;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime creationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime expirationDate;


    public MakeItShort() {
        // Generate a UUID as the URL ID
        this.urlId = UUID.randomUUID().toString();
    }
}

