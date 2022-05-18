package com.example.cadastro.conexao;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cadastro.R;

import java.util.List;

public class AdapterCadastro extends BaseAdapter {

    private List<Modelo> cadastros;
    private Activity act;

    public AdapterCadastro(List<Modelo> cadastros, Activity act) {
        this.cadastros = cadastros;
        this.act = act;
    }

    @Override
    public int getCount() {
        return cadastros.size();
    }

    @Override
    public Object getItem(int i) {
        return cadastros.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = act.getLayoutInflater().inflate(R.layout.item, viewGroup, false);
        Modelo modelo = cadastros.get(i);
        TextView id = (TextView) v.findViewById(R.id.txt_id);
        TextView nome = (TextView) v.findViewById(R.id.txt_nome);
        TextView cpf = (TextView) v.findViewById(R.id.txt_cpf);
        TextView idade = (TextView) v.findViewById(R.id.txt_idade);
        TextView sexo = (TextView) v.findViewById(R.id.txt_sexo);
        TextView email = (TextView) v.findViewById(R.id.txt_email);
        TextView fone = (TextView) v.findViewById(R.id.txt_fone);

        id.setText(modelo.getId().toString());
        nome.setText(modelo.getNome());
        cpf.setText(modelo.getCpf());
        idade.setText(modelo.getIdade());
        sexo.setText(modelo.getSexo());
        email.setText(modelo.getEmail());
        fone.setText(modelo.getFone());

        return v;
    }
}
