package com.example.recruitmenttask.data.remote;

import androidx.annotation.NonNull;

import com.example.recruitmenttask.data.TaskDataSource;
import com.example.recruitmenttask.data.network.Api;
import com.example.recruitmenttask.data.network.RetrofitClient;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class TaskRemoteDataSource implements TaskDataSource {

    private static TaskRemoteDataSource INSTANCE;

    private Api mApi = RetrofitClient.getApi();
    private CompositeDisposable mDisposable = new CompositeDisposable();

    public static TaskRemoteDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TaskRemoteDataSource();
        }

        return INSTANCE;
    }

    // Prevent direct instantiation
    private TaskRemoteDataSource() {}

    @Override
    public void getAllAuthors(@NonNull final LoadDataCallback callback) {
        mDisposable.add(mApi.getAllAuthors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onDataLoaded, throwable -> callback.onDataNotAvailable()));
    }

    @Override
    public void getSingleAuthor(String name, @NonNull GetSingleDataCallback callback) {
    }
}
