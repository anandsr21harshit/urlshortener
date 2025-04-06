package com.harshit.urlshortener.controller;

import com.harshit.urlshortener.service.UrlShortenerImpl;
import com.harshit.urlshortener.service.UrlShortenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/tinyurl")
public class UrlShortenerController {

    @Autowired
    UrlShortenerService urlShortenerService;

    @PostMapping("/shorten")
    public String getShortUrl(@RequestParam String url){
        return urlShortenerService.shortenUrl(url);
    }

    @GetMapping("/redirect")
    public String getRealUrl(@RequestParam String shortUrl){
        return urlShortenerService.redirectUrl(shortUrl);
    }

//    @GetMapping("/stress")
//    public void stressTest(){
//        System.out.println("Starting stress test...");
//        UrlShortenerImpl urlShortenerService = new UrlShortenerImpl();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        List<CompletableFuture<Integer>> list = new ArrayList<>();
//        for(int i=0;i<100_000;i++){
//            CompletableFuture<Integer> futureIds = CompletableFuture.supplyAsync(() -> {
//                return urlShortenerService.shortenUrl("https://example.com/" + Thread.currentThread().getName());
//            }, executorService);
//            list.add(futureIds);
//        }
//        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
//        System.out.println("Actual entries in map: " + urlShortenerService.mapSize());
//        executorService.shutdown();
//    }
}
