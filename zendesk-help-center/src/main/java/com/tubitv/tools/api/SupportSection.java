package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by stoyan on 5/2/17.
 */
public class SupportSection {
    private static final String TITLE_KEY = "title";
    private static final String ID_KEY = "id";
    private static final String ARTICLES_KEY = "articles";
    private static final String CATEGORY_ID_KEY = "category_id";
    private static final String POSITION_KEY = "position";

    @SerializedName(TITLE_KEY)
    private String title;
    @SerializedName(ID_KEY)
    private long id;
    @SerializedName(ARTICLES_KEY)
    private List<SupportArticle> articlesList;
    @SerializedName(CATEGORY_ID_KEY)
    private long categoryId;
    @SerializedName(POSITION_KEY)
    private int position;

    public void setCategoryIdOnArticles() {
        if (articlesList != null) {
            //setting the category id to each article.
            for (SupportArticle article : articlesList) {
                article.setCategoryId(categoryId);
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<SupportArticle> getArticlesList() {
        return articlesList;
    }

    public void setArticlesList(List<SupportArticle> articlesList) {
        this.articlesList = articlesList;
    }

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


}
