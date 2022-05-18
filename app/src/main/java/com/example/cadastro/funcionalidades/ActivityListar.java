package com.example.cadastro.funcionalidades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.cadastro.R;
import com.example.cadastro.conexao.AdapterCadastro;
import com.example.cadastro.conexao.Controle;
import com.example.cadastro.conexao.Modelo;


import java.util.ArrayList;
import java.util.List;

public class ActivityListar extends AppCompatActivity {
    private ListView lista;
    private Controle crud;
    private List<Modelo> cadastros;
    private List<Modelo> cadastroFiltrado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_cadastros);
        setTitle("Lista de Cadastrados");

        lista = (ListView) findViewById(R.id.lista_cadastros);
        crud = new Controle(this);
        cadastros = crud.listarCadastros();
        cadastroFiltrado.addAll(cadastros);

        // array de lista com layout padrao do android
        // ArrayAdapter<Modelo> adapter = new ArrayAdapter<Modelo>(this, android.R.layout.simple_list_item_1, cadastroFiltrado);
        // array adaptado na lista
        AdapterCadastro adapter = new AdapterCadastro(cadastros, this);
        lista.setAdapter(adapter);
        registerForContextMenu(lista);
    }

    // metodo cria menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.search_view).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                buscarCadastro(s);
                return false;
            }
        });
        return true;
    }

    // metodo buscar filtrada
    public void buscarCadastro(String nome) {
        cadastroFiltrado.clear();
        for (Modelo a : cadastros) {
            // se na lista de cadastro estiver o nome digitado lista todos nomes
            if (a.getNome().toLowerCase().contains(nome.toLowerCase())) {
                cadastroFiltrado.add(a);
            }
        }
        // retorna os dados atualizados
        lista.invalidateViews();
    }
    // metodo menu de contexto para excluir e alterar

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuIn = getMenuInflater();
        menuIn.inflate(R.menu.menu_excluir_alterar, menu);
    }

    public void atualizar(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInf = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        final Modelo cadAtualizar = cadastroFiltrado.get(menuInf.position);
        Intent it = new Intent(this, ActivityAlterar.class);
        it.putExtra("cadastro", cadAtualizar);
        startActivity(it);
    }

    // chama metodo cadastrar na tela principal no botao +
    public void cadastrar(MenuItem item) {
        Intent intent = new Intent(this, ActivityCriar.class);
        startActivity(intent);
    }

    public void excluirCadastro(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        final Modelo cadExcluir = cadastroFiltrado.get(menuInfo.position);

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Tem certeza que deseja EXCLUIR!")
                .setNegativeButton("Não", null)
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        cadastroFiltrado.remove(cadExcluir);
                        cadastros.remove(cadExcluir);
                        crud.excluir(cadExcluir);
                        lista.invalidateViews();
                    }
                }).create();
        alertDialog.show();
    }
}