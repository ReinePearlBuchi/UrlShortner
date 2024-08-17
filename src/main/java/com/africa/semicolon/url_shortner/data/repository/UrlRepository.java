package com.africa.semicolon.url_shortner.data.repository;

import com.africa.semicolon.url_shortner.data.model.UrlShortner;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<UrlShortner, String> {
    UrlShortner findByShortUrl(String shortUrl);
    UrlShortner findByOriginalUrl(String originalUrl);
}
