
package com.asrulsibaoel.lectureme.models.response.Timeline;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("list_product")
    @Expose
    private List<ListProduct> listProduct = null;
    @SerializedName("page")
    @Expose
    private String page;

    public List<ListProduct> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<ListProduct> listProduct) {
        this.listProduct = listProduct;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

}
