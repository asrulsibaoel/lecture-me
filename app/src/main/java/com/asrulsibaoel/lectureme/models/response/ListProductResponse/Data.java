package com.asrulsibaoel.lectureme.models.response.ListProductResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import in.tawari.app.tawarinapp.models.tables.Product;

public class Data {

    @SerializedName("list_product")
    @Expose
    private List<Product> listProduct = null;
    @SerializedName("page")
    @Expose
    private String page;

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

}