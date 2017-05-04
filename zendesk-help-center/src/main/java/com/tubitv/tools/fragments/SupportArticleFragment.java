package com.tubitv.tools.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.tubitv.tools.api.SupportArticle;
import com.tubitv.tools.databinding.FragmentSupportArticleBinding;

/**
 * Fragment that shows the {@link SupportArticle#getBody()} html
 * in a {@link WebView}
 * <p>
 * Created by stoyan on 11/14/16.
 */
public class SupportArticleFragment extends Fragment {
    /**
     * Tag for logging
     */
    private static final String TAG = SupportArticleFragment.class.getSimpleName();

    /**
     * Styling html that we add to {@link SupportArticle#getBody()} to meet design requirements
     */
    private static final String BODY_STYLING = "<style type=\"text/css\">body{color: #ffffff; background-color: #000000;}</style>";

    /**
     * A key for {@link #onSaveInstanceState(Bundle)} for {@link #mArticleId}
     */
    private static final String SAVE_STATE_ARTICLE_ID = "article_id";

    /**
     * The id of the article to display
     */
    private int mArticleId;

    /**
     * The article to display
     */
    private SupportArticle mArticle;

    /**
     * The data binding for this fragment
     */
    private FragmentSupportArticleBinding mBinding;

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        if (args != null) {
//            mArticleId = args.getInt(ZendeskArticle.ID_KEY);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentSupportArticleBinding.inflate(inflater, container, false);
        mBinding.setFragment(this);
        loadArticle(savedInstanceState);
        return mBinding.getRoot();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt(SAVE_STATE_ARTICLE_ID, mArticleId);
        super.onSaveInstanceState(outState);
    }

    /**
     * Loads the {@link SupportArticle} from {@link CdnManager} and passes it
     * to {@link #showArticle(RealmResults)} to be displayed
     */
    private void loadArticle(Bundle savedInstanceState) {
        //Check if article id was saved in a previous instance
        if (savedInstanceState != null) {
            int articleId = savedInstanceState.getInt(SAVE_STATE_ARTICLE_ID);
            if (articleId != 0) {
                mArticleId = articleId;
            }
        }

        if (mArticleId != 0) {
//            CdnManager.getArticle(mArticleId, new ZendeskRealmInterface.OnArticles() {
//                @Override
//                public void onArticles(@NonNull RealmResults<ZendeskArticle> realmResults) {
//                    TubiLog.d(TAG, "Got the sections !");
//                    showArticle(realmResults);
//                }
//            });
        }
    }

    /**
     * Displays the {@link ZendeskArticle#getBody()} html, after adding {@link #BODY_STYLING} to the html,
     * in a {@link WebView} that is added to {@link FragmentSupportArticleBinding#fragmentSupportArticleLl}
     *
     * @param realmResults The database search result
     */
//    private void showArticle(@NonNull RealmResults<ZendeskArticle> realmResults) {
//        mArticle = realmResults.first();
//        if (mArticle != null && mArticle.getBody() != null) {
//            WebView webView = new WebView(getActivity());
//            webView.loadData(BODY_STYLING + mArticle.getBody(), "text/html; charset=utf-8", "UTF-8");
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//            webView.setBackgroundColor(getActivity().getResources().getColor(R.color.black));
//            mBinding.fragmentSupportArticleLl.addView(webView, params);
//        }
//    }

    /**
     * {@link View.OnClickListener} method for the {@link FragmentSupportArticleBinding#fragmentSupportArticleFab}
     *
     * @param fabView The action button
     */
    public void onActionButtonClick(View fabView) {
//        if (mArticle != null) {
//            EventBus.getDefault().post(new SupportFeedbackEvent(mArticle));
//        }
    }
}
