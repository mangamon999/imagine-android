package inpheller.com.persistence;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import inpheller.com.persistence.model.CadastroDbHelper;
import inpheller.com.persistence.model.Usuario;
import inpheller.com.persistence.model.UsuarioDAO;

public class CadastroActivity extends ActionBarActivity {

    private UsuarioDAO usuarioDAO;
    private EditText campoNome;
    private EditText campoEmail;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        usuarioDAO = new UsuarioDAO(this);

        campoNome = (EditText) findViewById(R.id.edit_text_nome);
        campoEmail = (EditText) findViewById(R.id.edit_text_email);
    }

    public void salvar(View view) {
        if (usuario == null) {
            usuario = new Usuario(campoNome.getText().toString(), campoEmail.getText().toString());
            usuarioDAO.salvar(usuario);
            Toast.makeText(this, "Usuário " + usuario.getNome() + " salvo com sucesso.", Toast.LENGTH_SHORT).show();
        } else {
            usuario.setNome(campoNome.getText().toString());
            usuario.setEmail(campoEmail.getText().toString());
            usuarioDAO.atualizar(usuario);
            Toast.makeText(this, "Usuário " + usuario.getNome() + " atualizado com sucesso.", Toast.LENGTH_SHORT).show();
        }


    }

    public void limpar(View view) {

        if (usuarioDAO.deletar(usuario)) {
            Toast.makeText(this, "Usuário " + usuario.getNome() + " deletado com sucesso.", Toast.LENGTH_SHORT).show();
        }

        usuario = null;
        campoNome.setText("");
        campoEmail.setText("");
    }

    public void restaurar(View view) {
        if (usuario == null) {
            Toast.makeText(this, "Usuário não encontrado", Toast.LENGTH_SHORT).show();
            return;
        }

        usuario = usuarioDAO.buscar(this.usuario.getId());

        if (usuario == null) {
            Toast.makeText(this, "Usuário não encontrado.", Toast.LENGTH_SHORT).show();
            return;
        } else {
            Toast.makeText(this, "Usuário encontrado.", Toast.LENGTH_SHORT).show();
        }

        campoNome.setText(usuario.getNome());
        campoEmail.setText(usuario.getEmail());
    }
}
