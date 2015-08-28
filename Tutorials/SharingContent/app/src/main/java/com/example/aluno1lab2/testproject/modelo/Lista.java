package com.example.aluno1lab2.testproject.modelo;

import java.util.ArrayList;

/**
 * Created by Aluno1Lab2 on 21/08/2015.
 */
public class Lista {

    private long id;
    private String nome;
    private ArrayList<Item> itens;

    public Lista(String nome) {
        this.nome = nome;
    }

    public Lista(String nome, ArrayList<Item> itens) {
        this.itens = itens;
        this.nome = nome;
    }

    public Lista(long id, String nome, ArrayList<Item> itens) {
        this.id = id;
        this.nome = nome;
        this.itens = itens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Item> getItens() {
        if (itens == null) {
            itens = new ArrayList<>();
        }

        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public void addItem(Item item) {
        getItens().add(item);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
