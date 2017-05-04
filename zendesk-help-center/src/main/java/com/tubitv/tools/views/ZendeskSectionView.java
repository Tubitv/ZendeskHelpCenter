package com.tubitv.tools.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tubitv.tools.api.SupportArticle;
import com.tubitv.tools.api.SupportSection;
import com.tubitv.tools.databinding.ViewZendeskSectionBinding;


/**
 * Created by stoyan on 11/14/16.
 */
public class ZendeskSectionView extends LinearLayout {
    /**
     * TAG for logging
     */
    private static final String TAG = ZendeskSectionView.class.getSimpleName();

    private ViewZendeskSectionBinding mBinding;

    /**
     * @param context
     */
    public ZendeskSectionView(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public ZendeskSectionView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZendeskSectionView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (isInEditMode()) {
            return;
        }

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        mBinding = DataBindingUtil.inflate(inflater, R.layout.view_zendesk_section, this, true);
    }

    /**
     * Binds the {@link SupportSection} to this view to be displayed
     *
     * @param section
     */
    public void setSectionData(@NonNull SupportSection section) {
        mBinding.setSupportSection(section);
        //remove all views added, since these views are recycled
        mBinding.viewZendeskSectionLl.removeAllViewsInLayout();
        for (SupportArticle article : section.getArticlesList()) {
            ZendeskArticleView zendeskArticle = new ZendeskArticleView(getContext());
            LayoutParams params = new LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            mBinding.viewZendeskSectionLl.addView(zendeskArticle, params);
            zendeskArticle.setArticle(article);
        }
    }
}
