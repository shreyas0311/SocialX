package com.example.socialx;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {

    @GET("top-headlines")
    Call<MainNews> getNews(
            @Query("sources") String sources,
            @Query("apiKey") String apiKey,
            @Query("pageSize") int pageSize);
}
