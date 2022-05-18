package com.example.cadastro.conexao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class ConexaoBD extends SQLiteOpenHelper {
    // nome do banco e versao
    private static final String name = "banco.db";
    private static final int version = 1;

    public ConexaoBD(Context context) {
        super(context, name, null, version);
    }

    // metodo de criacao de tabela no sqlLite
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table cadastro(" +
                "id integer primary key autoincrement, " +
                "nome varchar (50) not null," +
                "cpf varchar (50) not null unique," +
                "idade varchar (50)," +
                "sexo varchar (50) ," +
                "email varchar (50)," +
                "fone varchar (20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
