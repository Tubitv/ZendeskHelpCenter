package com.tubitv.tools;

import android.support.annotation.NonNull;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by allensun on 5/2/17.
 */

public class RetrofitManager {

    public static
    @NonNull
    Retrofit getBuilder(@NonNull String url) {
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * Creates a gson converter
     *
     * @return The converter
     */
    private static GsonConverterFactory buildGsonConverter() {
        return GsonConverterFactory.create(new GsonBuilder().create());
    }
}
