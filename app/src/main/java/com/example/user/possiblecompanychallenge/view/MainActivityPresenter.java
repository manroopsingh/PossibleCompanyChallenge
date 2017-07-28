package com.example.user.possiblecompanychallenge.view;

import android.util.Log;

import com.example.user.possiblecompanychallenge.data.remote.RemoteDataSource;
import com.example.user.possiblecompanychallenge.model.Book;

import java.util.ArrayList;
import java.util.List;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by singh on 7/27/17.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    List<Book> bookList = new ArrayList<>();
    MainActivityContract.View view;

    @Override
    public void fetchData() {

        Log.d(TAG, "fetchData: ");


        Observable<List<Book>> listObservable = RemoteDataSource.createObservable();
        listObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<Book>>() {
                    @Override
                    public void onCompleted() {

                        view.updateList(bookList);
                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d(TAG, "onError: " + e.toString());
                    }

                    @Override
                    public void onNext(List<Book> books) {

                        Log.d(TAG, "onNext: ");
                        bookList.addAll(books);
                    }
                });

    }

    @Override
    public void attachView(MainActivityContract.View view) {

        this.view = view;
    }

    @Override
    public void detachView() {

        this.view = null;
    }
}
