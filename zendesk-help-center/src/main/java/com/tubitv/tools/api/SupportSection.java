package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by stoyan on 5/2/17.
 */
public class SupportSection {
    private static final String TITLE_KEY = "title";
    private static final String ARTICLES_KEY = "articles";

    @SerializedName(TITLE_KEY)
    private String title;
    @SerializedName(ARTICLES_KEY)
    private List<SupportArticle> articlesList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SupportArticle> getArticlesList() {
        return articlesList;
    }

    public void setArticlesList(List<SupportArticle> articlesList) {
        this.articlesList = articlesList;
    }


}
