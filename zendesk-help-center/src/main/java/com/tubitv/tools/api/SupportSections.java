package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by allensun on 5/3/17.
 */

public class SupportSections {

//    private static final String CATEGORY_ID_KEY = "category_id";
//    private static final String POSITION_KEY = "position";

//    @SerializedName(CATEGORY_ID_KEY)
    private long categoryId;
//    @SerializedName(POSITION_KEY)
    private int position;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @SerializedName("sections")
    private List<SupportSection> sections;

    public List<SupportSection> getSections() {
        return sections;
    }

    public void setSections(List<SupportSection> sections) {
        this.sections = sections;
    }
}
