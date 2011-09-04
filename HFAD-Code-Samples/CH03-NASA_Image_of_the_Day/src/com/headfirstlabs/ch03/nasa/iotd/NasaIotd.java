package com.headfirstlabs.ch03.nasa.iotd;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NasaIotd extends Activity {
	private static final String URL = "http://www.nasa.gov/rss/image_of_the_day.rss";
	private IotdHandler iotdHandler;
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iotdHandler = new IotdHandler();
        try {
	        iotdHandler.processFeed(this, new URL(URL));
	        resetDisplay(iotdHandler.getTitle(), iotdHandler.getDate(), iotdHandler.getUrl(), iotdHandler.getDescription());
	    } catch (Exception e) { 
	    	e.printStackTrace();
	    }
	}
    
	private void resetDisplay(String title, String date, String imageUrl, String description) { 
		TextView titleView = (TextView)findViewById(R.id.imageTitle);
		titleView.setText(title);
		
		TextView dateView = (TextView)findViewById(R.id.imageDate);
		dateView.setText(date);
		
		ImageView imageView =  (ImageView)findViewById(R.id.imageDisplay);
		imageView.setImageBitmap(getBitmap(imageUrl));
		
		TextView descriptionView = (TextView)findViewById(R.id.imageDescription);
		descriptionView.setText(description);
	}
	
	private Bitmap getBitmap(String url) {
		try { 
			HttpURLConnection connection = (HttpURLConnection)new URL(url).openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap bitmap = BitmapFactory.decodeStream(input);
			input.close();
			connection.disconnect();
			return bitmap;
		} catch (IOException ioe) {
			return null;
		}
	}
    
}