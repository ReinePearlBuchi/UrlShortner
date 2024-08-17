package com.africa.semicolon.url_shortner.service;

import com.africa.semicolon.url_shortner.data.model.UrlShortner;
import com.africa.semicolon.url_shortner.data.repository.UrlRepository;
import com.africa.semicolon.url_shortner.dto.request.FindOriginalUrlRequest;
import com.africa.semicolon.url_shortner.dto.request.ShortenUrlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlServiceImpl implements UrlService{

    @Autowired
    private UrlRepository urlRepository;

    private final String BASE_URL = "http://short.url/";

    @Override
    public String shortenUrl(ShortenUrlRequest shortenUrlRequest) {
        String originalUrl = shortenUrlRequest.getOriginalUrl();

        UrlShortner existingUrl = urlRepository.findByOriginalUrl(originalUrl);
        if (existingUrl != null) {
            return existingUrl.getShortUrl();
        }

        String shortUrl = BASE_URL + generateShortCode();

        UrlShortner url = new UrlShortner();
        url.setOriginalUrl(originalUrl);
        url.setShortUrl(shortUrl);
        urlRepository.save(url);

        return shortUrl;
    }

    @Override
    public String getOriginalUrl(FindOriginalUrlRequest findOriginalUrlRequest) {
        UrlShortner url = urlRepository.findByOriginalUrl(String.valueOf(findOriginalUrlRequest));
        return (url != null) ? url.getOriginalUrl() : null;
    }


    private String generateShortCode() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder shortCode = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            shortCode.append(characters.charAt(random.nextInt(characters.length())));
        }

        return shortCode.toString();
    }
}
