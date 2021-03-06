package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by stoyan on 5/2/17.
 */
public class SupportCategories {


    @SerializedName("categories")
    private List<SupportCategory> categories;


    public List<SupportCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<SupportCategory> categories) {
        this.categories = categories;
    }

}
