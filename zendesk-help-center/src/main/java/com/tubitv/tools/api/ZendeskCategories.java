package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by allensun on 5/2/17.
 */

public class ZendeskCategories {


    @SerializedName("categories")
    private List<ZendeskCategory> categories;

    public List<ZendeskCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ZendeskCategory> categories) {
        this.categories = categories;
    }
}
