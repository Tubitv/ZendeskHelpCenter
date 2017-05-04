package com.tubitv.tools.events;

import android.support.annotation.Nullable;

import com.tubitv.tools.api.SupportArticle;

/**
 * {@link org.greenrobot.eventbus.EventBus} event for when user
 * clicks on {@link com.tubitv.tools.databinding.FragmentSupportSectionBinding#fragmentSupportSectionFab}
 * <p>
 * Created by stoyan on 11/15/16.
 */
public class SupportFeedbackEvent {
    @Nullable
    private SupportArticle article;


    public SupportFeedbackEvent(@Nullable SupportArticle article) {
        this.article = article;
    }

    @Nullable
    public SupportArticle getArticle() {
        return article;
    }
}
