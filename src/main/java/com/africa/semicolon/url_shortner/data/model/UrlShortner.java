package com.africa.semicolon.url_shortner.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection =  "shorten_url")
public class UrlShortner {
    @Id
    private String id;
    private String originalUrl;
    private String shortUrl;
}
