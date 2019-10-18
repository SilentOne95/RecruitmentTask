package com.example.recruitmenttask.data;

import com.example.recruitmenttask.data.remote.TaskRemoteDataSource;

/**
 * Enables injection of mock implementations for
 * {@link TaskDataSource} at compile time. This is useful for testing, since it allows us to use
 * a fake instance of the class to isolate the dependencies and run a test hermetically.
 */
public class Injection {

    public static TaskRepository provideTaskRepository() {
        return TaskRepository.getInstance(TaskRemoteDataSource.getInstance());
    }
}
