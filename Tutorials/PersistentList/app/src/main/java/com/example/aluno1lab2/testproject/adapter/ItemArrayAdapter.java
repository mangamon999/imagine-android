package com.example.aluno1lab2.testproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aluno1lab2.testproject.R;
import com.example.aluno1lab2.testproject.modelo.Item;

import java.util.List;

/**
 * Created by Aluno1Lab2 on 24/07/2015.
 */
public class ItemArrayAdapter extends ArrayAdapter<Item> {
    public ItemArrayAdapter(Context context, List<Item> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Item item = getItem(position);

        View itemView = convertView;

        if (itemView == null) {
            itemView = LayoutInflater.from(getContext()).inflate(R.layout.lista_item_view, parent, false);
        }

        TextView nomeTextView = (TextView) itemView.findViewById(R.id.nome);
        TextView qtdTextView = (TextView) itemView.findViewById(R.id.qtd);

        nomeTextView.setText(item.getNome());
        qtdTextView.setText(String.valueOf(item.getQuantidade()));

        return itemView;
    }
}
