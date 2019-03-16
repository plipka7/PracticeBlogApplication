package com.example.practiceblogapplication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class BlogRepository {
    private BlogDao mBlogDao;
    private LiveData<List<Blog>> mBlogs;

    public BlogRepository(Application app) {
        AppDatabase mAppDatabase = AppDatabase.getDatabase(app);
        mBlogDao = mAppDatabase.blogDao();
        mBlogs = mBlogDao.getAll();
    }

    LiveData<List<Blog>> getAllBlogs() {return mBlogs;}
    public void insert(Blog blog) {
     new insertAsyncTask(mBlogDao).execute(blog);
    }

    private static class insertAsyncTask extends AsyncTask<Blog, Void, Void> {
        private BlogDao mDao;

        insertAsyncTask(BlogDao dao) {
            mDao = dao;
        }

        @Override
        protected Void doInBackground(final Blog... params) {
            mDao.insertAll(params[0]);
            return null;
        }
    }
}
