package com.swa.swamobileteam.ui.deliveryGroups.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.swa.swamobileteam.R;

public class PagerAdapter extends FragmentPagerAdapter{

    private final int TABS_COUNT = 2;

    private Context context;

    public PagerAdapter(Context context, FragmentManager manager){
        super(manager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int i) {
        return new NewDeliveriesFragment();
    }

    @Override
    public int getCount() {
        return TABS_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.text_page_new_tasks);
        } else {
            return context.getString(R.string.text_page_in_progress);
        }
    }
}
