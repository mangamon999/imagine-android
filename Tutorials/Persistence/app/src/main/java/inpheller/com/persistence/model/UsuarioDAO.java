package inpheller.com.persistence.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static inpheller.com.persistence.model.CadastroContract.UsuarioEntry;

/**
 * Created by brunopinheiro on 7/30/15.
 */
public class UsuarioDAO {

    Context context;

    CadastroDbHelper dbHelper;
    private final SQLiteDatabase database;

    public UsuarioDAO(Context context) {
        this.context = context;

        dbHelper = new CadastroDbHelper(context);
        // Gets the data repository in write mode
        database = dbHelper.getWritableDatabase();
    }

    public Usuario salvar(Usuario usuario) {

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(UsuarioEntry.COLUMN_NAME_NOME, usuario.getNome());
        values.put(UsuarioEntry.COLUMN_NAME_EMAIL, usuario.getEmail());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = database.insert(
                UsuarioEntry.TABLE_NAME,
                null,
                values);

        usuario.setId(newRowId);

        return usuario;
    }

    public Usuario buscar(long id) {
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                UsuarioEntry.COLUMN_NAME_NOME,
                UsuarioEntry.COLUMN_NAME_EMAIL
        };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                UsuarioEntry.COLUMN_NAME_NOME + " DESC";

        Cursor cursor = database.query(
                UsuarioEntry.TABLE_NAME,  // The table to query
                projection,                               // The columns to return
                UsuarioEntry._ID + " LIKE ?",                                // The columns for the WHERE clause
                new String[]{String.valueOf(id)},                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        if (cursor.getCount() == 0) {
            return null;
        }

        cursor.moveToFirst();

        String nome = cursor.getString(
                cursor.getColumnIndex(UsuarioEntry.COLUMN_NAME_NOME)
        );

        String email = cursor.getString(
                cursor.getColumnIndex(UsuarioEntry.COLUMN_NAME_EMAIL)
        );

        return new Usuario(id, nome, email);
    }

    public boolean deletar(Usuario usuario) {

        if (usuario == null) {
            return false;
        }

        int delete = database.delete(
                UsuarioEntry.TABLE_NAME,  // The table to query
                UsuarioEntry._ID + " LIKE ?",                                // The columns for the WHERE clause
                new String[]{String.valueOf(usuario.getId())}                            // The values for the WHERE clause
        );

        return delete > 0;
    }

    public boolean atualizar(Usuario usuario) {

        if (usuario == null) {
            return false;
        }

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(UsuarioEntry.COLUMN_NAME_NOME, usuario.getNome());
        values.put(UsuarioEntry.COLUMN_NAME_EMAIL, usuario.getEmail());

        // Insert the new row, returning the primary key value of the new row
        int affected = database.update(
                UsuarioEntry.TABLE_NAME,
                values,
                UsuarioEntry._ID + " LIKE ?",
                new String[]{String.valueOf(usuario.getId())}                           // The columns for the WHERE clause
        );

        return affected > 0;
    }
}
