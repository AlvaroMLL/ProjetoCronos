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

    public Item buscarItemPorIsbn(String isbnBuscado) {
        for (Item item : itens) {
            if (item.getIsbn() == isbnBuscado) {
                return item;
            }
        }
        return null;
    }

    public Item buscarItemPorIssn(String issnBuscado) {
        for (Item item : itens) {
            if (item.getIssn() == issnBuscado) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> buscarItemPorTipo(String tipoBuscado) {
        ArrayList<Item> resultado = new ArrayList<>();
        for (Item item : itens) {
            if (item.getTipo().equalsIgnoreCase(tipoBuscado)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public ArrayList<Item> buscarItemPorAutor(String autorBuscado) {
        ArrayList<Item> resultado = new ArrayList<>();
        for (Item item : itens) {
            for (String autor: item.getAutores()) {
                if (autor.equalsIgnoreCase(autorBuscado)) {
                    resultado.add(item);
                    break;
                }
            }
        }
        return resultado;
    }

    public ArrayList<Item> buscarItemPorStatus(String statusBuscado) {
        ArrayList<Item> resultado = new ArrayList<>();
        for (Item item : itens) {
            if (item.getStatus().equalsIgnoreCase(statusBuscado)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public ArrayList<Item> buscarItemPorEditora(String editoraBuscada) {
        ArrayList<Item> resultado = new ArrayList<>();
        for (Item item : itens) {
            if (item.getTitulo().equalsIgnoreCase(editoraBuscada)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public ArrayList<Item> buscarItemPorGenero(String generoBuscado) {
        ArrayList<Item> resultado = new ArrayList<>();
        for (Item item : itens) {
            if (item.getGeneroLiterario().equalsIgnoreCase(generoBuscado)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public ArrayList<Usuario> buscarUsuarioPorNome(String nomeBuscado) {
        ArrayList<Usuario> resultado = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nomeBuscado)) {
                resultado.add(usuario);
            }
        }
        return resultado;
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
