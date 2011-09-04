package com.headfirstlabs.ch02.android.love;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.headfirstlabs.ch02.android.love.R;

public class HaikuActivity extends Activity {
    
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	
	public void onLoveButtonClicked(View view) { 
		TextView textView = 
			(TextView) findViewById(R.id.haikuTextView);
		textView.setText(R.string.haiku);
	}
	
}