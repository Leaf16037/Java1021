package com.example.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.finalproject.database;

public class Search extends Activity{
	
	public database db=null;
    private EditText objshow_Ch01_Ex02_EditText01OBJ ;
    private EditText objshow_Ch01_Ex02_EditText02OBJ ;
    private EditText objshow_Ch01_Ex02_EditText03OBJ ;
    private EditText objshow_Ch01_Ex02_EditText04OBJ ;
    
    private Button objshow_Ch01_Ex02_Button01OBJ ;    
    private Button objshow_Ch01_Ex02_Button02OBJ ;   
    private Button objshow_Ch01_Ex02_Button03OBJ ;  
    
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
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
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
				    	
				    	if(d1.length()==0)
						{
						Toast.makeText(Search.this, "�ж�J�w�X�f���f��", Toast.LENGTH_SHORT).show();
						return;
						}
				    	db.deleteDB(d1);
				    	int rownam = db.deleteDB(d1);	
						
						//if(rownam > 0){  
							Toast.makeText(Search.this, "�w�R�����", Toast.LENGTH_SHORT).show();
						/*}else{
							Toast.makeText(Search.this, "�L�����,�ЦA��J�@��!", 
									Toast.LENGTH_SHORT).show();
						}*/
						
						Intent it = new Intent(Search.this,Search.class); //�إ� Intent �ó]�w�ؼ� Activity
						it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(it); // �Ұ� Intent �����ؼ� 
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
		objshow_Ch01_Ex02_Button03OBJ = 
				(Button) findViewById(R.id.button1) ;
		objshow_Ch01_Ex02_Button03OBJ.setOnClickListener(
				new Button.OnClickListener(){  
			    @Override 
			    public void onClick(View v) {
			    	String nam=objshow_Ch01_Ex02_EditText01OBJ.getText().toString().trim();
					String amo=objshow_Ch01_Ex02_EditText02OBJ.getText().toString().trim();
					String dat=objshow_Ch01_Ex02_EditText03OBJ.getText().toString().trim();
					String pri=objshow_Ch01_Ex02_EditText04OBJ.getText().toString().trim();
					String getname=objshow_Ch01_Ex02_EditText01OBJ.getText().toString().trim();
					if(nam.length()==0 ){ 
						Toast.makeText(Search.this,"�f�~�W�٬�������J���!!",Toast.LENGTH_SHORT).show();
						return;}
					int count=db.updateDB(getname,nam,amo,dat,pri);
					if(count==1)
					{
						Toast.makeText(Search.this,"�ק令�\",Toast.LENGTH_SHORT).show();
					}
					else
					{
						Toast.makeText(Search.this,"��ƿ�J������",Toast.LENGTH_SHORT).show();
					}
					Intent it = new Intent(Search.this, Search.class); //�إ� Intent �ó]�w�ؼ� Activity
					it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(it); // �Ұ� Intent �����ؼ� 
			    	
			    	
			    	objshow_Ch01_Ex02_EditText01OBJ.setText("") ;
			    	objshow_Ch01_Ex02_EditText02OBJ.setText("") ;
			    	objshow_Ch01_Ex02_EditText03OBJ.setText("") ;
			    	objshow_Ch01_Ex02_EditText04OBJ.setText("") ;
			    	
			    }         
			 });   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_search,
				menu);
		return true;
	}

}
