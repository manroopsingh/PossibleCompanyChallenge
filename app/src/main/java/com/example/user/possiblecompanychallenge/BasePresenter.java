package com.example.user.possiblecompanychallenge;

/**
 * Created by singh on 7/27/17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();
}
