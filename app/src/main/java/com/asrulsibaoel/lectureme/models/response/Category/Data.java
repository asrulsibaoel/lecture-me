
package com.asrulsibaoel.lectureme.models.response.Category;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("list_category")
    @Expose
    private List<ListCategory> listCategory = null;
    @SerializedName("page")
    @Expose
    private String page;

    public List<ListCategory> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<ListCategory> listCategory) {
        this.listCategory = listCategory;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

}
