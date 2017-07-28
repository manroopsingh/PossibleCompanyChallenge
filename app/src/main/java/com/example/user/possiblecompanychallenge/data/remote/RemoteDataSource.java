package com.example.user.possiblecompanychallenge.data.remote;

import com.example.user.possiblecompanychallenge.model.Book;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by singh on 7/27/17.
 */

public class RemoteDataSource {

    public static final String BASE_URL = "http://de-coding-test.s3.amazonaws.com/";

    public static Retrofit createClient(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit;
    }


    public static Observable<List<Book>> createObservable(){

        Retrofit retrofit = createClient();
        RemoteService remoteService = retrofit.create(RemoteService.class);
        return remoteService.getBooks();
    }
}
