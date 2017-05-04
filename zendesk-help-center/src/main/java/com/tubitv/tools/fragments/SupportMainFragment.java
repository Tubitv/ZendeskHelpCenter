package com.tubitv.tools.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.tubitv.tools.adapters.SupportPlatformAdapter;
import com.tubitv.tools.databinding.FragmentSupportMainBinding;

/**
 * The main support fragment that the user sees first. This fragment contains a
 * {@link android.widget.GridView} with all the supported platforms of tubi tv. Information
 * for FAQ comes form Zendesk
 * <p>
 * Created by stoyan on 11/4/16.
 */
public class SupportMainFragment extends Fragment {
    /**
     * Tag for logging
     */
    private static final String TAG = SupportMainFragment.class.getSimpleName();

    /**
     * Used to save the state of the {@link android.widget.GridView}
     * during configuration changes
     */
    private @Nullable
    Parcelable mGridState;

    /**
     * The data binding for this fragment
     */
    private FragmentSupportMainBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentSupportMainBinding.inflate(inflater, container, false);
        setGridview();
        return mBinding.getRoot();
    }

    @Override
    public void onPause() {
        // Save ListView scroll and selected states
        mGridState = mBinding.fragmentSupportMainGrid.onSaveInstanceState();
        super.onPause();
    }

    /**
     * Initializes the {@link android.widget.GridView} with {@link SupportPlatformAdapter},
     * and sets a click listener that launches {@link SupportSectionFragment} with the selected
     * platforms FAQ from Zendesk
     */
    private void setGridview() {
        mBinding.fragmentSupportMainGrid.setAdapter(new SupportPlatformAdapter(getActivity()));
        // Restore previous state (including selected item index and scroll position)
        if(mGridState != null) {
            mBinding.fragmentSupportMainGrid.onRestoreInstanceState(mGridState);
        }
        mBinding.fragmentSupportMainGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Log.d(TAG, "grid view item clicked : " + position);
                SupportSectionFragment sectionFragment = new SupportSectionFragment();
                Bundle bundle = new Bundle();
//                ZendeskCategory.ID category = ZendeskCategory.ID.getCategoryByPosition(position);
//                bundle.putInt(ZendeskSection.CATEGORY_ID_KEY, category.getCategoryId());
                sectionFragment.setArguments(bundle);

//                EventBus.getDefault().post(new SupportCategoryClickEvent(sectionFragment, category));
            }
        });
    }
}
