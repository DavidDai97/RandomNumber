package com.example.android.randomnumbergenerater;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class backgroundSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        ArrayList<Images> imageList = new ArrayList<Images>();
        imageList.add(new Images(R.drawable.background, "First Background"));
        imageList.add(new Images(R.drawable.background_2, "Second Background"));
        imageList.add(new Images(R.drawable.background_3, "Third Background"));
        imageList.add(new Images(R.drawable.background_4, "Fourth Background"));
        imageList.add(new Images(R.drawable.background_5, "Fifth Background"));

        ImagesAdapter adapter = new ImagesAdapter(this, imageList);
        ListView listView = (ListView) findViewById(R.id.reset_list_view);
        listView.setAdapter(adapter);

	    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		    @Override
		    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			    Images currentImage = (Images) parent.getItemAtPosition(position);
			    Intent setBackground = new Intent(backgroundSettingsActivity.this, MainActivity.class);
			    setBackground.putExtra("backgroundResource", currentImage.getmImageResourceId());
			    startActivity(setBackground);
		    }
	    });
    }
}
