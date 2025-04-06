package com.harshit.urlshortener.service;

import com.harshit.urlshortener.entity.UrlData;
import com.harshit.urlshortener.repository.UrlRepository;
import com.harshit.urlshortener.utils.Base62Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UrlShortenerImpl implements UrlShortenerService{

    @Autowired
    UrlRepository urlRepository;
    AtomicInteger shortId = new AtomicInteger(1);

    @Override
    public String shortenUrl(String url) {
        System.out.println("Shortening url:" + url);
        int id = shortId.getAndIncrement();
        String base64Val = Base62Util.encode(id);
        String shortUrl = "tinyurl/".concat(base64Val);
        UrlData urlData = new UrlData();
        urlData.setShortUrl(shortUrl);
        urlData.setLongUrl(url);
        urlRepository.save(urlData);
        return shortUrl;
    }

    @Override
    public String redirectUrl(String shortUrl) {
        try {
            Optional<UrlData> urlDataOptional = urlRepository.findByShortUrl(shortUrl);
            UrlData urlData = urlDataOptional.orElseThrow(() -> new RuntimeException("Not found"));
            return urlData.getLongUrl();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
