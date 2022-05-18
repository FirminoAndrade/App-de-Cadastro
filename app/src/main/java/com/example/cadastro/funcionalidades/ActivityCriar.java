package com.example.cadastro.funcionalidades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cadastro.R;
import com.example.cadastro.conexao.Controle;
import com.example.cadastro.conexao.Modelo;

public class ActivityCriar extends AppCompatActivity {

    private EditText nome;
    private EditText cpf;
    private EditText idade;
    private EditText sexo;
    private EditText email;
    private EditText fone;
    private Controle crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        setTitle("Criar Cadastro");

        nome = (EditText) findViewById(R.id.editTextNome);
        cpf = (EditText) findViewById(R.id.editTextCPF);
        idade = (EditText) findViewById(R.id.editTextIdade);
        sexo = (EditText) findViewById(R.id.editTextSexo);
        email = (EditText) findViewById(R.id.editTextEmail);
        fone = (EditText) findViewById(R.id.editTextTelefone);
        crud = new Controle(this);
    }

    // metodo configura o conteudo do EditeText para armazenar no banco de dados
    public void salvar(View view) {
        Modelo modelo = new Modelo();
        try {
            modelo.setNome(nome.getText().toString());
            modelo.setCpf(cpf.getText().toString());
            modelo.setIdade(idade.getText().toString());
            modelo.setSexo(sexo.getText().toString());
            modelo.setEmail(email.getText().toString());
            modelo.setFone(fone.getText().toString());
            long id = crud.inserir(modelo);
            if (id > 1) {
                Toast.makeText(this, "Cadastro efetuado Com Sucesso! ID: " + id, Toast.LENGTH_SHORT).show();
            } else if (modelo.getCpf() == modelo.getCpf()) {
                Toast.makeText(this, "CPF Já Cadastrado!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Algo deu Errado!" + e, Toast.LENGTH_SHORT).show();
        }
    }
}
