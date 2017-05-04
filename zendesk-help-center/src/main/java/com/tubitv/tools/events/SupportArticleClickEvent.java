package com.tubitv.tools.events;

import android.support.annotation.NonNull;

import com.tubitv.tools.api.SupportArticle;

/**
 * Created by stoyan on 11/14/16.
 */
public class SupportArticleClickEvent {
    private @NonNull
    SupportArticle article;

    public SupportArticleClickEvent(@NonNull SupportArticle article) {
        this.article = article;
    }

    @NonNull
    public SupportArticle getArticle() {
        return article;
    }
}
