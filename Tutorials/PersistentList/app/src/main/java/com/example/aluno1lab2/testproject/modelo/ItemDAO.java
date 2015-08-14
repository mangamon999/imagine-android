package com.example.aluno1lab2.testproject.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by brunopinheiro on 8/14/15.
 */
public class ItemDAO {

    private final Context context;
    private final SQLiteDatabase database;
    ListasDbHelper dbHelper;

    public ItemDAO(Context context) {
        this.context = context;
        this.dbHelper = new ListasDbHelper(context);

        this.database = this.dbHelper.getWritableDatabase();
    }

    public Item salvar(Item item) {
        ContentValues values = new ContentValues();

        values.put(ListasContract.ItensEntry.COLUMN_NOME, item.getNome());
        values.put(ListasContract.ItensEntry.COLUMN_QTD, String.valueOf(item.getQuantidade()));

        long itemId = database.insert(
                ListasContract.ItensEntry.TABLE_NAME,
                null,
                values
        );

        item.setId(itemId);

        return item;
    }

    public Item buscar(long itemId) {

        String[] projection = {
                ListasContract.ItensEntry.COLUMN_NOME,
                ListasContract.ItensEntry.COLUMN_QTD
        };

        Cursor cursor = database.query(
                ListasContract.ItensEntry.TABLE_NAME,
                projection,
                ListasContract.ItensEntry._ID + " LIKE ?",
                new String[]{String.valueOf(itemId)},
                null,
                null,
                null
        );

        if (cursor.getCount() == 0) {
            return null;
        }

        cursor.moveToFirst();

        String nome = cursor.getString(cursor.getColumnIndex(ListasContract.ItensEntry.COLUMN_NOME));
        String qtd = cursor.getString(cursor.getColumnIndex(ListasContract.ItensEntry.COLUMN_QTD));

        return new Item(itemId, nome, Integer.valueOf(qtd));
    }

    public boolean delete(Item item) {
        if (item == null) {
            return false;
        }

        int affected = database.delete(
                ListasContract.ItensEntry.TABLE_NAME,
                ListasContract.ItensEntry._ID + " LIKE ?",
                new String[]{String.valueOf(item.getId())}
        );

        return affected > 0;
    }

    public boolean atualizar(Item item) {
        if (item == null) {
            return false;
        }

        ContentValues values = new ContentValues();

        values.put(ListasContract.ItensEntry.COLUMN_NOME, item.getNome());
        values.put(ListasContract.ItensEntry.COLUMN_QTD, String.valueOf(item.getQuantidade()));

        int affected = database.update(
                ListasContract.ItensEntry.TABLE_NAME,
                values,
                ListasContract.ItensEntry._ID + " LIKE ?",
                new String[]{String.valueOf(item.getId())}
        );

        return affected > 0;
    }
}
