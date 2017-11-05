package com.asrulsibaoel.lectureme.models.response.TransactionResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import in.tawari.app.tawarinapp.models.tables.TransactionDetail;

public class Data {

    @SerializedName("list_transactions_details_detail")
    @Expose
    private List<TransactionDetail> listTransactionDetail = null;
    @SerializedName("page")
    @Expose
    private Integer page;

    public List<TransactionDetail> getListTransactionsDetail() {
        return listTransactionDetail;
    }

    public void setListTransactionDetail(List<TransactionDetail> listTransactionDetail) {
        this.listTransactionDetail = listTransactionDetail;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

}
