package com.example.zain.chatapplication.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MessagesDao {
    @Query("SELECT * FROM messages")
    List<Messages> getAll();

    @Query("SELECT * FROM messages WHERE (phoneNo= :phoneNo AND toPhoneNo = :toPhoneNo) OR (phoneNo= :toPhoneNo AND toPhoneNo = :phoneNo) ORDER BY time DESC")
    List<Messages> getAllM(String phoneNo, String toPhoneNo);

    @Query("SELECT phoneNo FROM messages WHERE phoneNo= :phoneNo AND toPhoneNo = :toPhoneNo ORDER BY time DESC;")
    List<String> getAllMessages(String phoneNo, String toPhoneNo);

    @Insert
    void insertAll(Messages... msgs);

    @Delete
    void delete(Messages msg);
}
