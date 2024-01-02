package com.example.a1230;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Person.class}, version = 2)
public abstract class PersonDB extends RoomDatabase {
    private static PersonDB instance = null;
    public abstract PersonDao personDao();

    public static boolean isInstanceNull(Context context) {
        return (instance == null);
    }
    public static PersonDB getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    PersonDB.class, "persons.db")
                    .addMigrations(new Migration(1, 2) {
                        @Override
                        public void migrate(@NonNull SupportSQLiteDatabase database) {
                            //database.execSQL("ALTER TABLE Person ADD COLUMN id PRIMARY KEY NOT NULL");
                        }
                    })
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    //public static createOpenHelper() {

    //}
    public static void destroyInstance() {
        instance = null;
    }
}
