package com.example.aluno1lab2.testproject.modelo;

import android.provider.BaseColumns;

/**
 * Created by Aluno1Lab2 on 14/08/2015.
 */
public class ListasContract {

    private ListasContract() {
    }

    public static abstract class ListasTable implements BaseColumns {

        public static final String TABLE_NAME = "lista";

        public static final String COLUMN_NOME = "nome";


        // CREATE TABLE lista (
        //        _id INTEGER PRIMARY KEY,
        //        nome TEXT,
       //        )
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "( " +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NOME + " TEXT " +
                        ")";

        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static abstract class ItensTable implements BaseColumns {

        public static final String TABLE_NAME = "item";

        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_QTD = "qtd";
        public static final String COLUMN_LISTA_ID = "lista_id";

        // CREATE TABLE item (
        //        _id INTEGER PRIMARY KEY,
        //        nome TEXT,
        //        qtd TEXT,
        //        lista_id INTEGER
        //        )
        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "( " +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_NOME + " TEXT, " +
                        COLUMN_QTD + " TEXT, " +
                        COLUMN_LISTA_ID + " INTEGER " +
                        ")";

        public static final String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
