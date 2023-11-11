package com.newApp.newsApp.networking;

import com.newApp.newsApp.model.News;
import com.newApp.newsApp.model.NewsList;
import com.newApp.newsApp.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.List;
@Service
public class ApiService {
    @Autowired
    RetrofitObj retrofitObj;
//    @Autowired
//    Common common;
    NewsList newsList;
    public NewsList fetchNews(String category)  {
        Retrofit retrofit= retrofitObj.getRetrofitObj();
//        UserService userService =retrofit.create(UserService.class);
        RetrofitService retrofitService=retrofit.create(RetrofitService.class);
        Call<NewsList> callSync = retrofitService.getTopHeadlinesNews("in",category,Common.apiKey.getValue());
//
        try{
            System.out.println(callSync.request().url());

            newsList=callSync.execute().body();

        }
        catch (Exception e){
            e.printStackTrace();
        }

//                callAsync.enqueue(new Callback<NewsList>() {
//                    @Override
//                    public void onResponse(Call<NewsList> call, Response<NewsList> response) {
////                System.out.println(response.body().getMStatus());
//                        System.out.println(response.raw().request().url());
//                        newsList=response.body();
//                    }
//
//                    @Override
//                    public void onFailure(Call<NewsList> call, Throwable throwable) {
//                        System.out.println(throwable);
//                    }
//                });

//        System.out.println(user.getUrl());
        return newsList;
    }
}
