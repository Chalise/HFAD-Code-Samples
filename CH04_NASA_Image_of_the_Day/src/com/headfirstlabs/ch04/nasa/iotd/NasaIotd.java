package com.headfirstlabs.ch04.nasa.iotd;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.headfristlabs.ch04.nasa.iotd.R;

public class NasaIotd extends Activity implements IotdHandlerListener {
	private final static String TAG = NasaIotd.class.getName(); 
	private static final String URL = "http://www.nasa.gov/rss/image_of_the_day.rss";
	
	Handler handler;
	ProgressDialog dialog;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        loadRssData();
	}
	
	private void loadRssData() {
		dialog = ProgressDialog.show(this, "", "Loading the Image of the Day");
		Thread th = new Thread( 
        	new Runnable() { 
        		public void run() { 
        			IotdHandler handler = new IotdHandler();
        	        handler.setListener(NasaIotd.this);
        	        try { 
        	        	handler.processFeed(NasaIotd.this, new URL(URL));
        	        } catch (Exception e) { 
        	        	e.printStackTrace();
        	        }
        		}
        	}
        );
        th.start();
	}

	public void iotdParsed(final String url, final String title, final String description, final String date) {
		handler.post(
				new Runnable() {
					public void run() {
						TextView titleView = (TextView)findViewById(R.id.imageTitle);
						titleView.setText(title);
						
						TextView dateView = (TextView)findViewById(R.id.imageDate);
						dateView.setText(date);
						
						ImageView imageView =  (ImageView)findViewById(R.id.imageDisplay);
						imageView.setImageBitmap(getBitmap(url));
						
						TextView descriptionView = (TextView)findViewById(R.id.imageDescription);
						descriptionView.setText(description);
					}
				}
		);
		dialog.dismiss();
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
			Log.e(TAG, url);
			return null;
		}
	}
 
}