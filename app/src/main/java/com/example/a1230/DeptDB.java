package com.example.a1230;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Department.class}, version = 1)
public abstract class DeptDB extends RoomDatabase {
    private static DeptDB instance = null;
    public abstract DeptDao deptDao();

    public static DeptDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DeptDB.class, "departments.db")
                    .addMigrations(


                    ).build();
        }
        return instance;
    }

    //public static createOpenHelper() {
    //}
    public static void destroyInstance() {
        instance = null;
    }
}
