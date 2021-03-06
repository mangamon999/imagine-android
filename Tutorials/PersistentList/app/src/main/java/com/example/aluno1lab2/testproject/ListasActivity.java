package com.example.aluno1lab2.testproject;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class ListasActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> itens;
    private View novoItemContainer;
    private EditText editTextNomeItem;

    public ListasActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        novoItemContainer = findViewById(R.id.novo_item_container);
        novoItemContainer.setVisibility(View.GONE);

        editTextNomeItem = (EditText) findViewById(R.id.nome_item);

        ListView listView = (ListView) findViewById(R.id.listView);

        itens = new ArrayList<>();

        arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.image_item, R.id.view_nome, itens);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(this);

        Button botaoSalvar = (Button) findViewById(R.id.botao_salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String novoItem = editTextNomeItem.getText().toString();

                itens.add(novoItem);
                arrayAdapter.notifyDataSetChanged();

                novoItemContainer.setVisibility(View.GONE);
                editTextNomeItem.setText(null);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent itensActivity = new Intent(this, ItensActivity.class);
        startActivity(itensActivity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.novo_item_menu) {
            novoItemContainer.setVisibility(View.VISIBLE);
            editTextNomeItem.requestFocus();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
