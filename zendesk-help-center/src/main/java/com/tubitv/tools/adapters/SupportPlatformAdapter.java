package com.tubitv.tools.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.tubitv.tools.R;
import com.tubitv.tools.api.SupportCategory;
import com.tubitv.tools.views.ZendeskCategoryView;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter class for {@link com.tubitv.tools.fragments.SupportMainFragment}
 * Populates the {@link com.tubitv.tools.databinding.FragmentSupportMainBinding#fragmentSupportMainGrid}
 * <p>
 * Created by stoyan on 11/4/16.
 */
public class SupportPlatformAdapter extends BaseAdapter {
    /**
     * The context for this adapter
     */
    private final Context mContext;

    /**
     * List of all the integer resource values of our drawables
     */
    private List<Integer> mIcons;

    /**
     * Array of all the platform labels
     */
    private String[] mLabels;

    /**
     * Initializes the icons and labels for our {@link ZendeskCategoryView}s
     * @param context
     */
    public SupportPlatformAdapter(@NonNull Context context) {
        mContext = context;
        loadIcons();
        loadLabels();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ZendeskCategoryView supportView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            supportView = new ZendeskCategoryView(mContext);
        } else {
            supportView = (ZendeskCategoryView) convertView;
        }

//        supportView.setSupportViewModel(new SupportCategory(mLabels[position], mIcons.get(position)));
        return supportView;
    }

    @Override
    public int getCount() {
        return mIcons.size();
    }

    @Override
    public Object getItem(int position) {
        return mIcons.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * Loads the resource ids of all the drawable icons used in this adapter
     */
    private void loadIcons() {
        mIcons = new ArrayList<>();
        TypedArray drawableResArray = mContext.getResources().obtainTypedArray(R.array.support_main_fragment_platform_icons);
        int val = -1;
        for (int i = 0; i < drawableResArray.length(); i++) {
            val = drawableResArray.getResourceId(i, -1);
            if (val > 0) {
                mIcons.add(val);
            }
        }
        // recycle the array
        drawableResArray.recycle();
    }

    /**
     * Loads the string labels for the views from a string array in resources
     */
    private void loadLabels() {
        mLabels = mContext.getResources().getStringArray(R.array.support_main_fragment_platform_labels);
    }
}
