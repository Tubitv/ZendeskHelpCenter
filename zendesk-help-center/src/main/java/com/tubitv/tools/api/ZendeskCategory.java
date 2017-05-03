package com.tubitv.tools.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by allensun on 5/2/17.
 */

public class ZendeskCategory {

    public static final String ID_KEY = "id";
    public static final String URL_KEY = "url";
    public static final String NAME_KEY = "name";


    @SerializedName(ID_KEY)
    private long id;
    @SerializedName(URL_KEY)
    private String jsonUrl;
    @SerializedName(NAME_KEY)
    private String name;

    private List<ZendeskSection>  sections;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJsonUrl() {
        return jsonUrl;
    }

    public void setJsonUrl(String jsonUrl) {
        this.jsonUrl = jsonUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
