package com.example.recruitmenttask.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.recruitmenttask.data.Injection;
import com.example.recruitmenttask.data.TaskDataSource;
import com.example.recruitmenttask.data.TaskRepository;
import com.example.recruitmenttask.data.pojo.Details;

public class DetailsViewModel extends ViewModel {

    private TaskRepository mRepository;
    private MutableLiveData<Details> mAuthorDetail;

    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> description = new MutableLiveData<>();

    public DetailsViewModel() {
        mRepository = Injection.provideTaskRepository();
    }

    public LiveData<Details> getAuthor(String slug) {
        if (mAuthorDetail == null) {
            mAuthorDetail = new MutableLiveData<>();
            getData(slug);
        }

        return mAuthorDetail;
    }

    private void getData(String slug) {
        mRepository.getSingleAuthor(slug, new TaskDataSource.GetSingleDataCallback() {
            @Override
            public void onDataLoaded(Object object) {
                mAuthorDetail.setValue((Details) object);
            }

            @Override
            public void onDataNotAvailable() { }
        });
    }
}
