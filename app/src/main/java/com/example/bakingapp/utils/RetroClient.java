package com.example.bakingapp.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    private static final String ROOT_URL = "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }
}
