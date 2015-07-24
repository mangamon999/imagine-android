package inpheller.com.listview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaActivity extends ActionBarActivity {

    private ArrayList<String> itens;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        ListView listaItens = (ListView) findViewById(R.id.lista_itens);


        itens = new ArrayList<String>();

        itens.add("Tesoura");
        itens.add("Caderno");
        itens.add("Lapis");
        itens.add("Borracha");
        itens.add("Apontador");

        arrayAdapter = new ArrayAdapter<String>(this, R.layout.lista_item, R.id.lista_item_nome, itens);

        listaItens.setAdapter(arrayAdapter);
    }

    public void adicionaNovoItem(View view) {
        itens.add("Novo item");
        arrayAdapter.notifyDataSetChanged();
    }
}
