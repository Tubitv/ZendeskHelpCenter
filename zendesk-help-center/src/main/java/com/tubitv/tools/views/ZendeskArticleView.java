package com.tubitv.tools.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.tubitv.tools.api.SupportArticle;
import com.tubitv.tools.databinding.ViewZendeskArticleBinding;
import com.tubitv.tools.events.SupportArticleClickEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by stoyan on 11/14/16.
 */
public class ZendeskArticleView extends LinearLayout{
    /**
     * TAG for logging
     */
    private static final String TAG = ZendeskArticleView.class.getSimpleName();

    /**
     * The {@link ViewZendeskArticleBinding} object used to inject dependencies and views
     */
    private ViewZendeskArticleBinding mBinding;

    /**
     * @param context
     */
    public ZendeskArticleView(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public ZendeskArticleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZendeskArticleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (isInEditMode()) {
            return;
        }

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        mBinding = DataBindingUtil.inflate(inflater, R.layout.view_zendesk_article, this, true);
//        mBinding.setArticleView(this);
    }

    public void setArticle(@NonNull SupportArticle article) {
        mBinding.setSupportArticle(article);
    }

    /**
     * Click listener for {@link ViewZendeskArticleBinding#viewZendeskArticleTitle}, that sends
     * and {@link EventBus} event to start the {@link com.tubitv.tools.fragments.SupportArticleFragment}
     *
     * @param view The view
     */
    public void onArticleClicked(View view) {
        SupportArticle article = mBinding.getSupportArticle();
        if (article != null) {
            EventBus.getDefault().post(new SupportArticleClickEvent(article));
        }
    }
}
