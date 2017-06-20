package com.example.android.internship;

/**
 * Created by hatim on 6/6/2017.
 */

public class Items {
    private String mItemName;
    private int mImageId;

    public  Items(String ItemName,int ImageId)
    {
        mItemName=ItemName;
        mImageId=ImageId;

    }

    public String getItemName()
    {return mItemName;}

    public int getImageId() {
        return mImageId;
    }
}
