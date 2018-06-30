package com.example.zain.chatapplication.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class UserDb {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "phoneNo")
    private String phoneNo;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "isAuth")
    private Boolean isAuthenticated;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getAuthenticated() {
        return isAuthenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        isAuthenticated = authenticated;
    }
}
