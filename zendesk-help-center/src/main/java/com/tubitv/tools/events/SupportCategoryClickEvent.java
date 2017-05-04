package com.tubitv.tools.events;

import android.support.annotation.NonNull;

import com.tubitv.tools.api.SupportCategory;
import com.tubitv.tools.fragments.SupportSectionFragment;

/**
 * Created by stoyan on 11/16/16.
 */
public class SupportCategoryClickEvent {
    private SupportSectionFragment sectionFragment;
    private SupportCategory category;

    public SupportCategoryClickEvent(@NonNull SupportSectionFragment sectionFragment, @NonNull SupportCategory category) {
        this.sectionFragment = sectionFragment;
        this.category = category;
    }

    public
    @NonNull
    SupportSectionFragment getSectionFragment() {
        return sectionFragment;
    }


    public
    @NonNull
    SupportCategory getCategory() {
        return category;
    }

}
