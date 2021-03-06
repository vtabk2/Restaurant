package com.tuananh.restaurant.manager.model;

/**
 * Created by TuanAnh on 4/4/2017.
 */
public class MenuModel {
    private int mType;
    private int mIdColor;
    private int mTitle;
    private int mIdImage;

    public MenuModel(int type, int idColor, int title, int idImage) {
        mType = type;
        mIdColor = idColor;
        mTitle = title;
        mIdImage = idImage;
    }

    public int getType() {
        return mType;
    }

    public int getIdColor() {
        return mIdColor;
    }

    public int getTitle() {
        return mTitle;
    }

    public int getIdImage() {
        return mIdImage;
    }
}
