package com.example.paras.latticeinnovations.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UserManager.db";

    private static final String TABLE_NAME = "user";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_NUMBER = "number";
    private static final String COLUMN_PASSWORD = "password";

    SQLiteDatabase db;
    //private static final String CREATE_USER_TABLE = CREATE TABLE `User` (
//            `ID`	INTEGER PRIMARY KEY AUTOINCREMENT,
//	`NAME`	TEXT NOT NULL,
//            `ADDRESS`	TEXT NOT NULL,
//            `EMAIL`	TEXT,
//            `NUMBER`	INTEGER,
//            `PASSWORD`	INTEGER
//);
////

//              "CREATE TABLE " + TABLE_NAME + "("
//            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//             + COLUMN_NAME + " TEXT," + COLUMN_ADDRESS + "TEXT," + COLUMN_EMAIL + " TEXT," + COLUMN_NUMBER + "TEXT," + COLUMN_PASSWORD + " TEXT" + ")";

    //+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 3, new DatabaseErrorHandler() {
            @Override
            public void onCorruption(SQLiteDatabase dbObj) {
                Log.d("--------","Database open error");
            }
        });
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE `User` (\n" +
                "\t`ID`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`NAME`\tTEXT NOT NULL,\n" +
                "\t`ADDRESS`\tTEXT NOT NULL,\n" +
                "\t`EMAIL`\tTEXT,\n" +
                "\t`NUMBER`\tINTEGER,\n" +
                "\t`PASSWORD`\tINTEGER\n" +
                ");");
       // db.execSQL(CREATE_USER_TABLE);
        this.db = db;

    }

    public boolean insertData(String name,String address,String email,String number,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME,name);
        contentValues.put(COLUMN_ADDRESS,address);
        contentValues.put(COLUMN_EMAIL,email);
        contentValues.put(COLUMN_NUMBER,number);
        contentValues.put(COLUMN_PASSWORD,password);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

//    public void insertUser(User u)
//    {
//        db=this.getWritableDatabase();
//        ContentValues values = new ContentValues();
////
//        String query = "Select * from users";
//        Cursor cursor = db.rawQuery(query,null);
//        int count = cursor.getCount();
//
      //  values.put(COLUMN_ID, u.getId());
//        values.put(COLUMN_NAME, u.getName());
//        values.put(COLUMN_ADDRESS, u.getAddress());
//        values.put(COLUMN_EMAIL, u.getEmail());
//        values.put(COLUMN_NUMBER, u.getNumber());
//        values.put(COLUMN_PASSWORD, u.getPassword());
//
//        db.insert(TABLE_NAME, null, values);
//        db.close();
//
//    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String query = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
    public Cursor getAllData(){
        db=this.getWritableDatabase();
        Cursor c =db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return c;
    }
}
