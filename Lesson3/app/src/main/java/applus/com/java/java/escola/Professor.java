package applus.com.java.java.escola;

/**
 * Created by brunopinheiro on 5/22/15.
 */
public class Professor extends Pessoa implements Motorista {

    private String materia;

    public Professor(String nome) {
        super();
        this.setNome(nome);
    }

    @Override
    public String seApresente() {
        return "Boa noite. Meu nome é " + getNome()
                + ". Eu sou professor de " + getMateria();
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public void dirija(Veiculo veiculo) {
        veiculo.anda();
    }
}
