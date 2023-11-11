package com.newApp.newsApp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newApp.newsApp.dao.NewsDao;
import com.newApp.newsApp.model.News;
import com.newApp.newsApp.networking.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NewsService {
    @Autowired
    ApiService apiService;
    @Autowired
    NewsDao newsDao;


    @Autowired
    CloudinaryService cloudinaryService;
    StringBuilder category = new StringBuilder("general");

    public boolean deleteNews(String id) {
        try{
            newsDao.deleteById(id);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public List<News> fetchNews(String topic) {
        if (topic != null) {
            category=new StringBuilder(topic);
        }
        List<News> newsList = apiService.fetchNews(
                category.toString()
        ).getNewsList();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (News news : newsList) {
                    if(newsDao.findByTitle(news.getTitle()).isEmpty()){
                        news.setCategory(category.toString());
                        newsDao.save(news);
                    }
                }
            }
        });
        t.start();
        return newsList;
    }

    public List<News> getNews(String topic) {
        if (topic != null) {
            return newsDao.findByCategory(topic);
        }
        return newsDao.findAll();
    }

    public Optional<News> getNewsById(String id) {
        return newsDao.findById(id);
    }

    public News addNews(String news, MultipartFile file) {

        Map data= new HashMap();
        News addedNews;
        // String to User
        ObjectMapper mapper=new ObjectMapper();
        try {
            addedNews = mapper.readValue(news, News.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if(file!=null){
            data=cloudinaryService.upload(file);
            System.out.println(data);
        }
        if(addedNews!=null){
            if(data!=null){
                addedNews.setImageUrl(data.get("url").toString());
            }
            return newsDao.save(addedNews);
        }
        return null;
    }

    public boolean deleteByCategory(String category) {
//        for(News news:newsList){
//            System.out.println("main  "+news.getCategory());
//        }

//        try {
//            System.out.println("enter in this block");
//
//            });
//            return true;
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//        return false;
        try {
//           for (News news:newsDao.findByCategory(category)){
//               newsDao.deleteById(news.getNews_Id());
//           }
            newsDao.deleteByCategory(category);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
