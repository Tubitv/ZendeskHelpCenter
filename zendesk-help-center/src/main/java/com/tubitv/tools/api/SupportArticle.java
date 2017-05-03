package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by stoyan on 5/2/17.
 */
public class SupportArticle {
    private static final String TITLE_KEY = "title";
    private static final String BODY_KEY = "body";

    @SerializedName(TITLE_KEY)
    private String title;
    @SerializedName(BODY_KEY)
    private String body;

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


}
