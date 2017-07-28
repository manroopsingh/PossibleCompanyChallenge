package com.example.user.possiblecompanychallenge.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;

import com.example.user.possiblecompanychallenge.R;
import com.example.user.possiblecompanychallenge.model.Book;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {


    RecyclerView rvBooklist;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    BookListAdapter bookListAdapter;

    List<Book> bookList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBookList();

        MainActivityPresenter presenter = new MainActivityPresenter();
        presenter.attachView(this);
        presenter.fetchData();
    }

    private void setupBookList() {
        //Bind View
        rvBooklist = (RecyclerView) findViewById(R.id.rvBookList);
        layoutManager = new LinearLayoutManager(this);
        rvBooklist.setLayoutManager(layoutManager);
        itemAnimator = new DefaultItemAnimator();
        rvBooklist.setItemAnimator(itemAnimator);

        bookListAdapter = new BookListAdapter(bookList, this);
        rvBooklist.setAdapter(bookListAdapter);
    }


    @Override
    public void showError(String error) {

    }

    @Override
    public void updateList(List<Book> bookList) {

        this.bookList.clear();
        this.bookList.addAll(bookList);
        bookListAdapter.notifyDataSetChanged();

    }
}
