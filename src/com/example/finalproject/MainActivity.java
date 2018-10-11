package com.example.finalproject;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	
	
	public void gotoBuy(View v){
		Intent it = new Intent(this,Buy.class);
		
		startActivity(it);
	}
	public void gotoIntroduce(View v){
		Intent it = new Intent(this,Introduce.class);
		
		startActivity(it);
	}
	public void gotoSearch(View v){
		Intent it = new Intent(this,Search.class);
		
		startActivity(it);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}


}
