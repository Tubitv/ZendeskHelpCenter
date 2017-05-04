package com.tubitv.tools.api;

import android.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by stoyan on 5/2/17.
 */
public class SupportCategory {
    private static final String PLATFORM_KEY = "name";
    private static final String ID_KEY = "id";
    private static final String SECTIONS_KEY = "sections";

    @SerializedName(PLATFORM_KEY)
    private String platform;
    @SerializedName(ID_KEY)
    private long id;
    @SerializedName(SECTIONS_KEY)
    private List<SupportSection> sectionList;


    @Bindable
    public String getLabel() {
        return platform;
    }
    @Bindable
    public Integer getDrawableRes() {
//        return mDrawableRes;
        return 1;
    }

    public void setLabel(String label) {
//        this.mLabel = label;
//        notifyPropertyChanged(BR.label);
    }

    public void setDrawableRes(Integer drawableRes) {
//        this.mDrawableRes = drawableRes;
//        notifyPropertyChanged(BR.drawableRes);
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<SupportSection> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<SupportSection> sectionList) {
        this.sectionList = sectionList;
    }
}
