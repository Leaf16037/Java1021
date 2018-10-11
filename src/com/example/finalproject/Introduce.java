package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Introduce extends Activity {

	static final String[] FROM=new String[] {"name","amount","date","price"};
	public database db;
	private Cursor cursor;
	private SimpleCursorAdapter adapter;
	ListView lv;
	
	@Override
	public void onResume() {
		super.onResume();
		if(db == null)
			db = new database(this); 
	}

	@Override
	public void onPause() {
		super.onPause();
		if(db != null){
			db.close(); 
			db = null;
		}
	}
	/*public void golist(View v){
		Intent it = new Intent(this, Listview.class); //建立 Intent 並設定目標 Activity
		 startActivity(it);
	}*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_introduce);
		
		lv=(ListView)findViewById(R.id.listView1);
		db = new database(getApplicationContext());
		
		cursor=db.get();
		
		   adapter=new SimpleCursorAdapter(this, 
	        		R.layout.item, cursor, 
	        		FROM, 
	        		new int[] {R.id.name,R.id.amount,R.id.date,R.id.price}, 0);//只能做顯示，處理要轉成array
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				Intent it = new Intent(Introduce.this, Fulldata.class); //建立 Intent 並設定目標 Activity
				Cursor cursor = (Cursor)lv.getItemAtPosition(arg2);
				String name =cursor.getString(cursor.getColumnIndexOrThrow("name"));
				 Bundle bundle1=new Bundle();
				 bundle1.putString("name", name);
				 it.putExtras(bundle1);
				 startActivity(it);
		        
				 
			}
			
		}); 
	}


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_introduce, menu);
		return true;
	}

}
