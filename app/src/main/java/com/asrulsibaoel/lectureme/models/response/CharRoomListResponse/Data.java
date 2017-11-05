package com.asrulsibaoel.lectureme.models.response.CharRoomListResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import in.tawari.app.tawarinapp.models.tables.ChatRoom;

public class Data {

    @SerializedName("list_chatsroom")
    @Expose
    private List<ChatRoom> chatRoom = null;
    @SerializedName("page")
    @Expose
    private String page;

    public List<ChatRoom> getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(List<ChatRoom> chatRoom) {
        this.chatRoom = chatRoom;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

}
