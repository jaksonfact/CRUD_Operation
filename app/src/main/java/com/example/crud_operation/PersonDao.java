package com.example.crud_operation;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonDao {

    @Query("SELECT * FROM person")
    List<Person> getAll();
    @Query("SELECT * FROM person where name LIKE :firstName")
    Person findByName(String firstName);
    @Query("SELECT COUNT(*) from person")
    int countUsers();
    @Insert
    void insertAll(Person users);
    @Delete
    void delete(Person user);
}
