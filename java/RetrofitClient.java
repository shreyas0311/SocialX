package com.example.socialx;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String base_url = "https://newsapi.org/v2/";
    private static RetrofitClient retrofitClient;
    private static Retrofit retrofit;
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private RetrofitClient()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(retrofitClient==null) {
            retrofitClient=new RetrofitClient();
        }
        return retrofitClient;
    }
    public API getApi() {
        return retrofit.create(API.class);
    }
}
