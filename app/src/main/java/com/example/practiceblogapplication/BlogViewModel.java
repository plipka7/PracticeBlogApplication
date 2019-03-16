package com.example.practiceblogapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class BlogViewModel extends AndroidViewModel {
    private BlogRepository mRepository;
    private LiveData<List<Blog>> mBlogs;

    public BlogViewModel(Application app) {
        super(app);
        mRepository = new BlogRepository(app);
        mBlogs = mRepository.getAllBlogs();
    }

    public LiveData<List<Blog>> getAllBlogs() {return mBlogs;}
    public void insert(Blog blog) {mRepository.insert(blog);}
}
