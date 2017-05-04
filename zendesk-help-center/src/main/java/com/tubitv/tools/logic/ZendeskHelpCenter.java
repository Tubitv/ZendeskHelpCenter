package com.tubitv.tools.logic;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.tubitv.tools.RetrofitManager;
import com.tubitv.tools.UrlToFileUtil;
import com.tubitv.tools.ZendeskApiInterface;
import com.tubitv.tools.api.SupportArticle;
import com.tubitv.tools.api.SupportArticles;
import com.tubitv.tools.api.SupportCategories;
import com.tubitv.tools.api.SupportCategory;
import com.tubitv.tools.api.SupportSection;
import com.tubitv.tools.api.SupportSections;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

/**
 * Created by allensun on 5/2/17.
 */

public class ZendeskHelpCenter {
    private static final String TAG = ZendeskHelpCenter.class.getSimpleName();

    private static final String BASE_URL = "https://help.tubitv.com/api/v2/help_center/en-us/";

   private ZendeskData mData = new ZendeskData();
   private Activity mActivity;
    @NonNull
    private ZendeskApiInterface mApiInterface;

    public ZendeskHelpCenter(Activity activity) {
        mActivity = activity;
        Retrofit retrofit = RetrofitManager.getBuilder(BASE_URL);
        mApiInterface = retrofit.create(ZendeskApiInterface.class);
//        getAndPutCategories();
        getSections();
    }


    private void getSections() {

        //get the categories
        mApiInterface.listCategories().flatMap(new Function<SupportCategories, ObservableSource<SupportCategory>>() {
            @Override
            public ObservableSource<SupportCategory> apply(@io.reactivex.annotations.NonNull SupportCategories supportCategories) throws Exception {
                mData.setCategories(supportCategories);
                //ommit to category
                return Observable.fromIterable(supportCategories.getCategories()).subscribeOn(Schedulers.newThread());
            }
        }).flatMap(new Function<SupportCategory, ObservableSource<SupportSections>>() {
            @Override
            public ObservableSource<SupportSections> apply(@io.reactivex.annotations.NonNull SupportCategory supportCategory) throws Exception {

                return mApiInterface.listSections(supportCategory.getId());
            }
        }).flatMap(new Function<SupportSections, ObservableSource<SupportSection>>() {
            @Override
            public ObservableSource<SupportSection> apply(@io.reactivex.annotations.NonNull final SupportSections sections) throws Exception {
                mData.setSections(sections);
                return Observable.fromIterable(sections.getSections()).subscribeOn(Schedulers.newThread());
            }
        }).flatMap(new Function<SupportSection, ObservableSource<SupportArticles>>() {
            @Override
            public ObservableSource<SupportArticles> apply(@io.reactivex.annotations.NonNull final SupportSection supportSection) throws Exception {

                return mApiInterface.listArticles(supportSection.getId()).map(new Function<SupportArticles, SupportArticles>() {
                    @Override
                    public SupportArticles apply(@io.reactivex.annotations.NonNull SupportArticles supportArticles) throws Exception {
                        supportArticles.setCategoryId(supportSection.getCategoryId());
                        return supportArticles.setCategoryIdOnArticles();
                    }
                });
            }
        }).flatMap(new Function<SupportArticles, ObservableSource<SupportArticle>>() {
            @Override
            public ObservableSource<SupportArticle> apply(@io.reactivex.annotations.NonNull SupportArticles supportArticles) throws Exception {
                mData.setArticles(supportArticles);
                return Observable.fromIterable(supportArticles.getArticles()).subscribeOn(Schedulers.newThread());
            }
        })
                .subscribeOn(Schedulers.newThread())
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {

                        Log.v("ZendeskHelpCenter", "do finally");
                        Log.v("ZendeskHelpCenter", "Got " + mData.getSize() + " categories");
                        toFile();
                    }
                })
                .subscribe(new Consumer<SupportArticle>() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull SupportArticle article) throws Exception {

                        Log.d("ZendeskHelpCenter", article.getTitle());
                        Log.v("ZendeskHelpCenter", "" + article.getCategoryId());
                        Log.i("ZendeskHelpCenter", Thread.currentThread() + "" + "\n" + "\n");
                    }
                });

    }

    private void toFile(){

        UrlToFileUtil.writeToFile(new Gson().toJson(mData.toList()), mActivity);
    }

}



