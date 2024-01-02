package com.example.a1230;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;

public interface TodoItemDao {

    @Query("SELECT * FROM TodoItem")
    ArrayList<TodoItem> getAll();

    @Query("SELECT * FROM TodoItem WHERE todo_id IN (:todoIds)")
    ArrayList<TodoItem> loadAllByIds(int[] todoIds);

    @Insert
    void insertAll(TodoItem... depts);
    @Delete
    void delete(TodoItem dept);
}
