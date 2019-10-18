package com.example.recruitmenttask.data;

import androidx.annotation.NonNull;

import java.util.List;

public interface TaskDataSource {

    interface LoadDataCallback {

        void onDataLoaded(List<?> data);

        void onDataNotAvailable();
    }

    interface GetSingleDataCallback<T> {

        void onDataLoaded(T object);

        void onDataNotAvailable();
    }

    void getAllAuthors(@NonNull final LoadDataCallback callback);

    void getSingleAuthor(String name, @NonNull final GetSingleDataCallback callback);
}
