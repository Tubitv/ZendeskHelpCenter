package com.tubitv.tools.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tubitv.tools.api.SupportArticle;
import com.tubitv.tools.api.SupportSection;
import com.tubitv.tools.views.ZendeskArticleView;


/**
 * Adapter class for the {@link android.widget.ListView} in
 * {@link com.tubitv.tools.views.ZendeskSectionView}
 * <p>
 * Created by stoyan on 11/17/16.
 */
public class SupportArticleAdapter extends BaseAdapter {
    /**
     * The context for this adapter
     */
    @NonNull
    private final Context mContext;

    /**
     * The section whos articles we are to display
     */
    @NonNull
    private final SupportSection mSection;

    public SupportArticleAdapter(@NonNull Context context, @NonNull SupportSection section) {
        this.mContext = context;
        this.mSection = section;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ZendeskArticleView zendeskArticle;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            zendeskArticle = new ZendeskArticleView(mContext);
        } else {
            zendeskArticle = (ZendeskArticleView) convertView;
        }
        zendeskArticle.setArticle(getItem(position));
        return zendeskArticle;
    }

    @Override
    public int getCount() {
        return mSection.getArticlesList().size();
    }

    @Override
    public SupportArticle getItem(int position) {
        return mSection.getArticlesList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
