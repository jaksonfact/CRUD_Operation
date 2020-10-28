package com.example.crud_operation;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Person.class},version = 1)

public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    public abstract PersonDao personDao();
    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "person-database")
        // allow queries on the main thread.// Don’t do this on a real app! See PersistenceBasicSample for an example.// .allowMainThreadQueries()
            .build();
        }
        return INSTANCE;
    }
    public static void destroyInstance() {
        INSTANCE = null;
    }
        }
