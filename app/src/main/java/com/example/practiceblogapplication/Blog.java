package com.example.practiceblogapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "blog")
public class Blog {
    @PrimaryKey(autoGenerate = true)
    public int blodId;

    @ColumnInfo(name = "content")
    public String blogContent;

    @ColumnInfo(name = "writer")
    public String blogWriter;

    @ColumnInfo(name = "time")
    public long postTime;

    Blog(String blogContent, String blogWriter, long postTime) {
        this.blogContent = blogContent;
        this.blogWriter = blogWriter;
        this.postTime = postTime;
    }
}
