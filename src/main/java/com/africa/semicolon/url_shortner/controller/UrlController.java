package com.africa.semicolon.url_shortner.controller;

import com.africa.semicolon.url_shortner.dto.request.FindOriginalUrlRequest;
import com.africa.semicolon.url_shortner.dto.request.ShortenUrlRequest;
import com.africa.semicolon.url_shortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:63343")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody ShortenUrlRequest shortenUrlRequest) {
        String shortUrl = urlService.shortenUrl(shortenUrlRequest);
        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> getOriginalUrl(@PathVariable FindOriginalUrlRequest originalUrlRequest) {
        String originalUrl = urlService.getOriginalUrl(originalUrlRequest);
        if (originalUrl != null) {
            return ResponseEntity.ok(originalUrl);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Original URL not found");
        }
    }
}
