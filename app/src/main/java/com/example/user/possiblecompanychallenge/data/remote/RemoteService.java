package com.example.user.possiblecompanychallenge.data.remote;

import com.example.user.possiblecompanychallenge.model.Book;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by singh on 7/27/17.
 */

public interface RemoteService {

    @GET("books.json")
    Observable<List<Book>> getBooks();
}
