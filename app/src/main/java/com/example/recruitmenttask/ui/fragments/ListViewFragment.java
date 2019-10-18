package com.example.recruitmenttask.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recruitmenttask.R;
import com.example.recruitmenttask.adapter.AuthorListAdapter;
import com.example.recruitmenttask.adapter.RecyclerViewClickListener;
import com.example.recruitmenttask.viewModel.ListViewModel;

import static androidx.navigation.fragment.NavHostFragment.findNavController;

public class ListViewFragment extends Fragment {

    private Fragment mFragment;
    private View mView;
    private RecyclerView mRecyclerView;
    private AuthorListAdapter mAdapter;

    public ListViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_list_view, container, false);
        mFragment = this;
        return mView.getRootView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("List");

        setUpAdapter();
        setUpViewModel();
    }

    private void setUpAdapter() {
        mRecyclerView = mView.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new AuthorListAdapter(getContext(), mRecyclerViewItemClickListener);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setUpViewModel() {
        ListViewModel viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        viewModel.getAuthors().observe(this, authors -> mAdapter.setAuthors(authors));
    }

    private RecyclerViewClickListener mRecyclerViewItemClickListener = new RecyclerViewClickListener() {
        @Override
        public void onItemClick(String slug) {
            findNavController(mFragment).navigate(ListViewFragmentDirections.actionOpenDetailView(slug));
        }
    };
}
