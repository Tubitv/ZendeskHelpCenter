package com.tubitv.tools;

import com.tubitv.tools.api.SupportArticles;
import com.tubitv.tools.api.SupportCategories;
import com.tubitv.tools.api.SupportSections;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by stoyan on 11/10/16.
 */
public interface ZendeskApiInterface {
    @GET("categories.json")
    Observable<SupportCategories> listCategories();

    @GET("categories/{categoryId}/sections.json")
    Observable<SupportSections> listSections(@Path("categoryId") long categoryId);

    @GET("sections/{sectionId}/articles.json")
    Observable<SupportArticles> listArticles(@Path("sectionId") long sectionId);
}
