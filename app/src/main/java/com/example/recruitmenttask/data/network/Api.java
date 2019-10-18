package com.example.recruitmenttask.data.network;

import com.example.recruitmenttask.data.pojo.Author;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public interface Api {

    @Streaming
    @GET("/")
    Single<List<Author>> getAllAuthors();
}
