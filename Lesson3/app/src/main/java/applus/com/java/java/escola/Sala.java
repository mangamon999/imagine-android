package applus.com.java.java.escola;

import java.util.ArrayList;

/**
 * Created by brunopinheiro on 5/22/15.
 */
public class Sala {

    private final int identificador;
    private ArrayList<Aluno> alunos;

    public Sala (int identificador) {
        this.identificador = identificador;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {

        for ( Aluno aluno : alunos ) {
            aluno.setSala(this);
        }

        this.alunos = alunos;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }
}
