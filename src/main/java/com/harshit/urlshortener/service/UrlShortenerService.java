package com.harshit.urlshortener.service;

public interface UrlShortenerService {

    String shortenUrl(String url);

    String redirectUrl(String shortUrl);
}
