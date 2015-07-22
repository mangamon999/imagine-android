package com.example.aluno1lab2.cadastro;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class PerfilActivity extends ActionBarActivity {

    public static final String PARAM_NOME = "nome";
    public static final String PARAM_SOBRENOME = "sobrenome";
    public static final String PARAM_SENHA = "senha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        String nome = getIntent().getExtras().getString(PARAM_NOME);
        String sobrenome = getIntent().getExtras().getString(PARAM_SOBRENOME);
        String senha = getIntent().getExtras().getString(PARAM_SENHA);

        TextView nomeCompleto = (TextView) findViewById(R.id.nome_completo);

        nomeCompleto.setText("Nome: " + nome + " " + sobrenome);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
