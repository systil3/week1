package com.example.a1230;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

public interface DeptDao {
    @Query("SELECT * FROM Department")
    ArrayList<Department> getAll();

    @Query("SELECT * FROM Department WHERE dept_id IN (:deptIds)")
    ArrayList<Department> loadAllByIds(int[] deptIds);

    @Query("SELECT * FROM TodoItem " +
            "WHERE TodoItem.dept_id == (:deptId)")
    ArrayList<TodoItem> selectAllTodoItemsInDept(int deptId);
    @Insert
    void insertAll(Department... depts);

    @Delete
    void delete(Department dept);

}
