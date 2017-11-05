package com.asrulsibaoel.lectureme.models.response.ChatHistory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import in.tawari.app.tawarinapp.models.tables.Chat;

public class Data {

    @SerializedName("list_chat")
    @Expose
    private List<Chat> listChat = null;
    @SerializedName("page")
    @Expose
    private String page;

    public List<Chat> getListChat() {
        return listChat;
    }

    public void setListChat(List<Chat> listChat) {
        this.listChat = listChat;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

}