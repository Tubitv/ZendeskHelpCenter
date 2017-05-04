package com.tubitv.tools.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tubitv.tools.api.SupportSection;
import com.tubitv.tools.views.ZendeskSectionView;

import java.util.List;

/**
 * Created by stoyan on 11/16/16.
 */
public class SupportSectionAdapter extends BaseAdapter {
    /**
     * The context for this adapter
     */
    @NonNull
    private final Context mContext;

    /**
     * The list of {@link SupportSection} to populate the {@link FragmentSupportSectionBinding#fragmentSupportSectionListView}
     */
    @NonNull
    private final List<SupportSection> mSupportSections;

    public SupportSectionAdapter(@NonNull Context context, @NonNull List<SupportSection> supportSections) {
        this.mContext = context;
        this.mSupportSections = supportSections;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ZendeskSectionView zendeskSectionView;
        if (convertView == null ) {
            // if it's not recycled, initialize some attributes
            zendeskSectionView = new ZendeskSectionView(mContext);
        } else {
            zendeskSectionView = (ZendeskSectionView) convertView;
        }
        zendeskSectionView.setSectionData(getItem(position));
        return zendeskSectionView;
    }

    @Override
    public int getCount() {
        return mSupportSections.size();
    }

    @Override
    public SupportSection getItem(int position) {
        return mSupportSections.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
