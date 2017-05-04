package com.tubitv.tools.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tubitv.tools.adapters.SupportSectionAdapter;
import com.tubitv.tools.api.SupportSections;
import com.tubitv.tools.databinding.FragmentSupportSectionBinding;


/**
 * This fragment shows all the {@link com.tubitv.tools.api.SupportSection}s for a {@link com.tubitv.tools.api.SupportCategory}
 * with links to all of their {@link com.tubitv.tools.api.SupportArticle}s
 * <p>
 * Created by stoyan on 11/10/16.
 */
public class SupportSectionFragment extends Fragment {
    /**
     * Tag for logging
     */
    private static final String TAG = SupportSectionFragment.class.getSimpleName();

    /**
     * A key for {@link #onSaveInstanceState(Bundle)} for {@link #mCategory}
     */
    private static final String SAVE_STATE_CATEGORY_ID = "article_id";

    /**
     * The id of the category whose sections we are to display
     */
//    private ZendeskCategory.ID mCategory = ZendeskCategory.ID.ANDROID;

    /**
     * The data binding for this fragment
     */
    private FragmentSupportSectionBinding mBinding;

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        if (args != null) {
//            mCategory = ZendeskCategory.ID.getCateforyById(args.getInt(ZendeskSection.CATEGORY_ID_KEY));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentSupportSectionBinding.inflate(inflater, container, false);
        mBinding.setFragment(this);
        loadSections(savedInstanceState);
        return mBinding.getRoot();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
//        if (mCategory != null) {
//            outState.putSerializable(SAVE_STATE_CATEGORY_ID, mCategory.getCategoryId());
//        }
        super.onSaveInstanceState(outState);
    }

    /**
     * Loads the {@link com.tubitv.tools.api.SupportSection}s from the database and passes them to
     * {@link #showSections(RealmResults)} to be displayed
     */
    private void loadSections(@Nullable Bundle savedInstanceState) {
        //Check if category was saved in a previous instance
        if (savedInstanceState != null) {
            int categoryId = savedInstanceState.getInt(SAVE_STATE_CATEGORY_ID);
            if (categoryId != 0) {
//                mCategory = ZendeskCategory.ID.getCateforyById(categoryId);
            }
        }

//        CdnManager.getSections(mCategory, new ZendeskRealmInterface.OnSections() {
//            @Override
//            public void onSections(final @NonNull RealmResults<ZendeskSection> realmResults) {
//                TubiLog.d(TAG, "Got the sections !");
//                showSections(realmResults);
//            }
//        });
    }

    /**
     * Displays the {@link com.tubitv.tools.api.SupportSection}s on the {@link FragmentSupportSectionBinding#fragmentSupportSectionListView}
     *
     * @param section The sections to display
     */
    private void showSections(@NonNull SupportSections sections) {
//        mBinding.fragmentSupportSectionListView.setAdapter(new SupportSectionAdapter(getActivity(), sections));
    }

    /**
     * {@link View.OnClickListener} method for the {@link FragmentSupportSectionBinding#fragmentSupportSectionFab}
     *
     * @param fabView The action button
     */
    public void onActionButtonClick(View fabView) {
//        if (mCategory != null) {
//            EventBus.getDefault().post(new SupportFeedbackEvent(mCategory));
//        }
    }
}
