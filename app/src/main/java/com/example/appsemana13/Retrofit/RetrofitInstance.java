package com.example.appsemana13.Retrofit;

import com.example.appsemana13.Servicios.JikanApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static final String BASE_URL = "https://api.jikan.moe/v4/";
    private static Retrofit retrofit;

    public static JikanApiService getApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(JikanApiService.class);
    }
}
