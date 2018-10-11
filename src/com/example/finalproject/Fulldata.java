package com.example.finalproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Fulldata extends Activity {
	String getname;
	static final String[] FROM=new String[] {"name","amount","date","price"};
	public database db;
	private Cursor cursor;
	EditText etName,etAmount,etDate,etPrice;
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fulldata);
		etName=(EditText)findViewById(R.id.editText1);
		etAmount=(EditText)findViewById(R.id.editText2);
		etDate=(EditText)findViewById(R.id.editText3);
		etPrice=(EditText)findViewById(R.id.editText4);
		Bundle getbundle =this.getIntent().getExtras();
		getname=getbundle.getString("name");
		db = new database(getApplicationContext());
		cursor=db.getalldata(getname);
		cursor.moveToFirst();		
        etAmount.setText(cursor.getString(2));
        etName.setText(cursor.getString(1));
        etDate.setText(cursor.getString(3));
        etPrice.setText(cursor.getString(4));
	}
	
	public void updatedata(View v){
		String nam=etName.getText().toString().trim();
		String amo=etAmount.getText().toString().trim();
		String dat=etDate.getText().toString().trim();
		String pri=etPrice.getText().toString().trim();
		if(nam.length()==0 ){ 
			Toast.makeText(this,"�m�W��������J���!!",Toast.LENGTH_SHORT).show();
			return;}
		int count=db.updateDB(getname,nam,amo,dat,pri);
		if(count==1)
		{
			Toast.makeText(this,"�ק令�\",Toast.LENGTH_SHORT).show();
		}
		Intent it = new Intent(this, MainActivity.class); //�إ� Intent �ó]�w�ؼ� Activity
		it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(it); // �Ұ� Intent �����ؼ� 
	}
	
	public void deletedata(View v){	// �R���s��On Click�ƥ��k
		db.deleteDB(getname);
		Toast.makeText(this, "�w�R�����", Toast.LENGTH_SHORT).show();
		Intent it = new Intent(this,Search.class); //�إ� Intent �ó]�w�ؼ� Activity
		it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(it); // �Ұ� Intent �����ؼ� 
	}
	
	/*public void callphone(View v){	// ���q��
		String uri="tel:" + getname;
		Intent it = new Intent(Intent.ACTION_VIEW,Uri.parse(uri));  
		startActivity(it);
	}*/
	
	/*public void sendmail(View v){	// �H�e�q�l�l��
		cursor.moveToFirst();	
		String uri="mailto:"+cursor.getString(3);
		Intent it = new Intent(Intent.ACTION_SENDTO, Uri.parse(uri));
		startActivity(it);
	}*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_fulldata, menu);
		return true;
	}

}
