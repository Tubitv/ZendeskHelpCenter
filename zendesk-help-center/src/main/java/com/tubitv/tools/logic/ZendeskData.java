package com.tubitv.tools.logic;

import com.tubitv.tools.api.SupportArticles;
import com.tubitv.tools.api.SupportCategories;
import com.tubitv.tools.api.SupportCategory;
import com.tubitv.tools.api.SupportSection;
import com.tubitv.tools.api.SupportSections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by allensun on 5/3/17.
 */

public class ZendeskData {

    private Map<Long, SupportCategory> mMap = new ConcurrentHashMap<>();

    public void setCategories(SupportCategories categories) {
        for (SupportCategory category : categories.getCategories()) {
            mMap.put(category.getId(), category);
        }
    }

    public void setSections(SupportSections sections) {
        if (sections.getSections() != null && sections.getSections().size() > 0) {
            SupportCategory category = mMap.get(sections.getSections().get(0).getCategoryId());
            if (category != null) {
                category.setSectionList(sections.getSections());
                mMap.put(category.getId(), category);
            }
        }
    }

    public void setArticles(SupportArticles articles) {
        SupportCategory category = mMap.get(articles.getCategoryId());

        if (category != null && category.getSectionList() != null) {
            List<SupportSection> sections = category.getSectionList();
            for (SupportSection section : sections) {
                if (section.getId() == articles.getSectionId()) {
                    section.setArticlesList(articles.getArticles());
                    break;
                }
            }
        }
    }

    public int getSize() {
        return mMap.keySet().size();
    }

    public SupportCategories toList() {
        List<SupportCategory> categories = new ArrayList<>(mMap.keySet().size());
        SupportCategories supportCategories = new SupportCategories();
        for (Long key : mMap.keySet()) {
            categories.add(mMap.get(key));
        }
        supportCategories.setCategories(categories);
        return supportCategories;

    }
}
