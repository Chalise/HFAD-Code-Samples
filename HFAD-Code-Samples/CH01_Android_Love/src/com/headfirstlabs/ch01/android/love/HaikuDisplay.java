package com.headfirstlabs.ch01.android.love;

import android.app.Activity;
import android.os.Bundle;

import com.headfirstlabs.ch01.android.love.R;

public class HaikuDisplay extends Activity {
    
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
}