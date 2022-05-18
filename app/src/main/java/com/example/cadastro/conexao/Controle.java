package com.example.cadastro.conexao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Controle {

    private ConexaoBD conexaoBD;
    private SQLiteDatabase banco;

    public Controle(Context context) {
        conexaoBD = new ConexaoBD(context);
        banco = conexaoBD.getWritableDatabase();
    }

    //metodo de inserir no banco de dados
    public long inserir(Modelo modelo) {
        ContentValues values = new ContentValues();
        values.put("nome", modelo.getNome());
        values.put("cpf", modelo.getCpf());
        values.put("idade", modelo.getIdade());
        values.put("sexo", modelo.getSexo());
        values.put("email", modelo.getEmail());
        values.put("fone", modelo.getFone());
        return banco.insert("cadastro", null, values);

    }

    // metodo de array de lista do banco de dados
    public List<Modelo> listarCadastros() {
        List<Modelo> modelos = new ArrayList<>();
        String[] campos = {"id", "nome", "cpf", "idade", "sexo", "email", "fone"};
        Cursor cursor = banco.query("cadastro", campos, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Modelo m = new Modelo();
            m.setId(cursor.getInt(0));
            m.setNome(cursor.getString(1));
            m.setCpf(cursor.getString(2));
            m.setIdade(cursor.getString(3));
            m.setSexo(cursor.getString(4));
            m.setEmail(cursor.getString(5));
            m.setFone(cursor.getString(6));
            modelos.add(m);
            banco.close();
        }
        return modelos;
    }

    // metodo de exclusao do banco de dados
    public void excluir(Modelo m) {
        try {
            banco = conexaoBD.getWritableDatabase();
            String sql = "delete from cadastro where id =?";
            SQLiteStatement pst = banco.compileStatement(sql);
            pst.bindLong(1, m.getId());
            pst.executeUpdateDelete();
            banco.close();
        } catch (Exception e) {
        }
    }

    // metodo de atualizacao do banco de dados
    public void atualizar(Modelo modelo) {
        ContentValues values = new ContentValues();
        values.put("nome", modelo.getNome());
        values.put("cpf", modelo.getCpf());
        values.put("idade", modelo.getIdade());
        values.put("sexo", modelo.getSexo());
        values.put("email", modelo.getEmail());
        values.put("fone", modelo.getFone());
        banco.update("cadastro", values, "sexo = ?", new String[]{modelo.getSexo().toString()});
        banco.close();
    }
}