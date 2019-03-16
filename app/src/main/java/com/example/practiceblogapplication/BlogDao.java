package com.example.practiceblogapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface BlogDao {
    @Query("SELECT * FROM blog")
    LiveData<List<Blog>> getAll();

    @Insert
    void insertAll(Blog... blogs);

    @Delete
    void delete(Blog blog);
}
