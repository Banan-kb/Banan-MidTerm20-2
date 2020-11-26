package com.example.banan_midterm20;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "people.db";
    public static final String TABLE_NAME = "people_info";
    public static final String COL1 = "ID";
    public static final String COL2 = "FIRST_NAME";
    public static final String COL3 = "LAST_NAME";
    public static final String COL4 = "PHONE";
    public static final String COL5 = "NATIONAL_ID";

    /* Constructor */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /* Code runs automatically when the dB is created */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " FIRST_NAME TEXT, LAST_NAME TEXT, PHONE TEXT, NATIONAL_ID TEXT)";

        db.execSQL(createTable);
    }

    /* Every time the dB is updated (or upgraded) */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /* Basic function to add data. REMEMBER: The fields
       here, must be in accordance with those in
       the onCreate method above.
    */
    public boolean addData(String firstName, String lastName, String phone, String nID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, firstName);
        contentValues.put(COL3, lastName);
        contentValues.put(COL4, phone);
        contentValues.put(COL5, nID);



        long result = db.insert(TABLE_NAME, null, contentValues);

        //if data are inserted incorrectly, it will return -1
        if(result == -1) {return false;} else {return true;}
    }



    public Integer deleteData (String nID){
        SQLiteDatabase db= this.getWritableDatabase();

        return db.delete(TABLE_NAME, "NATIONAL_ID = ?", new String[]{nID});

    }

    /* Returns only one result */
    public Cursor structuredQuery() {
        SQLiteDatabase db = this.getReadableDatabase(); // No need to write
         Cursor cursor = db.rawQuery("SELECT FIRST_NAME, LAST_NAME, PHONE, NATIONAL_ID FROM " + TABLE_NAME, null);
        //Cursor cursor = db.query(TABLE_NAME, new String[]{COL1, COL2, COL3, COL4, COL5},
               // COL1 + "=?", new String[]{String.valueOf(ID)},
                //null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }


    public Cursor getSpecificResult(String nID){
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor data = db.query(TABLE_NAME, new String[]{COL1,
                COL2, COL3, COL4}, COL5+"=?", new String[]{nID}, null, null, null, null);

        if (data != null)
            data.moveToFirst();

        return data;
    }

    // Return everything inside the dB
    public Cursor getListContents() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}
