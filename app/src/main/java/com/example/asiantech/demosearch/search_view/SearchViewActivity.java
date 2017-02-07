package com.example.asiantech.demosearch.search_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.asiantech.demosearch.R;
import com.example.asiantech.demosearch.search_edit_text.DbItemSearch;
import com.example.asiantech.demosearch.search_edit_text.SearchEditTextAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 06/02/2017.
 */
public class SearchViewActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private SearchView mSearchView;
    private RecyclerView mRecyclerView;
    private SearchEditTextAdapter mAdapter;
    private List<DbItemSearch> mListItemSearch = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        createData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclverViewSearchView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new SearchEditTextAdapter(mListItemSearch);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_view, menu);
        MenuItem itemSearch = menu.findItem(R.id.mnItemSearchView);
        mSearchView = (SearchView) itemSearch.getActionView();
        mSearchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.d("TAG11", "onQueryTextChange: " + newText);
        if (null != newText) {
            String mInputString = newText.toString();
            mAdapter.filterSearchList(mInputString);
        }
        return true;
    }

    private void createData() {
        DbItemSearch item1 = new DbItemSearch("tran a", 1);
        mListItemSearch.add(item1);
        DbItemSearch item2 = new DbItemSearch("nguyen b", 2);
        mListItemSearch.add(item2);
        DbItemSearch item3 = new DbItemSearch("phan c", 3);
        mListItemSearch.add(item3);
        DbItemSearch item4 = new DbItemSearch("pham d", 4);
        mListItemSearch.add(item4);
        DbItemSearch item5 = new DbItemSearch("tran e", 5);
        mListItemSearch.add(item5);
        DbItemSearch item6 = new DbItemSearch("nguyen f", 6);
        mListItemSearch.add(item6);
        DbItemSearch item7 = new DbItemSearch("tran t", 7);
        mListItemSearch.add(item7);
        DbItemSearch item8 = new DbItemSearch("tran a", 1);
        mListItemSearch.add(item8);
        DbItemSearch item9 = new DbItemSearch("nguyen b", 2);
        mListItemSearch.add(item9);
        DbItemSearch item10 = new DbItemSearch("phan c", 3);
        mListItemSearch.add(item10);
        DbItemSearch item11 = new DbItemSearch("pham d", 4);
        mListItemSearch.add(item11);
        DbItemSearch item12 = new DbItemSearch("tran e", 5);
        mListItemSearch.add(item12);
        DbItemSearch item13 = new DbItemSearch("nguyen f", 6);
        mListItemSearch.add(item13);
        DbItemSearch item14 = new DbItemSearch("tran t", 7);
        mListItemSearch.add(item14);
    }
}
