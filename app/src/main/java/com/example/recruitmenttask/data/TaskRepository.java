package com.example.recruitmenttask.data;

import androidx.annotation.NonNull;

import java.util.List;

public class TaskRepository implements TaskDataSource {

    private static TaskRepository INSTANCE = null;

    private final TaskDataSource mTaskRemoteDataSource;

    // Prevent direct instantiation
    private TaskRepository(@NonNull TaskDataSource taskRemoteDataSource) {
        mTaskRemoteDataSource = taskRemoteDataSource;
    }

    /**
     * Returns a single instance of this class, creating it if necessary.
     *
     * @param taskRemoteDataSource the remote source of data
     * @return the {@link TaskRepository} instance
     */
    static TaskRepository getInstance(TaskDataSource taskRemoteDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new TaskRepository(taskRemoteDataSource);
        }

        return INSTANCE;
    }

    @Override
    public void getAllAuthors(@NonNull final LoadDataCallback callback) {
        mTaskRemoteDataSource.getAllAuthors(new LoadDataCallback() {
            @Override
            public void onDataLoaded(List<?> data) {
                callback.onDataLoaded(data);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void getSingleAuthor(String name, @NonNull final GetSingleDataCallback callback) {
        mTaskRemoteDataSource.getSingleAuthor(name, new GetSingleDataCallback() {
            @Override
            public void onDataLoaded(Object object) {
                callback.onDataLoaded(object);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }
}
