package br.edu.ifpb.kuatiaoka.modelo;

public class Usuario {
    private String nome;
    private String categoria;
    private boolean regularizado = true;
    private String email;
    private int id;

    public String getCategoria() {
        return categoria;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public boolean isRegularizado() {
        return regularizado;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRegularizado(boolean regularizado) {
        this.regularizado = regularizado;
    }

    public Usuario(String nome, String email, int id, String categoria) {
        this.nome = nome;
        this.email = email;
        this.id = id;
        this.categoria = categoria;
    }
}
