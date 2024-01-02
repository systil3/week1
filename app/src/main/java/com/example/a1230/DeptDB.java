package com.example.a1230;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Department.class}, version = 2)
public abstract class DeptDB extends RoomDatabase {
    private static DeptDB instance = null;
    public DeptDao deptDao;

    public static DeptDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DeptDB.class, "departments.db")
                    .addMigrations(new Migration(1, 2) {
                        @Override
                        public void migrate(@NonNull SupportSQLiteDatabase database) {
                            //database.execSQL("ALTER TABLE Department ADD COLUMN dept_id NOT NULL");
                        }
                    }).build();
        }
        return instance;
    }

    //public static createOpenHelper() {
    //}
    public static void destroyInstance() {
        instance = null;
    }
}
