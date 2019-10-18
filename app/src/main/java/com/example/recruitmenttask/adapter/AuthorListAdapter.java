package com.example.recruitmenttask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recruitmenttask.R;
import com.example.recruitmenttask.data.pojo.Author;

import java.util.List;

public class AuthorListAdapter extends RecyclerView.Adapter<AuthorListAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<Author> mAuthors;
    private RecyclerViewClickListner mItemClickListner;

    public AuthorListAdapter(Context context, RecyclerViewClickListner listener) {
        mInflater = LayoutInflater.from(context);
        mItemClickListner = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ViewHolder(View view) {
            super(view);
        }
    }

    @NonNull
    @Override
    public AuthorListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AuthorListAdapter.ViewHolder holder, final int position) {
        Author author = mAuthors.get(position);
    }

    public void setAuthors(List<Author> authors) {
        mAuthors = authors;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mAuthors != null)
            return mAuthors.size();
        else
            return 0;
    }
}
