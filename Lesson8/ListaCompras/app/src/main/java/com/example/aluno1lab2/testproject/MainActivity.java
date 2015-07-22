package com.example.aluno1lab2.testproject;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {


    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> alunos;

    public MainActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        alunos = new ArrayList<>();

        alunos.add("Bruno");
        alunos.add("Fabio");
        alunos.add("Guido");
        alunos.add("Dionathan");

        arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.image_item, R.id.view_nome, alunos);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(this);
    }

    final ArrayList<Integer> selecionados = new ArrayList<>();

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Integer selecionado = new Integer(position);

        if (selecionados.contains(selecionado)) {
            view.setBackgroundColor(getResources().getColor(android.R.color.transparent));
            selecionados.remove(selecionado);

        } else  {
            view.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
            selecionados.add(selecionado);
        }
//
//        String nome = arrayAdapter.getItem(position);
//        alunos.add(nome);
//
//        arrayAdapter.notifyDataSetChanged();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
