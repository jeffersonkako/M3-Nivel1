package model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String nome;


    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public int getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void exibir(){

        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);

    }
}
