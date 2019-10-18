package com.example.recruitmenttask.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recruitmenttask.R;
import com.example.recruitmenttask.databinding.FragmentDetailViewBinding;
import com.example.recruitmenttask.viewModel.DetailsViewModel;

public class DetailViewFragment extends Fragment {

    private FragmentDetailViewBinding mBinding;
    private String mSlug;

    public DetailViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_view, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(R.string.fragment_title_list);

        if (getArguments() != null) {
            mSlug = DetailViewFragmentArgs.fromBundle(getArguments()).getSlug();
        } else {
            mSlug = "";
        }

        setUpViewModel(mSlug);
    }

    private void setUpViewModel(String slug) {
        DetailsViewModel viewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
        mBinding.setLifecycleOwner(this);
        mBinding.setViewModel(viewModel);

        viewModel.getAuthor(slug).observe(this, details -> {
            mBinding.detailNameTextView.setText(details.getName());
            mBinding.detailDescriptionTextView.setText(Html.fromHtml(details.getDescription()));
        });
    }
}
