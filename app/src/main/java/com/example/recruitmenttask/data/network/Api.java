package com.example.recruitmenttask.data.network;

import com.example.recruitmenttask.data.pojo.Author;
import com.example.recruitmenttask.data.pojo.Details;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Streaming;

public interface Api {

    @Streaming
    @GET("api/authors")
    Single<List<Author>> getAllAuthors();

    @Streaming
    @GET("api/authors/{slug}")
    Single<Details> getSingleAuthorDetail(@Path("slug") String slug);
}
