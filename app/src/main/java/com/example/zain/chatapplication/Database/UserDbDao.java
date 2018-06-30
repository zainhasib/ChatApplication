package com.example.zain.chatapplication.Database;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.zain.chatapplication.Database.UserDb;

import java.util.List;

@Dao
public interface UserDbDao {
    @Query("SELECT * FROM userdb")
    List<UserDb> getAll();

    @Insert
    void insertAll(UserDb... users);

    @Delete
    void delete(UserDb user);
}
