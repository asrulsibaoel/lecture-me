package com.asrulsibaoel.lectureme.models.tables;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by asrulsibaoel on 12/03/17.
 */

public class TransactionDetail {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("transactions_id")
    @Expose
    private String transactionsId;
    @SerializedName("products_id")
    @Expose
    private Integer productsId;
    @SerializedName("real_price")
    @Expose
    private String realPrice;
    @SerializedName("bargain_price")
    @Expose
    private String bargainPrice;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("product")
    @Expose
    private Product product;
    @SerializedName("transaction")
    @Expose
    private Transaction transaction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionsId() {
        return transactionsId;
    }

    public void setTransactionsId(String transactionsId) {
        this.transactionsId = transactionsId;
    }

    public Integer getProductsId() {
        return productsId;
    }

    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }

    public String getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(String realPrice) {
        this.realPrice = realPrice;
    }

    public String getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(String bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
