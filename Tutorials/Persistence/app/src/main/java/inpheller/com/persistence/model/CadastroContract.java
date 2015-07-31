package inpheller.com.persistence.model;

import android.provider.BaseColumns;

/**
 * Created by brunopinheiro on 7/30/15.
 */
public class CadastroContract {
    private CadastroContract() {
    }

    /* Inner class that defines the table contents */
    public static abstract class UsuarioEntry implements BaseColumns {
        public static final String TABLE_NAME = "usuario";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_EMAIL = "email";


        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";

        // CREATE TABLE usuario (_id INTEGER PRIMARY KEY, nome TEXT, email TEXT)
        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_NOME + TEXT_TYPE + COMMA_SEP +
                        COLUMN_NAME_EMAIL + TEXT_TYPE +
                        " )";

        // DROP TABLE IF EXISTS usuario;
        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }


}
