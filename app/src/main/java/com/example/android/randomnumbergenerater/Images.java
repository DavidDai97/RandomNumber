package com.example.android.randomnumbergenerater;

/**
 * Created by lenovo on 2016/8/2.
 */
public class Images {
	private int mImageResourceId;
	private String mImageName;

	public Images (int id, String name){
		mImageName = name;
		mImageResourceId = id;
	}

	public int getmImageResourceId(){
		return mImageResourceId;
	}

	public String getmImageName(){
		return mImageName;
	}
}
