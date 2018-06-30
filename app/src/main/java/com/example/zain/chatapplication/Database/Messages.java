package com.example.zain.chatapplication.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import io.reactivex.annotations.NonNull;

@Entity
public class Messages {
    @NonNull
    @android.support.annotation.NonNull
    @PrimaryKey
    @ColumnInfo(name = "phoneNo")
    private String phoneNo;

    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "msg")
    private String msg;

    @ColumnInfo(name = "toPhoneNo")
    private String toPhoneNo;

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getToPhoneNo() {
        return toPhoneNo;
    }

    public void setToPhoneNo(String toPhoneNo) {
        this.toPhoneNo = toPhoneNo;
    }
}
