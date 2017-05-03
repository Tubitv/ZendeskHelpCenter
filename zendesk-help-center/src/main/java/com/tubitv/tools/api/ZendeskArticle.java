package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by allensun on 5/2/17.
 */

public class ZendeskArticle {

    public static final String ID_KEY = "id";
    public static final String URL_KEY = "url";
    public static final String TITLE = "title";
    public static final String POSITION_KEY = "position";
    public static final String BODY = "body";
    public static final String SECTION_ID = "section_id";

    @SerializedName(ID_KEY)
    private long id;
    @SerializedName(SECTION_ID)
    private long section_id;
    @SerializedName(URL_KEY)
    private String url;
    @SerializedName(TITLE)
    private String title;
    @SerializedName(POSITION_KEY)
    private int position;
    @SerializedName(BODY)
    private String body;

    private long category_id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSection_id() {
        return section_id;
    }

    public void setSection_id(long section_id) {
        this.section_id = section_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }
}
