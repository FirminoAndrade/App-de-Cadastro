package com.example.cadastro.conexao;

import java.io.Serializable;

public class Modelo implements Serializable {
    private Integer id;
    private String nome;
    private String cpf;
    private String idade;
    private String sexo;
    private String email;
    private String fone;

    public Modelo() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    @Override
    public String toString() {
        return "\n                " +
                "                                  " +
                "                            " +
                " Matrícula: " + id + "\n\nNOME: " + nome + "\nCPF:     " + cpf + "        " +
                "     IDADE: " + idade + "\nSEXO:   " + sexo + "                   " +
                " FONE: " + fone + "\nEMAIL:  " + email;
    }

}
