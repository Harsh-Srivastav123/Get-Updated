package com.newApp.newsApp.networking;

import com.newApp.newsApp.model.News;
import com.newApp.newsApp.model.NewsList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.List;

public interface RetrofitService {




//    @GET("/users")
//    public Call<List<User>> getUsers(
//            @Query("per_page") int per_page,
//            @Query("page") int page);    @GET("/top-headlines");

    @GET("/v2/top-headlines")

    public Call<NewsList> getTopHeadlinesNews(
            @Query("country") String country,
            @Query("category") String category,
            @Query("apiKey") String apiKey
    );

}
