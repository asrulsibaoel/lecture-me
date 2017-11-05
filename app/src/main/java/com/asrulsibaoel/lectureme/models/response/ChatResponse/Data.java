package com.asrulsibaoel.lectureme.models.response.ChatResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import in.tawari.app.tawarinapp.models.tables.Chat;

public class Data {

    @SerializedName("chat")
    @Expose
    private Chat chat;

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

}