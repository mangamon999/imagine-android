package com.example.aluno1lab2.testproject.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by brunopinheiro on 8/14/15.
 */
public class ListasDbHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String LSTAS_DB = "Lstas.db";

    public ListasDbHelper(Context context) {
        super(context, LSTAS_DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ListasContract.ItensEntry.SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(ListasContract.ItensEntry.SQL_DELETE_ENTRIES);
        onCreate(db);
    }
}
