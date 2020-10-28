package com.example.crud_operation;

import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.List;

public class GetDataAsync {

    private static final String TAG = GetDataAsync.class.getName();
    public static void populateAsync(@NonNull final AppDatabase db) {PopulateDbAsync task = new PopulateDbAsync(db);
    task.execute();
    }
    public static void populateSync(@NonNull final AppDatabase db) {
        populateWithTestData(db);
    }
    private static Person addUser(final AppDatabase db, Person user) {
        db.personDao().insertAll(user);return user;
    }
    private static void populateWithTestData(AppDatabase db) {
        Person user = new Person();
        user.setName("Jakson1");
        user.setEmail("jack1@test.com");
        user.setAge(28);
        addUser(db, user);
        List<Person> userList = db.personDao().getAll();
        Log.d(GetDataAsync.TAG, "Rows Count: " + db.personDao().countUsers());
        Log.d(GetDataAsync.TAG, "Rows Count Name: " + db.personDao().findByName("Jakson1").getName());
        for (int i = 0; i < userList.size(); i++) {
            Log.d(GetDataAsync.TAG, "Rows Name: " + userList.get(i).getName());
        }
    }
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final AppDatabase mDb;
        PopulateDbAsync(AppDatabase db) {mDb = db;
        }

        @Override
        protected Void doInBackground(final Void... params) {
            populateWithTestData(mDb);
            return null;
        }
    }

}
