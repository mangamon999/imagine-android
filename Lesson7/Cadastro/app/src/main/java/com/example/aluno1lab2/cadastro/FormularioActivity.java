package com.example.aluno1lab2.cadastro;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class FormularioActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
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

    public void continueClick(View button) {
        Log.d("Formulario", "O botão 'continuar' foi clicado");

        Intent perfilActivity = new Intent(this, PerfilActivity.class);

        EditText nome = (EditText) findViewById(R.id.edit_text_nome);
        EditText sobrenome = (EditText) findViewById(R.id.edit_text_sobrenome);
        EditText senha = (EditText) findViewById(R.id.edit_text_senha);

        perfilActivity.putExtra(PerfilActivity.PARAM_NOME, nome.getText().toString());
        perfilActivity.putExtra("sobrenome", sobrenome.getText().toString());
        perfilActivity.putExtra("senha", senha.getText().toString());

        startActivity(perfilActivity);
    }
}
