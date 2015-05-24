package applus.com.java.java.escola;

/**
 * Created by brunopinheiro on 5/22/15.
 */
public abstract class Pessoa {

    private String nome;
    private String cor;
    private int idade;
    private String telefone;
    private String endereco;
    private String sexo;

    public abstract String seApresente();

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone (String telefone) {

        telefone = telefone.replace("(", "");
        telefone = telefone.replace(")", "");
        telefone = telefone.replace(" ", "");
        telefone = telefone.replace("-", "");

        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
