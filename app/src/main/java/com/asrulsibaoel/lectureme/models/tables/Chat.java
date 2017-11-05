package com.asrulsibaoel.lectureme.models.tables;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chat {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("users_id")
    @Expose
    private Integer usersId;
    @SerializedName("chats_rooms_id")
    @Expose
    private Integer chatsRoomsId;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("products_id")
    @Expose
    private Integer productsId;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("chats_room")
    @Expose
    private ChatRoom chatRoom;
    @SerializedName("product")
    @Expose
    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getChatsRoomsId() {
        return chatsRoomsId;
    }

    public void setChatsRoomsId(Integer chatsRoomsId) {
        this.chatsRoomsId = chatsRoomsId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getProductsId() {
        return productsId;
    }

    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ChatRoom getChatsRoom() {
        return chatRoom;
    }

    public void setChatsRoom(ChatRoom chatsRoom) {
        this.chatRoom = chatsRoom;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
