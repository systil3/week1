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
    @ForeignKey(entity = Department.class, parentColumns = "dept_id", childColumns = "dept_id",
            onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
    public Integer dept_id;
    public String task;
    public boolean completed;

    public TodoItem(Integer dept_id, String task, Boolean completed) {
        this.dept_id = dept_id;
        this.task = task;
        this.completed = completed;
    }
    public Integer getId() {return this.todo_id;}
    public Integer getDept_id() {return this.dept_id;}
    public String getTask() {
        return this.task;
    }

    public String updateTask(String s, Integer start) {
        //s : 변경된 문자열
        //start : 원래 문자열에서 변경이 시작된 곳
        //before : 원래 문자열에서 바뀐 부분의 길이
        //count : 원래 문자열을 대체한 부분의 길이

        this.task = this.task.substring(0, start) + s.substring(start);
        return this.task;
    }
    public String setTask(String task) {
        this.task = task;
        return task;
    }

    public void setAsCompleted() {this.completed = true; }
    public void setAsUncompleted() {this.completed = false;}
    public Boolean getCompleted() {
        return completed;
    }
}