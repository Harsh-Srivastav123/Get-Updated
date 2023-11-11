
package com.newApp.newsApp.model;


import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class News {
    @Id
    String news_Id=UUID.randomUUID().toString();
    @SerializedName("author")
    private String author;
    @SerializedName("content")
    private String content;
    @SerializedName("description")
    @Column(columnDefinition = "TEXT")
    private String description;
    @SerializedName("publishedAt")
    private String publishedAt;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    @Column(columnDefinition="varchar(1000)")
    private String url;
    @SerializedName("urlToImage")
    private String imageUrl;
    private String category;
}
//"https://timesofindia.indiatimes.com/entertainment/hindi/bollywood/news/priyanka-chopra-reveals-people-had-advised-her-not-to-star-in-fashion-i-was-told-ladkiyan-female-oriented-films-career-ke-end-mein-karti-hai-national-award-ke-liye/articleshow/104805034.cms