package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by allensun on 5/2/17.
 */

public class ZendeskSections {
    public List<ZendeskSection> getSections() {
        return sections;
    }

    public void setSections(List<ZendeskSection> sections) {
        this.sections = sections;
    }

    @SerializedName("sections")
    List<ZendeskSection> sections;
}
