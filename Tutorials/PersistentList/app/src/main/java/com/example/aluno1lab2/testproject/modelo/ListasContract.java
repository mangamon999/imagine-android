package com.example.aluno1lab2.testproject.modelo;

import android.provider.BaseColumns;
import android.widget.TableLayout;

import com.example.aluno1lab2.testproject.ListasActivity;

/**
 * Created by brunopinheiro on 8/14/15.
 */
public class ListasContract {

    private ListasContract() {}

    public static abstract class ItensEntry implements BaseColumns {

        public static final String TABLE_NAME = "item";

        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_QTD = "qtd";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NOME + " TEXT, " +
                        COLUMN_QTD + " TEXT" +
                        ")";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

}
