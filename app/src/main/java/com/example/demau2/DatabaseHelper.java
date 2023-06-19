package com.example.demau2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "maude";
    private static final String TABLE_NAME = "sinhvien";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TEN = "ten";
    private static final String COLUMN_YOB = "yob";
    private static final String COLUMN_QUE = "que";
    private static final String COLUMN_NAMHOC = "namhoc";

    private static final String TABLE2_NAME = "lop";
    private static final String COLUMN_MOTA = "mota";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q1 = "create table " + TABLE_NAME + " (" + COLUMN_ID + " integer primary key,"
                + COLUMN_TEN + " text," + COLUMN_YOB + " text," + COLUMN_QUE + " text,"+ COLUMN_NAMHOC + " text)";
        String q2 = "create table " + TABLE2_NAME + " ("+ COLUMN_ID + " integer primary key,"
                + COLUMN_TEN + " text," + COLUMN_MOTA + " text)";
        db.execSQL(q1);
        db.execSQL(q2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

    public ArrayList<SinhVien> getAllSv(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<SinhVien> ds = new ArrayList<>();
        String q = "select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(q, null);
        while (cursor.moveToNext()){
            SinhVien sv = new SinhVien(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            ds.add(sv);
        }
        cursor.close();
        db.close();
        return ds;
    }

    public void AddSv(SinhVien sv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TEN, sv.getTen());
        values.put(COLUMN_YOB, sv.getYob());
        values.put(COLUMN_QUE, sv.getQue());
        values.put(COLUMN_NAMHOC, sv.getNamhoc());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<SinhVien> getDm(String ten, String namhoc){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<SinhVien> ds = new ArrayList<>();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_TEN + " like? and " +COLUMN_NAMHOC + " =?", new String[]{"%"+ten, namhoc}, null, null, null);
        while (cursor.moveToNext()){
            SinhVien sv = new SinhVien(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));
            ds.add(sv);
        }
        cursor.close();
        db.close();
        return ds;
    }

    public ArrayList<Lop> getAllLop(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Lop> ds = new ArrayList<>();
        String q = "select * from " + TABLE2_NAME;
        Cursor cursor = db.rawQuery(q, null);
        while (cursor.moveToNext()){
            Lop l = new Lop(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            ds.add(l);
        }
        cursor.close();
        db.close();
        return ds;
    }

    public void AddLop(Lop l){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TEN, l.getTen());
        values.put(COLUMN_MOTA, l.getMota());
        db.insert(TABLE2_NAME, null, values);
        db.close();
    }
}
