package com.harshit.urlshortener.repository;

import com.harshit.urlshortener.entity.UrlData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UrlRepository extends MongoRepository<UrlData,String> {

    Optional<UrlData> findByShortUrl(String shortUrl);
}
