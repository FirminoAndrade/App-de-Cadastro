package com.example.cadastro.funcionalidades;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.cadastro.R;
import com.example.cadastro.funcionalidades.ActivityCriar;
import com.example.cadastro.funcionalidades.ActivityListar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("CRUD");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_tela_principal, menu);
        return true;
    }

    public void cadastrar(MenuItem item) {
        Intent intent = new Intent(this, ActivityCriar.class);
        startActivity(intent);
    }

    public void buscar(MenuItem item) {
        Intent it = new Intent(this, ActivityListar.class);
        startActivity(it);
    }
}