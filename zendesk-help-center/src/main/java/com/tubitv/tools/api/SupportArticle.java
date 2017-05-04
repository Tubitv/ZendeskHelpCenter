package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stoyan on 5/2/17.
 */
public class SupportArticle {
    private static final String TITLE_KEY = "title";
    private static final String BODY_KEY = "body";
    private static final String POSITION_KEY = "position";
    private static final String SECTION_ID_KEY = "section_id";

    @SerializedName(TITLE_KEY)
    private String title;
    @SerializedName(BODY_KEY)
    private String body;
    @SerializedName(POSITION_KEY)
    private int position;
    @SerializedName(SECTION_ID_KEY)
    private long sectionId;

    private long categoryId;


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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getSectionId() {
        return sectionId;
    }

    public void setSectionId(long sectionId) {
        this.sectionId = sectionId;
    }


}
