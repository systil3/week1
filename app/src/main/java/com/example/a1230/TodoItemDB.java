package com.example.a1230;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {TodoItem.class}, version = 2)
public abstract class TodoItemDB extends RoomDatabase {
    private static TodoItemDB instance = null;

    public TodoItemDao todoItemDao;

    public static TodoItemDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    TodoItemDB.class, "departments.db")
                    .addMigrations(new Migration(1, 2) {
                        @Override
                        public void migrate(@NonNull SupportSQLiteDatabase database) {
                            //database.execSQL("ALTER TABLE TodoItem ADD COLUMN todo_id NOT NULL");
                        }
                    }).build();
        };
        return instance;
    }

    //public static createOpenHelper() {
    //}
    public static void destroyInstance() {
        instance = null;
    }
}
