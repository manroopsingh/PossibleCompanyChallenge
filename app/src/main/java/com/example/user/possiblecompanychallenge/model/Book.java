package com.example.user.possiblecompanychallenge.model;

/**
 * Created by singh on 7/27/17.
 */


import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book implements Serializable {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("imageURL")
    @Expose
    private String imageURL;
    private final static long serialVersionUID = -7634827951068709350L;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

}
