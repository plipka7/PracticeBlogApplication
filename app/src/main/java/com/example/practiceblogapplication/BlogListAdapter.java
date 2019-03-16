package com.example.practiceblogapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class BlogListAdapter extends RecyclerView.Adapter<BlogListAdapter.BlogViewHolder> {

    class BlogViewHolder extends RecyclerView.ViewHolder {
        public final TextView blogContent;
        public final TextView bloggerName;
        public final TextView blogDate;

        BlogViewHolder(View itemView) {
            super(itemView);
            blogContent = itemView.findViewById(R.id.blogContent);
            bloggerName = itemView.findViewById(R.id.bloggerName);
            blogDate = itemView.findViewById(R.id.blogDate);
        }
    }

    private final LayoutInflater mInflater;
    private List<Blog> mBlogs;

    BlogListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    protected void setBlogs(List<Blog> blogs) {
        mBlogs = blogs;
        notifyDataSetChanged();
    }

    @Override
    public BlogViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.blog_item, viewGroup, false);
        return new BlogViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BlogViewHolder viewHolder, int i) {
        if(mBlogs != null) {
            Blog current = mBlogs.get(i);
            viewHolder.blogContent.setText(current.blogContent);
            viewHolder.blogDate.setText(new Date(current.postTime).toLocaleString());
            viewHolder.bloggerName.setText(current.blogWriter);
        }
    }

    @Override
    public int getItemCount() {
        return mBlogs == null ? 0 : mBlogs.size();
    }
}
