package com.example.aluno1lab2.testproject.modelo.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.aluno1lab2.testproject.modelo.ListasDbHelper;

/**
 * Created by Aluno1Lab2 on 21/08/2015.
 */
public abstract class BaseDAO {

    private final ListasDbHelper dbHelper;
    private final SQLiteDatabase database;

    public BaseDAO(Context context) {
        this.dbHelper = new ListasDbHelper(context);
        this.database = this.dbHelper.getWritableDatabase();
    }

    public ListasDbHelper getDbHelper() {
        return dbHelper;
    }

    public SQLiteDatabase getDatabase() {
        return database;
    }
}
