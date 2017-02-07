package com.example.asiantech.demosearch.search_float_view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.example.asiantech.demosearch.R;
import com.example.asiantech.demosearch.search_float_view.fragment.BaseExampleFragment;
import com.example.asiantech.demosearch.search_float_view.fragment.ScrollingSearchExampleFragment;
import com.example.asiantech.demosearch.search_float_view.fragment.SlidingSearchResultsExampleFragment;
import com.example.asiantech.demosearch.search_float_view.fragment.SlidingSearchViewExampleFragment;

import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 06/02/2017.
 */
public class SearchFloatView extends AppCompatActivity implements BaseExampleFragment.BaseExampleFragmentCallbacks, NavigationView.OnNavigationItemSelectedListener{

    private final String TAG = "MainActivity";

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_float_view);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        showFragment(new SlidingSearchResultsExampleFragment());
    }

    @Override
    public void onAttachSearchViewToDrawer(FloatingSearchView searchView) {
        searchView.attachNavigationDrawerToMenuButton(mDrawerLayout);
    }

    @Override
    public void onBackPressed() {
        List fragments = getSupportFragmentManager().getFragments();
        BaseExampleFragment currentFragment = (BaseExampleFragment) fragments.get(fragments.size() - 1);

        if (!currentFragment.onActivityBackPress()) {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        mDrawerLayout.closeDrawer(GravityCompat.START);
        switch (menuItem.getItemId()) {
            case R.id.sliding_list_example:
                showFragment(new SlidingSearchResultsExampleFragment());
                return true;
            case R.id.sliding_search_bar_example:
                showFragment(new SlidingSearchViewExampleFragment());
                return true;
            case R.id.scrolling_search_bar_example:
                showFragment(new ScrollingSearchExampleFragment());
                return true;
            default:
                return true;
        }
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment).commit();
    }
}