package com.example.user.possiblecompanychallenge.view;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.possiblecompanychallenge.R;
import com.example.user.possiblecompanychallenge.model.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 7/27/17.
 */

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    List<Book> bookList = new ArrayList<>();
    Context context;

    public BookListAdapter(List<Book> bookList, Context context) {
        this.bookList = bookList;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBookTitle;
        ImageView ivBookimage;

        public ViewHolder(View itemView) {
            super(itemView);
            tvBookTitle = (TextView) itemView.findViewById(R.id.tvBookTitle);
            ivBookimage = (ImageView) itemView.findViewById(R.id.ivBookImage);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.booklist_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Book book = bookList.get(position);
        holder.tvBookTitle.setText(book.getTitle());
        Glide.with(context).load(book.getImageURL()).into(holder.ivBookimage);

    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
