package com.example.asiantech.demosearch.search_edit_text;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asiantech.demosearch.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 06/02/2017.
 */
public class SearchEditTextActivity extends AppCompatActivity implements View.OnClickListener {
    private SearchEditTextAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<DbItemSearch> mListItemSearch = new ArrayList<>();
    private EditText mEdtInputSearch;
    private ImageView mImgSearch;
    private ImageView mImgClose;
    private TextView mTvTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_edittext);
        createData();
        initRecyclerView();
        addActionSearch();
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.rvSearchEditText);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new SearchEditTextAdapter(mListItemSearch);
        mRecyclerView.setAdapter(mAdapter);
        mEdtInputSearch = (EditText) findViewById(R.id.edtInputSearch);
        mImgClose = (ImageView) findViewById(R.id.imgClose);
        mImgClose.setOnClickListener(this);
        mImgSearch = (ImageView) findViewById(R.id.imgSearch);
        mImgSearch.setOnClickListener(this);
        mTvTitle = (TextView) findViewById(R.id.tvTitleSearch);
    }

    private void addActionSearch() {
        mEdtInputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (null != mEdtInputSearch) {
                    String mInputString = mEdtInputSearch.getText().toString();
                    mAdapter.filterSearchList(mInputString);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgSearch:
                searchAction();
                break;
            case R.id.imgClose:
                closeAction();
                break;
            default:
                throw new IllegalStateException("not found id of view");
        }
    }

    private void searchAction() {
        mImgClose.setVisibility(View.VISIBLE);
        mEdtInputSearch.setVisibility(View.VISIBLE);
        mTvTitle.setVisibility(View.GONE);
        mImgSearch.setVisibility(View.GONE);
        Log.d("TAG11", "on click search");
    }

    private void closeAction() {
        mImgClose.setVisibility(View.GONE);
        mEdtInputSearch.setVisibility(View.GONE);
        mTvTitle.setVisibility(View.VISIBLE);
        mImgSearch.setVisibility(View.VISIBLE);
        mAdapter.filterSearchList(null);
        Log.d("TAG11", "close onclick");
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
