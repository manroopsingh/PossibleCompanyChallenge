package com.example.user.possiblecompanychallenge.view;

import android.view.View;

import com.example.user.possiblecompanychallenge.BasePresenter;
import com.example.user.possiblecompanychallenge.BaseView;
import com.example.user.possiblecompanychallenge.model.Book;

import java.util.List;

/**
 * Created by singh on 7/27/17.
 */

public interface MainActivityContract {

    interface View extends BaseView {

        void updateList(List<Book> bookList);
    }

    interface Presenter extends BasePresenter<View> {

        void fetchData();
    }

}
