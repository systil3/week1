package com.example.a1230;

import android.os.Parcel;
import android.os.Parcelable;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

// TodoItem.java
@Entity
public class TodoItem {
    @PrimaryKey(autoGenerate = true)
    public Integer todo_id;
    @ForeignKey(entity = Department.class, parentColumns = "dept_id", childColumns = "dept_id")
    public Integer dept_id;
    public String task;
    public boolean completed;

    public TodoItem(String task, Boolean completed) {
        this.task = task;
        this.completed = completed;
    }
    public Integer getId() {return this.todo_id;}
    public Integer getDept_id() {return this.dept_id;}
    public String getTask() {
        return this.task;

    }
    public String setTask(String task) {
        this.task = task;
        return task;
    }

    public Boolean setAsCompleted() {this.completed = true; return this.completed;}
    public Boolean setAsUncompleted() {this.completed = false; return this.completed;}

    public Boolean getCompleted() {
        return completed;
    }



}