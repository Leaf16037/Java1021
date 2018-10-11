package com.example.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.database.Cursor;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Buy extends Activity {

	public database db=null;
    private EditText objshow_Ch01_Ex02_EditText01OBJ ;
    private EditText objshow_Ch01_Ex02_EditText02OBJ ;
    private EditText objshow_Ch01_Ex02_EditText03OBJ ;
    private EditText objshow_Ch01_Ex02_EditText04OBJ ;
    
    private Button objshow_Ch01_Ex02_Button01OBJ ;    
    private Button objshow_Ch01_Ex02_Button02OBJ ;   
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
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);

		
		objshow_Ch01_Ex02_EditText01OBJ = 
				(EditText) findViewById(R.id.show_Ch01_Ex02_EditText01) ;
		objshow_Ch01_Ex02_EditText02OBJ = 
				(EditText) findViewById(R.id.show_Ch01_Ex02_EditText02) ;
		objshow_Ch01_Ex02_EditText03OBJ = 
				(EditText) findViewById(R.id.show_Ch01_Ex02_EditText03) ;
		objshow_Ch01_Ex02_EditText04OBJ = 
				(EditText) findViewById(R.id.show_Ch01_Ex02_EditText04) ;

		db = new database(getApplicationContext());
		
		objshow_Ch01_Ex02_Button01OBJ = 
				(Button) findViewById(R.id.show_Ch01_Ex02_Button01) ;
		objshow_Ch01_Ex02_Button01OBJ.setOnClickListener(
				new Button.OnClickListener(){  
			    @Override 
			    public void onClick(View v) {
			    	objshow_Ch01_Ex02_EditText01OBJ.setText("") ;
			    	objshow_Ch01_Ex02_EditText02OBJ.setText("") ;
			    	objshow_Ch01_Ex02_EditText03OBJ.setText("") ;
			    	objshow_Ch01_Ex02_EditText04OBJ.setText("") ;
			    	
			    }         
			 });   
		objshow_Ch01_Ex02_Button02OBJ = 
				(Button) findViewById(R.id.show_Ch01_Ex02_Button02) ;
		objshow_Ch01_Ex02_Button02OBJ.setOnClickListener(
				new Button.OnClickListener(){  
				    @Override 
				    public void onClick(View v) {
				    	
				    	String d1 = objshow_Ch01_Ex02_EditText01OBJ.getText().toString().trim();
						String d2 = objshow_Ch01_Ex02_EditText02OBJ.getText().toString().trim();
						String d3 = objshow_Ch01_Ex02_EditText03OBJ.getText().toString().trim();
						String d4 = objshow_Ch01_Ex02_EditText04OBJ.getText().toString().trim();
						if(d1.length()==0 || d3.length()==0|| d4.length()==0|| d2.length()==0)
						{
						Toast.makeText(Buy.this, "資料必須輸入完整", Toast.LENGTH_SHORT).show();
						return;
						}
						
						long rownam = db.insertDB(d1,d2,d3,d4);	
						
						if(rownam != -1){  
							Toast.makeText(Buy.this, "新增成功", 
									Toast.LENGTH_SHORT).show();
						}else{
							Toast.makeText(Buy.this, "重複輸入!", 
									Toast.LENGTH_SHORT).show();
						}
				    	objshow_Ch01_Ex02_EditText01OBJ.setText("") ;
				    	objshow_Ch01_Ex02_EditText02OBJ.setText("") ;
				    	objshow_Ch01_Ex02_EditText03OBJ.setText("") ;
				    	objshow_Ch01_Ex02_EditText04OBJ.setText("") ;
				    /*	Toast.makeText(Android4Chapt01_Example_02.this ,
				    	   objshow_Ch01_Ex02_EditText01OBJ.getText().toString().trim()
				    	   , Toast.LENGTH_LONG ).show() ;
				    	Toast.makeText(Android4Chapt01_Example_02.this ,
						    	   objshow_Ch01_Ex02_EditText02OBJ.getText().toString().trim()
						    	   , Toast.LENGTH_LONG ).show() ;
				    	Toast.makeText(Android4Chapt01_Example_02.this ,
						    	   objshow_Ch01_Ex02_EditText03OBJ.getText().toString().trim()
						    	   , Toast.LENGTH_LONG ).show() ;
				    	Toast.makeText(Android4Chapt01_Example_02.this ,
						    	   objshow_Ch01_Ex02_EditText04OBJ.getText().toString().trim()
						    	   , Toast.LENGTH_LONG ).show() ;
				    	Toast.makeText(Android4Chapt01_Example_02.this ,
						    	   objshow_Ch01_Ex02_EditText05OBJ.getText().toString().trim()
						    	   , Toast.LENGTH_LONG ).show() ;*/
				    	
				    }         
				 });   
	}
	
	/*public void show_Ch01_Ex02_Button02(View v){
		String d1 = objshow_Ch01_Ex02_EditText01OBJ.getText().toString().trim();
		String d2 = objshow_Ch01_Ex02_EditText02OBJ.getText().toString().trim();
		String d3 = objshow_Ch01_Ex02_EditText03OBJ.getText().toString().trim();
		String d4 = objshow_Ch01_Ex02_EditText04OBJ.getText().toString().trim();
		if(d1.length()==0 || d3.length()==0)
		{
		Toast.makeText(this, "姓名與手機必須輸入", Toast.LENGTH_SHORT).show();
		return;
		}
		long rownam = db.insertDB(d1,d2,d3,d4);		
		if(rownam != -1){  
			Toast.makeText(Buy.this, "新增成功", 
					Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(Buy.this, "重複輸入!", 
					Toast.LENGTH_SHORT).show();
		}
    	objshow_Ch01_Ex02_EditText01OBJ.setText("") ;
    	objshow_Ch01_Ex02_EditText02OBJ.setText("") ;
    	objshow_Ch01_Ex02_EditText03OBJ.setText("") ;
    	objshow_Ch01_Ex02_EditText04OBJ.setText("") ;
	}
	*/
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_buy,
				menu);
		return true;
	}


}
