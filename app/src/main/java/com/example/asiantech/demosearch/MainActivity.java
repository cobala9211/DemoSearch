package com.example.asiantech.demosearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.asiantech.demosearch.search_edit_text.SearchEditTextActivity;
import com.example.asiantech.demosearch.search_float_view.SearchFloatView;
import com.example.asiantech.demosearch.search_view.SearchViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSearchEditText = (Button) findViewById(R.id.btnSearchEditText);
        btnSearchEditText.setOnClickListener(this);
        Button btnSearchView = (Button) findViewById(R.id.btnSearchView);
        btnSearchView.setOnClickListener(this);
        Button btnSearchFloatView = (Button) findViewById(R.id.btnSearchFloatView);
        btnSearchFloatView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSearchEditText:
                initActivity(SearchEditTextActivity.class);
                break;
            case R.id.btnSearchView:
                initActivity(SearchViewActivity.class);
                break;
            case R.id.btnSearchFloatView:
                initActivity(SearchFloatView.class);
                break;
            default:
                throw new IllegalStateException("not found id of view");
        }
    }

    private void initActivity(Class className) {
        Intent intent = new Intent(MainActivity.this, className);
        this.startActivity(intent);
    }
}
