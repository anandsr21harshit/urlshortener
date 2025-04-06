package com.harshit.urlshortener.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urls")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UrlData {

    @Id
    private String id;
    private String shortUrl;
    private String longUrl;

    @Override
    public String toString() {
        return "UrlData{" +
                "shortUrl='" + shortUrl + '\'' +
                ", longUrl='" + longUrl + '\'' +
                '}';
    }
}
