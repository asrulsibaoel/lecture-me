package com.asrulsibaoel.lectureme.models.tables;

/**
 * Created by asrulsibaoel on 11/03/17.
 */

public final class Message {

    private String messages;
    private Integer id_product;

    public Message() {
    }

    public Message(String messages, Integer id_product) {
        this.messages = messages;
        this.id_product = id_product;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }
}
