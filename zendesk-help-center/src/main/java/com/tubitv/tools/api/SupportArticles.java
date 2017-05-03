package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by allensun on 5/3/17.
 */

public class SupportArticles {

    @SerializedName("articles")
    List<SupportArticle> articles;

    private long categoryId;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public List<SupportArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<SupportArticle> articles) {
        this.articles = articles;
    }

    public SupportArticles setCategoryIdOnArticles() {
        if (articles != null) {
            //setting the category id to each article.
            for (SupportArticle article : articles) {
                article.setCategoryId(categoryId);
            }
        }
        return this;
    }
}
