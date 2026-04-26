package br.edu.ifpb.kuatiaoka.servico;

import java.time.LocalDate;
import java.util.ArrayList;

import br.edu.ifpb.kuatiaoka.modelo.Item;
import br.edu.ifpb.kuatiaoka.modelo.Usuario;
import br.edu.ifpb.kuatiaoka.modelo.Emprestimo;

public class GerenciadorBiblioteca {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Item> itens = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

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

    public Item buscarItemPorId(int idBuscado) {
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
            for (String autor : item.getAutores()) {
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

    public void realizarEmprestimo(int idUsuario, int idItem) {
        Usuario usuarioAchado = buscarUsuarioPorId(idUsuario);
        Item itemAchado = buscarItemPorId(idItem);
        int totalAtivos = contarEmprestimosAtivos(usuarioAchado);

        if (usuarioAchado != null && itemAchado != null && itemAchado.getStatus().equalsIgnoreCase("disponível")
                && usuarioAchado.isRegularizado()) {
            if (totalAtivos < usuarioAchado.getLimiteEmprestimos()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setUsuario(usuarioAchado);
                emprestimo.setItemEmprestado(itemAchado);
                emprestimo.setIdDoEmprestimo(emprestimos.size() + 1);
                int dias = usuarioAchado.calcularPrazo(itemAchado);
                emprestimo.setDataDoEmprestimo(LocalDate.now());
                emprestimo.setDataPrevista(LocalDate.now().plusDays(dias));
                itemAchado.setStatus("Emprestado");
                emprestimos.add(emprestimo);
            }
        }
    }

    public int contarEmprestimosAtivos(Usuario usuario) {
        int cont = 0;
        for (Emprestimo emprestimo : emprestimos) {
            if (usuario.getId() == emprestimo.getUsuario().getId()
                    && emprestimo.getStatus().equalsIgnoreCase("EM_ABERTO")) {
                cont = cont + 1;
            }
        }
        return cont;
    }

}
