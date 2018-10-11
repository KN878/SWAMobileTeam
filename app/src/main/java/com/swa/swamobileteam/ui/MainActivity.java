package com.swa.swamobileteam.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.swa.swamobileteam.R;
import com.swa.swamobileteam.ui.deliveryGroups.DeliveryGroupsContract;
import com.swa.swamobileteam.ui.deliveryGroups.view.PagerAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements DeliveryGroupsContract.View {

    @BindView(R.id.toolbar_main)
    Toolbar toolbar;
    @BindView(R.id.tab_layout_main)
    TabLayout tabLayout;
    @BindView(R.id.pager)
    ViewPager viewPager;

    @Inject
    DeliveryGroupsContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);
        presenter.attachView(this, true);
        viewPager.setAdapter(new PagerAdapter(this, getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        setToolbar();
    }

    private void setToolbar(){
        toolbar.setTitle(getString(R.string.text_deliveries));
        toolbar.setSubtitle(getString(R.string.text_bulater));
        toolbar.showOverflowMenu();
    }
}
