package applus.com.java.java.escola;

import java.util.ArrayList;

/**
 * Created by brunopinheiro on 5/22/15.
 */
public class Main {

    public static void main (String[] args) {

        ArrayList<Pessoa> alunos = new ArrayList<>();

        alunos.add(new Aluno("Guido", "(48) 4657-8475"));
        alunos.add(new Aluno("Jorge", "(48) 3782-8475"));
        alunos.add(new Aluno("Fabio", "(48) 0938-8475"));
        alunos.add(new Professor("Bruno"));

        Escola escola = new Escola();

//        escola.salas[0].setAlunos(alunos);


//        System.out.print(escola);

        for (Pessoa aluno : alunos) {
            System.out.println(aluno.seApresente());
        }



//
//
//        pessoas.add(new Professor("Bruno"));
//
//        String print = "";
//
//        for (int i = 0; i < pessoas.size(); i++) {
//            print += "\n" + pessoas.get(i).getNome();
//        }


    }

}
