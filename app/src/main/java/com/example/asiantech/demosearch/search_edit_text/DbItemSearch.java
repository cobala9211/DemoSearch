package com.example.asiantech.demosearch.search_edit_text;

/**
 * Copyright © 2017 AsianTech inc.
 * Created by phuongdn on 06/02/2017.
 */
public class DbItemSearch {
    private String title;
    private int imgIcon;

    public DbItemSearch(String title, int imgIcon) {
        this.title = title;
        this.imgIcon = imgIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgIcon() {
        return imgIcon;
    }

    public void setImgIcon(int imgIcon) {
        this.imgIcon = imgIcon;
    }
}
