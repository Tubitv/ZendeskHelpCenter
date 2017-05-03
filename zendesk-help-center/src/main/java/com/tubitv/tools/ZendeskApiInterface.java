package com.tubitv.tools;

import com.tubitv.tools.api.ZendeskArticles;
import com.tubitv.tools.api.ZendeskCategories;
import com.tubitv.tools.api.ZendeskSections;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by stoyan on 11/10/16.
 */
public interface ZendeskApiInterface {
    @GET("categories.json")
    Observable<ZendeskCategories> listCategories();

    @GET("categories/{categoryId}/sections.json")
    Observable<ZendeskSections> listSections(@Path("categoryId") long categoryId);

    @GET("sections/{sectionId}/articles.json")
    Observable<ZendeskArticles> listArticles(@Path("sectionId") long sectionId);
}
