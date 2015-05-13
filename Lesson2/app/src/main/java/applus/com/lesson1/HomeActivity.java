package applus.com.lesson1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import applus.com.lesson2.ConfirmationActivity;


public class HomeActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    public void continuarCadastro(View button) {
        Log.d(this.getClass().getSimpleName(), "Botão continuar foi pressionado");

        Intent confirmacao = new Intent(this, ConfirmationActivity.class);

        EditText nome = (EditText) findViewById(R.id.editText_nome);
        confirmacao.putExtra("NOME", nome.getText());

        EditText senhaTexto = (EditText) findViewById(R.id.editText_senha_texto);
        confirmacao.putExtra("SENHA_TEXTO", senhaTexto.getText());

        EditText senhaNumerica = (EditText) findViewById(R.id.editText_senha_numerica);
        confirmacao.putExtra("SENHA_NUMERICA", senhaNumerica.getText());

        EditText email = (EditText) findViewById(R.id.editText_email);
        confirmacao.putExtra("EMAIL", email.getText());

        EditText telefone = (EditText) findViewById(R.id.editText_telefone);
        confirmacao.putExtra("TELEFONE", telefone.getText());

        EditText cep = (EditText) findViewById(R.id.editText_cep);
        confirmacao.putExtra("CEP", cep.getText());

        EditText nascimento = (EditText) findViewById(R.id.editText_nascimento);
        confirmacao.putExtra("NASCIMENTO", nascimento.getText());

        EditText rg = (EditText) findViewById(R.id.editText_rg);
        confirmacao.putExtra("RG", rg.getText());

        startActivity(confirmacao);
    }
}
