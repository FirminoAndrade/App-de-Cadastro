package com.example.cadastro.funcionalidades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cadastro.R;
import com.example.cadastro.conexao.Controle;
import com.example.cadastro.conexao.Modelo;

public class ActivityAlterar extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;
    private EditText idade;
    private EditText sexo;
    private EditText email;
    private EditText fone;
    private Controle crud;
    public Modelo modelo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_alterar);
        setTitle("Alterar Cadastro");

        nome = (EditText) findViewById(R.id.editTextNome);
        cpf = (EditText) findViewById(R.id.editTextCPF);
        idade = (EditText) findViewById(R.id.editTextIdade);
        sexo = (EditText) findViewById(R.id.editTextSexo);
        email = (EditText) findViewById(R.id.editTextEmail);
        fone = (EditText) findViewById(R.id.editTextTelefone);
        crud = new Controle(this);

        Intent intent = getIntent();
        if (intent.hasExtra("cadastro")) {
            modelo = (Modelo) intent.getSerializableExtra("cadastro");
            nome.setText(modelo.getNome());
            cpf.setText(modelo.getCpf());
            idade.setText(modelo.getIdade());
            sexo.setText(modelo.getSexo());
            email.setText(modelo.getEmail());
            fone.setText(modelo.getFone());
        }
    }

    public void alterar(View view) {
        Modelo modelo = new Modelo();
        try {
            modelo.setNome(nome.getText().toString());
            modelo.setCpf(cpf.getText().toString());
            modelo.setIdade(idade.getText().toString());
            modelo.setSexo(sexo.getText().toString());
            modelo.setEmail(email.getText().toString());
            modelo.setFone(fone.getText().toString());
            crud.atualizar(modelo);
            Intent intent = new Intent(this,ActivityListar.class);
            startActivity(intent);
            Toast.makeText(this, "Cadastro Atualizado!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Algo deu Errado!" + e, Toast.LENGTH_SHORT).show();
        }
    }
}