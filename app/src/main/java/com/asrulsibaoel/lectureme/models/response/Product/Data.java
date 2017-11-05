package com.asrulsibaoel.lectureme.models.response.Product;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import in.tawari.app.tawarinapp.models.tables.Product;

public class Data {

    @SerializedName("product")
    @Expose
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

}
