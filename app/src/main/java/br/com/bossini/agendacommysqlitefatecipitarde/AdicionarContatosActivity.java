package br.com.bossini.agendacommysqlitefatecipitarde;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdicionarContatosActivity extends AppCompatActivity {

    private EditText nomeEditText;
    private EditText foneEditText;
    private EditText emailEditText;
    private ContatoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_contatos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nomeEditText = findViewById(R.id.nomeEditText);
        foneEditText = findViewById(R.id.foneEditText);
        emailEditText = findViewById(R.id.emailEditText);
        dao = new ContatoDAO(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome =
                        nomeEditText.getEditableText().toString();
                String fone =
                        foneEditText.getEditableText().toString();
                String email = emailEditText.getEditableText().toString();
                Contato contato = new Contato(nome, fone, email);
                dao.inserir(contato);
                Toast.makeText(AdicionarContatosActivity.this,
                        getString(R.string.contato_adicionado),
                                Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}
