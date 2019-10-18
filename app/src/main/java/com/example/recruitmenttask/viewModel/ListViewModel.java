package com.example.recruitmenttask.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recruitmenttask.data.Injection;
import com.example.recruitmenttask.data.TaskDataSource;
import com.example.recruitmenttask.data.TaskRepository;
import com.example.recruitmenttask.data.pojo.Author;

import java.util.List;

public class ListViewModel extends ViewModel {

    private TaskRepository mRepository;
    private MutableLiveData<List<Author>> mListAuthor;

    public ListViewModel() {
        mRepository = Injection.provideTaskRepository();
    }

    public LiveData<List<Author>> getAuthors() {
        if (mListAuthor == null) {
            mListAuthor = new MutableLiveData<>();
            getData();
        }

        return mListAuthor;
    }

    private void getData() {
        mRepository.getAllAuthors(new TaskDataSource.LoadDataCallback() {
            @Override
            public void onDataLoaded(List<?> data) {
                mListAuthor.setValue((List<Author>) data);
            }

            @Override
            public void onDataNotAvailable() { }
        });
    }

}
