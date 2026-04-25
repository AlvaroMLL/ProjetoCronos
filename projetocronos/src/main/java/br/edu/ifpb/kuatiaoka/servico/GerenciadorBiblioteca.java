package br.edu.ifpb.kuatiaoka.servico;

import java.util.ArrayList;

import br.edu.ifpb.kuatiaoka.modelo.Item;
import br.edu.ifpb.kuatiaoka.modelo.Usuario;

public class GerenciadorBiblioteca {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Item> itens = new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void cadastrarItem(Item item) {
        itens.add(item);
    }

    public ArrayList<Item> buscarItemPorTitulo(String tituloBuscado) {
        ArrayList<Item> resultado = new ArrayList<>();
        for (Item item : itens) {
            if (item.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public Item buscarItemPorID(int idBuscado) {
        for (Item item : itens) {
            if (item.getId() == idBuscado) {
                return item;
            }
        }
        return null;
    }

    public Item buscarItemPorIsbn(String isbn) {

    }

    public Item buscarItemPorIssn(String titulo) {

    }

    public ArrayList<Item> buscarItemPorTipo(String tipo) {

    }

    public ArrayList<Item> buscarItemPorAutor(String autor) {

    }

    public ArrayList<Item> buscarItemPorStatus(String status) {

    }

    public ArrayList<Item> buscarItemPorEditora(String editora) {

    }

    public ArrayList<Item> buscarItemPorGenero(String genero) {

    }

    public ArrayList<Usuario> buscarUsuarioPorNome(String nome) {

    }

    public Usuario buscarUsuarioPorId(int idBuscado) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idBuscado) {
                return usuario;
            }
        }
        return null;
    }

}
