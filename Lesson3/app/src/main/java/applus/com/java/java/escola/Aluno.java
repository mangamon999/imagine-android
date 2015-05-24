package applus.com.java.java.escola;

/**
 * Created by brunopinheiro on 5/22/15.
 */
public class Aluno extends Pessoa {

    private int numero;
    private String turma;
    private Sala sala;

    public Aluno(String nome, String telefone) {
        super();
        this.setNome(nome);
        this.setTelefone(telefone);
    }

    @Override
    public String seApresente() {
        return "Olá. Meu nome é " + getNome();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Sala getSala() {
        return sala;
    }
}
