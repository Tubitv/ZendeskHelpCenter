package com.tubitv.tools.views;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.tubitv.tools.R;
import com.tubitv.tools.api.SupportCategory;
import com.tubitv.tools.databinding.ViewZendeskCategoryBinding;


/**
 * View class for use in {@link}
 * <p>
 * Created by stoyan on 11/4/16.
 */
public class ZendeskCategoryView extends LinearLayout {
    /**
     * TAG for logging
     */
    private static final String TAG = ZendeskCategoryView.class.getSimpleName();

    /**
     * The {@link ViewZendeskCategoryBinding} object used to inject dependencies and views
     */
    private ViewZendeskCategoryBinding mBinding;

    /**
     * @param context
     */
    public ZendeskCategoryView(Context context) {
        this(context, null);
    }

    /**
     * @param context
     * @param attrs
     */
    public ZendeskCategoryView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZendeskCategoryView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        if (isInEditMode()) {
            return;
        }

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.view_zendesk_category, this, true);
//        mBinding.setSupportModel(this);
    }

    /**
     * Sets the model used to bind data to the view
     *
     * @param model Model to data bind
     */
    public void setSupportViewModel(@NonNull SupportCategory model){
        mBinding.setSupportCategory(model);
    }
}
