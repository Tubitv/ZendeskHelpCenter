package com.tubitv.tools.logic;

import android.support.annotation.NonNull;
import android.util.Log;

import com.tubitv.tools.RetrofitManager;
import com.tubitv.tools.ZendeskApiInterface;
import com.tubitv.tools.api.SupportArticle;
import com.tubitv.tools.api.SupportArticles;
import com.tubitv.tools.api.SupportCategories;
import com.tubitv.tools.api.SupportCategory;
import com.tubitv.tools.api.SupportSection;
import com.tubitv.tools.api.SupportSections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

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

    private Map<Long, SupportCategory> mMap = new ConcurrentHashMap<>();

    @NonNull
    private ZendeskApiInterface mApiInterface;

    public ZendeskHelpCenter() {
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
                return Observable.fromIterable(supportArticles.getArticles()).subscribeOn(Schedulers.newThread());
            }
        })
                .subscribeOn(Schedulers.newThread())
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {

                        Log.v("ZendeskHelpCenter", "do finally");
                    }
                })
                .subscribe(new Consumer<SupportArticle>() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull SupportArticle article) throws Exception {

                        Log.d("ZendeskHelpCenter", article.getTitle());
                        Log.v("ZendeskHelpCenter", "" + article.getCategoryId());
//                        Log.i("ZendeskHelpCenter", article.getBody());
//
//
                        Log.i("ZendeskHelpCenter", Thread.currentThread() + "" + "\n" + "\n");
                    }
                });

    }


//    @Override
//    public void onResponse(Call<ZendeskCategories> call, Response<ZendeskCategories> response) {
//        if (response.isSuccessful()) {
//            ZendeskCategories cats = response.body();
//            if (cats != null) {
//                for (ZendeskCategory cat : cats.getCategories()) {
//                    mData.put(cat.getId(), cat);
//                    mApiInterface.listSections(cat.getId()).enqueue(getSectionCallback());
//
//                }
//            }
//        }
//    }
//
//    @Override
//    public void onFailure(Call<ZendeskCategories> call, Throwable t) {
//
//    }
//
//    public Callback<ZendeskSections> getSectionCallback() {
//        return new Callback<ZendeskSections>() {
//            @Override
//            public void onResponse(Call<ZendeskSections> call, Response<ZendeskSections> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ZendeskSections> call, Throwable t) {
//
//            }
//        };
//    }

//    public interface CallBack {
//
//        void onSuccess(ZendeskCategories response);
//
//        void onError(Exception exception);
//    }


//    public void fetchData(CallBack callBack) {
//    }


//    public Observable<ZendeskCategories> getCategories() {
//
//        return Observable.create(new ObservableOnSubscribe<ZendeskCategories>() {
//            @Override
//            public void subscribe(ObservableEmitter<ZendeskCategories> e) throws Exception {
//                categoriesCall.execute();
//            }
//        });
////        return Observable.create((e) -> {
////            Response<ZendeskCategories> res = categoriesCall.execute();
////
////            if (res.isSuccessful()) {
////                ZendeskCategories cats = res.body();
////                if (cats != null) {
////                    for (ZendeskCategory cat : cats.getCategories()) {
////                        mData.put(cat.getId(), cat);
////                    }
////                }
////            }
////        });
//    }

//    public void getAndPutCategories() {
//          getCategories().flatMap(new Function<ZendeskCategories, ObservableSource<?>>() {
//            @Override
//            public ObservableSource<?> apply(ZendeskCategories zendeskCategories) throws Exception {
//
//                return Observable.fromArray(zendeskCategories.getCategories()).doAfterNext((categories)->{
//
//                    for(ZendeskCategory category: categories){
//
//                        mData.put(category.getId(),category);
//                    }
//
//                });
//            }
//        }).subscribeOn(Schedulers.newThread())
//                 .subscribe(new Consumer<Object>() {
//
//             @Override
//             public void accept(Object o) throws Exception {
//
//                 ZendeskCategory category = (ZendeskCategory)o;
//
//                 Log.i(TAG, category.getName());
//             }
//         });

//                .flatMap((category) -> {
//
//            int categoryId = ((ZendeskCategory) category).getId();
//
//            return getSections(categoryId);
//
//        }).doOnNext(()-> {});
//    }


//    publiclic void test2(){
//
//         Observable.create(new ObservableOnSubscribe<ZendeskArticles>() {
//            @Override
//            public void subscribe(ObservableEmitter<ZendeskArticles> e) throws Exception {
//
//                e.
//            }
//        });
//    }

//
//    public Observable<ZendeskArticles> getArticles(final int sectionId) {
//
//        return Observable.create((emitter) -> mApiInterface.listArticles(sectionId));
//    }


//    public Observable<ZendeskArticles> getArticles(int sectionId) {
//
//        return Observable.create(new ObservableOnSubscribe<ZendeskArticles>() {
//            @Override
//            public void subscribe(ObservableEmitter<ZendeskArticles> e) throws Exception {
//
//            }
//        });
}



