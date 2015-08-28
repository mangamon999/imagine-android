package com.example.aluno1lab2.testproject.modelo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.aluno1lab2.testproject.modelo.Item;
import com.example.aluno1lab2.testproject.modelo.ListasContract;

import java.util.ArrayList;

/**
 * Created by Aluno1Lab2 on 14/08/2015.
 */
public class ItemDAO extends BaseDAO {

    public ItemDAO(Context context) {
        super(context);
    }

    public void salvar(Item item) {

        ContentValues valores = new ContentValues();

        valores.put(
                ListasContract.ItensTable.COLUMN_NOME,
                item.getNome()
        );

        valores.put(
                ListasContract.ItensTable.COLUMN_QTD,
                String.valueOf(item.getQuantidade())
        );

        valores.put(
                ListasContract.ItensTable.COLUMN_LISTA_ID,
                String.valueOf(item.getListaId())
        );

        long idItem = getDatabase().insert(
                ListasContract.ItensTable.TABLE_NAME,
                null,
                valores
        );

        item.setId(idItem);
    }

    public boolean delete(Item item) {

        if (item == null) {
            return false;
        }

        int itensApagados = getDatabase().delete(
                ListasContract.ItensTable.TABLE_NAME,
                ListasContract.ItensTable._ID + " LIKE ?",
                new String[]{String.valueOf(item.getId())}
        );

        return itensApagados > 0;
    }

    public Item buscar(long itemId) {

        String selection = ListasContract.ItensTable._ID + " LIKE ?";
        String[] selectionArgs = {String.valueOf(itemId)};

        Cursor cursor = buscaItens(selection, selectionArgs);
        if (cursor.getCount() == 0) return null;
        cursor.moveToFirst();

        Item item = readItem(cursor);

        return item;
    }

    public ArrayList<Item> buscarTodos() {
        // SELECT (_id, nome, qtd) FROM item
        Cursor cursor = buscaItens(null, null);
        if (cursor.getCount() == 0) {
            return new ArrayList<>();
        }
        cursor.moveToFirst();

        ArrayList<Item> itens = new ArrayList<>();
        do {
            itens.add(readItem(cursor));
        } while (cursor.moveToNext());

        return itens;
    }

    public ArrayList<Item> buscarItensDaLista(long listaId) {
        // SELECT (_id, nome, qtd, lista_id) FROM item WHERE lista_id = ?
        String selection = ListasContract.ItensTable.COLUMN_LISTA_ID + " = ?";
        String[] selectionArgs = {String.valueOf(listaId)};

        Cursor cursor = buscaItens(selection, selectionArgs);
        if (cursor.getCount() == 0) {
            return new ArrayList<>();
        }
        cursor.moveToFirst();

        ArrayList<Item> itens = new ArrayList<>();
        do {
            itens.add(readItem(cursor));
        } while (cursor.moveToNext());

        return itens;
    }

    private Cursor buscaItens(String selection, String[] selectionArgs) {
        return getDatabase().query(
                ListasContract.ItensTable.TABLE_NAME,
                getProjecao(),
                selection,
                selectionArgs,
                null,
                null,
                null
        );
    }

    private Item readItem(Cursor cursor) {
        int idColum = cursor.getColumnIndex(ListasContract.ItensTable._ID);
        int nomeColumn = cursor.getColumnIndex(ListasContract.ItensTable.COLUMN_NOME);
        int qtdColumn = cursor.getColumnIndex(ListasContract.ItensTable.COLUMN_QTD);
        int listaIdColumn = cursor.getColumnIndex(ListasContract.ItensTable.COLUMN_LISTA_ID);

        long id = cursor.getLong(idColum);
        String nome = cursor.getString(nomeColumn);
        String qtd = cursor.getString(qtdColumn);
        long listaId = cursor.getLong(listaIdColumn);

        return new Item(id, nome, Integer.valueOf(qtd), listaId);
    }

    private String[] getProjecao() {
        return new String[]{
                ListasContract.ItensTable._ID,
                ListasContract.ItensTable.COLUMN_NOME,
                ListasContract.ItensTable.COLUMN_QTD,
                ListasContract.ItensTable.COLUMN_LISTA_ID
        };
    }

}
