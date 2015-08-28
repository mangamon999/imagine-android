package com.example.aluno1lab2.testproject.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.aluno1lab2.testproject.modelo.ListasContract;

/**
 * Created by Aluno1Lab2 on 14/08/2015.
 */
public class ListasDbHelper extends SQLiteOpenHelper {

    public static final String LISTAS_DB = "Listas.db";
    public static final int VERSION = 5;

    public ListasDbHelper(Context context) {
        super(context, LISTAS_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ListasContract.ItensTable.SQL_CREATE_TABLE);
        db.execSQL(ListasContract.ListasTable.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ListasContract.ItensTable.SQL_DELETE_TABLE);
        db.execSQL(ListasContract.ListasTable.SQL_DELETE_TABLE);
        onCreate(db);
    }
}
