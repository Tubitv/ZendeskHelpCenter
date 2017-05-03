package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by allensun on 5/2/17.
 */

public class ZendeskArticles {

    @SerializedName("articles")
    List<ZendeskArticle> articles;

    public List<ZendeskArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<ZendeskArticle> articles) {
        this.articles = articles;
    }
}
