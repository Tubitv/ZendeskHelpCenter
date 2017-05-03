package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by stoyan on 5/2/17.
 */
public class SupportCategory {
    private static final String PLATFORM_KEY = "platform";
    private static final String SECTIONS_KEY = "sections";

    @SerializedName(PLATFORM_KEY)
    private String platform;
    @SerializedName(SECTIONS_KEY)
    private List<SupportSection> sectionList;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public List<SupportSection> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<SupportSection> sectionList) {
        this.sectionList = sectionList;
    }
}
