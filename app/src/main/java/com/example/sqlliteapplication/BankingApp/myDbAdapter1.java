package com.example.sqlliteapplication.BankingApp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class myDbAdapter1 {
    myDbHelper myhelper;

    public myDbAdapter1(Context context)
    {
        myhelper = new myDbHelper(context);
    }

    public long insertData(String name, String Email , String Balance)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.EMAIL, Email);
        contentValues.put(myDbHelper.BALANCE, Balance);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    Cursor readallData()
    {
        String query = "SELECT * FROM " + myDbHelper.TABLE_NAME;
        SQLiteDatabase db = this.myhelper.getReadableDatabase();

        Cursor cursor = null;
        if(db!=null)
        {
            cursor = db.rawQuery(query,null);
        }

        return cursor;
    }

    public String getData()
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.NAME,myDbHelper.EMAIL,myDbHelper.BALANCE};
        Cursor cursor =db.query(myDbHelper.TABLE_NAME,columns,null,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        while (cursor.moveToNext())
        {
            int cid =cursor.getInt(cursor.getColumnIndexOrThrow(myDbHelper.UID));
            String name =cursor.getString(cursor.getColumnIndexOrThrow(myDbHelper.NAME));
            String  email =cursor.getString(cursor.getColumnIndexOrThrow(myDbHelper.EMAIL));
            String  balance =cursor.getString(cursor.getColumnIndexOrThrow(myDbHelper.BALANCE));
            buffer.append(cid+ "   " + name + "   " + email + "   "+ balance +" \n");
        }
        return buffer.toString();
    }

    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "myDatabase2";    // Database Name
        private static final String TABLE_NAME = "myTable";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID="_id";     // Column I (Primary Key)
        private static final String NAME = "Name";    //Column II
        private static final String EMAIL = "Email";    // Column III
        private static final String BALANCE = "Balance";
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) ,"+EMAIL+" VARCHAR(255) ,"+ BALANCE +" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                Message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                Message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                Message.message(context,""+e);
            }
        }
    }

}
