package com.example.recruitmenttask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recruitmenttask.R;
import com.example.recruitmenttask.data.pojo.Author;

import java.util.List;

public class AuthorListAdapter extends RecyclerView.Adapter<AuthorListAdapter.ViewHolder> {

    private final LayoutInflater mInflater;
    private List<Author> mAuthors;
    private RecyclerViewClickListener mItemClickListner;

    public AuthorListAdapter(Context context, RecyclerViewClickListener listener) {
        mInflater = LayoutInflater.from(context);
        mItemClickListner = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final Button detailsButton;

        ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.list_item_name);
            detailsButton = view.findViewById(R.id.list_item_button);
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
        Author currentAuthor = mAuthors.get(position);
        holder.nameTextView.setText(currentAuthor.getName());
        holder.detailsButton.setOnClickListener(view -> mItemClickListner.onItemClick(currentAuthor.getSlug()));
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
