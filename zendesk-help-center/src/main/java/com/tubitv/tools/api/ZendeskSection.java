package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 *  * {
 * "id":204224308,
 * "url":"https://help.tubitv.com/api/v2/help_center/en-us/sections/204224308-Account.json",
 * "html_url":"https://help.tubitv.com/hc/en-us/sections/204224308-Account",
 * "category_id":202718148,
 * "position":0,
 * "sorting":"manual",
 * "created_at":"2016-05-10T23:35:00Z",
 * "updated_at":"2016-05-11T21:21:11Z",
 * "name":"Account",
 * "description":"",
 * "locale":"en-us",
 * "source_locale":"en-us",
 * "outdated":false
 * }
 * Created by allensun on 5/2/17.
 */

public class ZendeskSection {
    public static final String ID_KEY = "id";
    public static final String URL_KEY = "url";
    public static final String NAME_KEY = "name";
    public static final String POSITION_KEY = "position";
    public static final String CATEGORY_ID_KEY = "category_id";

    @SerializedName(ID_KEY)
    private long id;
    @SerializedName(URL_KEY)
    private String url;
    @SerializedName(NAME_KEY)
    private String name;
    @SerializedName(POSITION_KEY)
    private int position;
    @SerializedName(CATEGORY_ID_KEY)
    private long category_id;

    private List<ZendeskArticle> mArticles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }
}
