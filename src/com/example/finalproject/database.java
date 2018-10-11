package com.example.finalproject;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {
	public SQLiteDatabase db=null;
	public database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	private static final String DATABASE_NAME = "database"; //資料庫名稱
	private static final int DATABASE_VERSION = 1;
	private static final String TABLE_NAME = "mycontact"; //資料表名稱

	private static final String TABLE_CREATE =       
					"CREATE TABLE " + TABLE_NAME + " ( " +
					" name TEXT NOT NULL,"+
				    " amount TEXT NOT NULL,"+
					" date TEXT NOT NULL,"+
					" price TEXT NOT NULL, PRIMARY KEY (name));" ;
	private static final String COL_name = "name";
	private static final String COL_amount = "amount";
	private static final String COL_date = "date";
	private static final String COL_price = "price";
	
	@Override
	public void onCreate(SQLiteDatabase db)throws SQLException {   //開啟或建立資料庫
		try{
			db.execSQL(TABLE_CREATE);
		}catch(Exception e)
		{
			
		}
	} 

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, 
			int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}

	public long insertDB(String name,String amount,String date,String price){   //新增資料
		SQLiteDatabase db = getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(COL_name,name);
		values.put(COL_amount,amount);
		values.put(COL_date,date);
		values.put(COL_price,price);
		long rownam = db.insert(TABLE_NAME, null, values);
		db.close();
		return rownam;
	}

	public Cursor get() {
		SQLiteDatabase db = getWritableDatabase();
		
		Cursor c = db.rawQuery("SELECT rowid As _id,name,amount,date,price FROM " + TABLE_NAME ,null);
	  //  db.close();
		return  c;
		// TODO Auto-generated method stub
		
	}
	
	public Cursor getalldata(String name) {
		SQLiteDatabase db = getWritableDatabase();
		
		String sql = "SELECT rowid As _id,name,amount,date,price FROM " + TABLE_NAME + 
				" WHERE name=?";
        String[] args = { name };
        Cursor cursor = db.rawQuery(sql, args);
        return cursor;
		
		
	}
	public int updateDB(String nam,String name,String amo,String date,String price){
		SQLiteDatabase db = getWritableDatabase(); 
		ContentValues values = new ContentValues(); 
		values.put(COL_name, name); 
		values.put(COL_amount, amo); 
		values.put(COL_date, date); 
		values.put(COL_price, price); 
		String whereClause = COL_name + "='" + nam + "'";
		int count = db.update(TABLE_NAME, values, whereClause, null);
		db.close();
		return count;
	}
	
	public int deleteDB(String  name ){  //刪除資料
		SQLiteDatabase db = getWritableDatabase();
		String sql = "delete FROM " + TABLE_NAME + 
				" WHERE name=?";
		String[] args = { name };
		db.execSQL(sql, args);
		String whereClause = COL_name + "='" + name + "'";
		int count = db.delete(TABLE_NAME, whereClause, null);
		db.close();
		return count;
	}
	

}
