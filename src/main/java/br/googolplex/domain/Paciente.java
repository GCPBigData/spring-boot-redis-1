package br.googolplex.domain;

import java.io.Serializable;

public class Paciente implements Serializable {

    private String nome;
    private String cpf;
    private String email;
    private String status;

    public Paciente(String nome, String cpf, String email, String status) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.status = status;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
