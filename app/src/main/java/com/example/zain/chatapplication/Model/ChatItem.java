package com.example.zain.chatapplication.Model;

public class ChatItem {

    public String imageLink;
    public String itemName;
    public String time;
    public String lastChat;
    public String phoneNo;

    public ChatItem() {
    }

    public ChatItem(String imageLink, String itemName, String time, String lastChat, String phoneNo) {
        this.imageLink = imageLink;
        this.itemName = itemName;
        this.time = time;
        this.lastChat = lastChat;
        this.phoneNo = phoneNo;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLastChat() {
        return lastChat;
    }

    public void setLastChat(String lastChat) {
        this.lastChat = lastChat;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
