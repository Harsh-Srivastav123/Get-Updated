package com.newApp.newsApp.networking;

import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
@Service
public class RetrofitObj {
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit retrofit;
    public Retrofit getRetrofitObj(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            return retrofit;
        }
        return retrofit;
    }
}
