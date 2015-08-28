package com.example.aluno1lab2.testproject.modelo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.aluno1lab2.testproject.modelo.Item;
import com.example.aluno1lab2.testproject.modelo.Lista;
import com.example.aluno1lab2.testproject.modelo.ListasContract;

import java.util.ArrayList;

/**
 * Created by Aluno1Lab2 on 21/08/2015.
 */
public class ListaDAO extends BaseDAO{

    public ListaDAO(Context context) {
        super(context);
    }

    public void salvar(Lista lista) {

        ContentValues valores = new ContentValues();

        valores.put(
                ListasContract.ListasTable.COLUMN_NOME,
                lista.getNome()
        );

        long idItem = getDatabase().insert(
                ListasContract.ListasTable.TABLE_NAME,
                null,
                valores
        );

        lista.setId(idItem);
    }

    public boolean delete(Lista lista) {

        if (lista == null) {
            return false;
        }

        // _ID = 1

        int listasApagadas = getDatabase().delete(
                ListasContract.ItensTable.TABLE_NAME,
                ListasContract.ItensTable._ID + " = ?",
                new String[]{String.valueOf(lista.getId())}
        );

        return listasApagadas > 0;
    }

    public Lista buscar(long itemId) {

        String selection = ListasContract.ListasTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(itemId)};

        Cursor cursor = buscaListas(selection, selectionArgs);
        if (cursor.getCount() == 0) return null;
        cursor.moveToFirst();

        Lista lista = readLista(cursor);

        return lista;
    }

    public ArrayList<Lista> buscarTodos() {
        // SELECT (_id, nome) FROM lista
        Cursor cursor = buscaListas(null, null);

        if (cursor.getCount() == 0) {
            return new ArrayList<>();
        }

        cursor.moveToFirst();

        ArrayList<Lista> listas = new ArrayList<>();
        do {
            listas.add(readLista(cursor));
        } while (cursor.moveToNext());

        return listas;
    }

    private Cursor buscaListas(String selection, String[] selectionArgs) {
        return getDatabase().query(
                ListasContract.ListasTable.TABLE_NAME,
                getProjeao(),
                selection,
                selectionArgs,
                null,
                null,
                null
        );
    }

    private String[] getProjeao() {
        return new String[]{
                ListasContract.ListasTable._ID,
                ListasContract.ListasTable.COLUMN_NOME
        };
    }

    private Lista readLista(Cursor cursor) {
        int idColum = cursor.getColumnIndex(ListasContract.ItensTable._ID);
        int nomeColumn = cursor.getColumnIndex(ListasContract.ItensTable.COLUMN_NOME);

        long id = cursor.getLong(idColum);
        String nome = cursor.getString(nomeColumn);

        return new Lista(id, nome, null);
    }
}
