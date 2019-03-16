package com.example.practiceblogapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button  addBlogButton;
    private BlogViewModel mBlogViewModel;

    private final int DEFAULT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.blogView);
        final BlogListAdapter adapter = new BlogListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mBlogViewModel = ViewModelProviders.of(this).get(BlogViewModel.class);

        addBlogButton = this.findViewById(R.id.blog_button);

        mBlogViewModel.getAllBlogs().observe(this, new Observer<List<Blog>>() {
            @Override
            public void onChanged(@Nullable List<Blog> blogs) {
                adapter.setBlogs(blogs);
            }
        });

        addBlogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: make new activity for adding the blog.
                Intent intent = new Intent(MainActivity.this, AddBlog.class);
                startActivityForResult(intent, DEFAULT_REQUEST);
            }
        });
    }

    public void onActivityResult(int requestCode, int responseCode, Intent data) {
        if(requestCode == DEFAULT_REQUEST && responseCode == RESULT_OK) {
            String userBlog = data.getStringExtra(AddBlog.USER_BLOG);
            String userName = data.getStringExtra(AddBlog.USER_NAME);
            long blogDate = new Date().getTime();

            mBlogViewModel.insert(new Blog(userBlog, userName, blogDate));
        } else {
            Toast.makeText(getApplicationContext(), R.string.blog_error, Toast.LENGTH_LONG);
        }
    }
}
