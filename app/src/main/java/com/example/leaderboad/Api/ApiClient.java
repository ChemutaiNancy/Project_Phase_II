package com.example.leaderboad.Api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel( HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://gadsapi.herokuapp.com")
                .addConverterFactory( GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static ApiLeaderService getLeaders(){
        ApiLeaderService apiLeaderService = getRetrofit().create(ApiLeaderService.class);
        return apiLeaderService;
    }

    public static ApiSkillService getSkillIq(){
        ApiSkillService apiSkillService = getRetrofit().create(ApiSkillService.class);
        return apiSkillService;
    }
}
