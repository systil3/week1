package com.example.a1230;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Map;

@Entity
public class Department {
    @PrimaryKey(autoGenerate = true)
    public Integer dept_id;

    public String name;

    public Department(String name) {
        this.name = name;
    }
    public Integer getId() {return this.dept_id;}
    public String getName() {return this.name; }

}