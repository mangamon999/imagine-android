package com.example.aluno1lab2.testproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.aluno1lab2.testproject.adapter.ItemArrayAdapter;
import com.example.aluno1lab2.testproject.modelo.Item;
import com.example.aluno1lab2.testproject.modelo.dao.ItemDAO;

import java.util.ArrayList;


public class ItensActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    public static final String PARAM_LISTA_ID = "listaId";
    public static final String PARAM_LISTA_NOME = "listaNome";

    private ArrayList<Item> itens;
    private ArrayAdapter<Item> arrayAdapter;
    private EditText editTextNomeItem;
    private View novoItemContainer;
    private EditText editTextQtdItem;
    private long listaId;
    private String listaNome;
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itens);

        novoItemContainer = findViewById(R.id.novo_item_container);

        editTextNomeItem = (EditText) findViewById(R.id.nome_item);
        editTextQtdItem = (EditText) findViewById(R.id.qtd_item);

        ListView listView = (ListView) findViewById(R.id.listView);

        listaId = getIntent().getExtras().getLong(PARAM_LISTA_ID);
        listaNome = getIntent().getExtras().getString(PARAM_LISTA_NOME);

        ItemDAO dao = new ItemDAO(this);
        itens = dao.buscarItensDaLista(listaId);

        if (itens.size() > 0) {
            novoItemContainer.setVisibility(View.GONE);
        }

        arrayAdapter = new ItemArrayAdapter(this, itens);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(this);

        Button botaoSalvar = (Button) findViewById(R.id.botao_salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeItem = editTextNomeItem.getText().toString();
                String qtdItem = editTextQtdItem.getText().toString();

                Item item = new Item(nomeItem, Integer.valueOf(qtdItem), listaId);

                itens.add(item);

                ItemDAO dao = new ItemDAO(ItensActivity.this);
                dao.salvar(item);

                arrayAdapter.notifyDataSetChanged();
                updateShareIntent();

                novoItemContainer.setVisibility(View.GONE);
                editTextNomeItem.setText(null);
                editTextQtdItem.setText(null);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_itens, menu);

        // Locate MenuItem with ShareActionProvider
        MenuItem item = menu.findItem(R.id.menu_compartilhar);

        // Fetch and store ShareActionProvider
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        updateShareIntent();

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_novo_item) {
            novoItemContainer.setVisibility(View.VISIBLE);
            editTextNomeItem.requestFocus();
            return true;
        }

//        if (id == R.id.menu_compartilhar) {
//            startActivity(Intent.createChooser(enviarLista, "Enviar lista..."));
//
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    // Call to update the share intent
    private void updateShareIntent() {
        if (shareActionProvider != null) {
            Intent enviarLista = new Intent(Intent.ACTION_SEND);
            enviarLista.setType("text/plain");

            String listaDeCompras = parseListaDeCompras();
            enviarLista.putExtra(Intent.EXTRA_EMAIL, new String[]{"jose@gmail.com"});
            enviarLista.putExtra(Intent.EXTRA_SUBJECT, "Lista de compras");
            enviarLista.putExtra(Intent.EXTRA_TEXT, listaDeCompras);

            shareActionProvider.setShareIntent(enviarLista);
        }
    }

    @NonNull
    private String parseListaDeCompras() {

        String lista = listaNome + "\n";

        for (Item item : itens) {
            lista += "\n" + item.getQuantidade() + " " + item.getNome();
        }

        return lista;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
