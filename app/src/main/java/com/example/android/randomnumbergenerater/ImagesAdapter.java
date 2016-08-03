package com.example.android.randomnumbergenerater;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lenovo on 2016/8/2.
 */
public class ImagesAdapter extends ArrayAdapter<Images> {

	public ImagesAdapter(Activity context, ArrayList<Images> images) {
		super(context, 0, images);
	}

	@Override

	public View getView(int position, View convertView, ViewGroup parent) {
		View listView = convertView;
		if (listView == null) {
			listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
		}

		Images currentImage = getItem(position);

		ImageView backgroundImage = (ImageView) listView.findViewById(R.id.image);
		backgroundImage.setImageResource(currentImage.getmImageResourceId());

		TextView textView = (TextView) listView.findViewById(R.id.checkbox);
		textView.setText(currentImage.getmImageName());

		return listView;
	}
}
