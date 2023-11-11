package com.newApp.newsApp.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newApp.newsApp.model.News;
import com.newApp.newsApp.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/news")
public class NewsControllers {


    @Autowired
    NewsService newsService;
    @GetMapping("/fetchNews/{category}")
    public ResponseEntity<List<News>> fetchNews(@PathVariable String category) throws InterruptedException {
        if(newsService.fetchNews(category)==null) return new ResponseEntity<>(null, HttpStatusCode.valueOf(404));
        return new ResponseEntity<>(newsService.fetchNews(category),HttpStatusCode.valueOf(200));
    }
    @GetMapping("/getNews/{category}")
    public ResponseEntity<List<News>> getNews(@PathVariable String category)  {
        if(newsService.getNews(category)==null) return new ResponseEntity<>(null, HttpStatusCode.valueOf(404));
        return new ResponseEntity<>(newsService.getNews(category),HttpStatusCode.valueOf(200));
    }
    @GetMapping("/getNews")
    public ResponseEntity<List<News>> getNews()  {
        if(newsService.getNews(null)==null) return new ResponseEntity<>(null, HttpStatusCode.valueOf(404));
        return new ResponseEntity<>(newsService.getNews(null),HttpStatusCode.valueOf(200));
    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteNews(@PathVariable String id){
        boolean status=newsService.deleteNews(id);
        if(!status){
            return new ResponseEntity<>(false,HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>(true,HttpStatusCode.valueOf(200));
    }
    @GetMapping("/getNewsById/{id}")
    public ResponseEntity<Optional<News>> getNewsById(@PathVariable String id){
        Optional<News> news=newsService.getNewsById(id);
        if(news.isEmpty()){
            return new ResponseEntity<>(null,HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>(news,HttpStatusCode.valueOf(200));
    }
    @PostMapping("/addNews")
    public ResponseEntity<News> addNews(@RequestParam("news") String news,
                        @RequestPart("image")MultipartFile file){
        News addedNews=newsService.addNews(news,file);
        if(addedNews==null){
            return new ResponseEntity<>(null,HttpStatusCode.valueOf(400));
        }
        return new ResponseEntity<>(addedNews,HttpStatusCode.valueOf(200));
    }
    @GetMapping("/deleteByCategory/{category}")
    public ResponseEntity<Boolean> deleteByCategory(String category ){


//        if(!status){
//            return new ResponseEntity<>(false,HttpStatusCode.valueOf(400));
//        }
        return new ResponseEntity<>(newsService.deleteByCategory(category),HttpStatusCode.valueOf(200));



    }




}
