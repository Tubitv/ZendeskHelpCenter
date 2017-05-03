package com.tubitv.tools.logic;

import android.support.annotation.NonNull;
import android.util.Log;

import com.tubitv.tools.RetrofitManager;
import com.tubitv.tools.ZendeskApiInterface;
import com.tubitv.tools.api.ZendeskArticle;
import com.tubitv.tools.api.ZendeskArticles;
import com.tubitv.tools.api.ZendeskCategories;
import com.tubitv.tools.api.ZendeskCategory;
import com.tubitv.tools.api.ZendeskSection;
import com.tubitv.tools.api.ZendeskSections;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

/**
 * Created by allensun on 5/2/17.
 */

public class ZendeskHelpCenter {


    private static final String BASE_URL = "https://help.tubitv.com/api/v2/help_center/en-us/";

    private static final String TAG = "ZendeskHelpCenter";
    @NonNull
    private ZendeskApiInterface mApiInterface;

    private Executor mExecutor;

    private Call<ZendeskCategories> categoriesCall;

    private Call<ZendeskSections> sectionsCall;

//    private CallBack myCallback;

    private ZendeskCategories mCategories;

    /**
     * Map of all the zendesk data that we fetch, the key is the category id
     */
    private static Map<Integer, ZendeskCategory> mData = new ConcurrentHashMap<>();
    private Callback<ZendeskSections> sectionCallback;

    public ZendeskHelpCenter() {
        Retrofit retrofit = RetrofitManager.getBuilder(BASE_URL);
        mApiInterface = retrofit.create(ZendeskApiInterface.class);
//        getAndPutCategories();
        getSections();
    }


    private void getSections() {

        //get the categories
        mApiInterface.listCategories().flatMap(new Function<ZendeskCategories, ObservableSource<ZendeskCategory>>() {
            @Override
            public ObservableSource<ZendeskCategory> apply(@io.reactivex.annotations.NonNull ZendeskCategories zendeskCategories) throws Exception {

                //ommit to category
                return Observable.fromIterable(zendeskCategories.getCategories());
            }
        }).flatMap(new Function<ZendeskCategory, ObservableSource<ZendeskSections>>() {
            @Override
            public ObservableSource<ZendeskSections> apply(@io.reactivex.annotations.NonNull ZendeskCategory zendeskCategory) throws Exception {

                return mApiInterface.listSections(zendeskCategory.getId());
            }
        }).flatMap(new Function<ZendeskSections, ObservableSource<ZendeskSection>>() {
            @Override
            public ObservableSource<ZendeskSection> apply(@io.reactivex.annotations.NonNull ZendeskSections sections) throws Exception {

                return Observable.fromIterable(sections.getSections());
            }
        }).flatMap(new Function<ZendeskSection, ObservableSource<ZendeskArticles>>() {
            @Override
            public ObservableSource<ZendeskArticles> apply(@io.reactivex.annotations.NonNull ZendeskSection zendeskSection) throws Exception {

                return mApiInterface.listArticles(zendeskSection.getId());
            }
        }).flatMap(new Function<ZendeskArticles, ObservableSource<ZendeskArticle>>() {
            @Override
            public ObservableSource<ZendeskArticle> apply(@io.reactivex.annotations.NonNull ZendeskArticles zendeskArticles) throws Exception {

                return Observable.fromIterable(zendeskArticles.getArticles());
            }
        })


                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZendeskArticle>() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull ZendeskArticle article) throws Exception {

                        Log.i("ZendeskHelpCenter", article.getBody());


                        Log.i("ZendeskHelpCenter", Thread.currentThread()+"" + "\n" +"\n");
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


    public Observable<ZendeskSections> getSections(final int categoryId) {

        return Observable.create(new ObservableOnSubscribe<ZendeskSections>() {
            @Override
            public void subscribe(@io.reactivex.annotations.NonNull ObservableEmitter<ZendeskSections> e) throws Exception {

                mApiInterface.listSections(categoryId);
            }
        });
    }

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



