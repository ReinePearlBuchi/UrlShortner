package com.africa.semicolon.url_shortner.service;

import com.africa.semicolon.url_shortner.dto.request.FindOriginalUrlRequest;
import com.africa.semicolon.url_shortner.dto.request.ShortenUrlRequest;

public interface UrlService {

    String shortenUrl(ShortenUrlRequest shortenUrlRequest);
    String getOriginalUrl(FindOriginalUrlRequest findOriginalUrlRequest);

}
