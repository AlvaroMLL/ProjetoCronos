package br.edu.ifpb.kuatiaoka.aplicacao;

import java.util.Scanner;

import br.edu.ifpb.kuatiaoka.modelo.Item;
import br.edu.ifpb.kuatiaoka.modelo.Usuario;
import br.edu.ifpb.kuatiaoka.servico.GerenciadorBiblioteca;

public class Main {
    public static void main(String[] args) {
        GerenciadorBiblioteca gerenciador;
        gerenciador = new GerenciadorBiblioteca();
        Scanner in = new Scanner(System.in);

        String opcao = "";

        while (!opcao.equals("5")) {
            System.out.println("--- MENU PRINCIPAL ---");
            System.out.println("[1] Gerenciar Itens");
            System.out.println("[2] Gerenciar Usuários");
            System.out.println("[3] Operações");
            System.out.println("[4] Consultas");
            System.out.println("[5] Sair");
            System.out.print("\nEscolha um opção: ");
            opcao = in.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("--- Gerenciar Itens ---");
                    System.out.println("[1] Cadastrar Livro");
                    System.out.println("[2] Cadastrar Revista");
                    System.out.println("[3] Cadastrar CD");
                    System.out.println("[4] Cadastrar DVD");
                    System.out.println("[5] Voltar");
                    System.out.println("\nEscolha uma opção: ");
                    String subAcao = in.nextLine();
                    switch (subAcao) {
                        case "1":
                            System.out.println("--- Criando Novo Livro ---");
                            System.out.print("Digite o título do livro: ");
                            String titulo = in.nextLine();
                            System.out.print("Digite quantos autores o livro tem: ");
                            int qtd = Integer.parseInt(in.nextLine());
                            String[] autoresInformados = new String[qtd];
                            for (int i = 0; i < qtd; i++) {
                                System.out.print("Digite o autor " + (i + 1) + ": ");
                                autoresInformados[i] = in.nextLine();
                            }
                            System.out.print("Digite a editora: ");
                            String editora = in.nextLine();
                            System.out.print("Digite o ano de publicação: ");
                            String anoPublicacao = in.nextLine();
                            System.out.print("Digite o ISBN do livro: ");
                            String isbn = in.nextLine();
                            System.out.print("Digite a edição do livro: ");
                            String edicao = in.nextLine();
                            System.out.print("Digite o número de páginas: ");
                            String numeroDePaginas = in.nextLine();
                            System.out.print("Digite a Sinopse: ");
                            String sinopse = in.nextLine();
                            String generoFinal = "";
                            while (true) {
                                System.out.println("--- Seleção de Gênero ---");
                                System.out.println(
                                        "1- Ficção Científica / 2- Romance / 3- Terror / 4- Biografia / 5- Outros");
                                System.out.print("Escolha o gênero: ");
                                String opcaoGenero = in.nextLine();
                                if (opcaoGenero.equals("1")) {
                                    generoFinal = "Ficção Científica";
                                    break;
                                } else if (opcaoGenero.equals("2")) {
                                    generoFinal = "Romance";
                                    break;
                                } else if (opcaoGenero.equals("3")) {
                                    generoFinal = "Terror";
                                    break;
                                } else if (opcaoGenero.equals("4")) {
                                    generoFinal = "Biografia";
                                    break;
                                } else if (opcaoGenero.equals("5")) {
                                    System.out.print("Digite o gênero manualmente: ");
                                    generoFinal = in.nextLine();
                                    break;
                                } else {
                                    System.out.println("Digite um número entre 1 e 5");
                                }
                            }
                            int idParaLivro = gerenciador.getProximoIdItem();

                            // public Item(String isbn, int id, String titulo, String tipo, String[]
                            // autores, String editora, int ano,
                            // String edicao, String generoLiterario, int numeroDePaginas, String sinopse,
                            // String issn, String volume, String numero, String dataDePublicacao, String
                            // diretor,
                            // String duracao, String classificacaoIndicativa, String artista, String[]
                            // listaDeFaixas)
                            Item novoLivro = new Item(isbn,
                                    idParaLivro, titulo, "Livro", autoresInformados, editora,
                                    Integer.parseInt(anoPublicacao), edicao, generoFinal,
                                    Integer.parseInt(numeroDePaginas), sinopse, null, null, null, null, null, null,
                                    null,
                                    null, null);
                            gerenciador.adicionarItem(novoLivro);
                            System.out.println("O id do livro é: " + idParaLivro);
                            gerenciador.setProximoIdItem(idParaLivro + 1);
                            System.out.println(
                                    "\nLivro: " + titulo + " id: " + idParaLivro + " cadastrado com sucesso!");
                            break;
                        case "2":
                            System.out.println("--- Criando Nova Revista ---");
                            System.out.print("Digite o título: ");
                            String tituloRevista = in.nextLine();
                            System.out.print("Digite o volume da resvista: ");
                            String volume = in.nextLine();
                            System.out.print("Digite o ISSN: ");
                            String issn = in.nextLine();
                            System.out.print("Digite a editora: ");
                            String editoraRevista = in.nextLine();
                            System.out.print("Digite a data de publicação no formato dd/mm/aaaa: ");
                            String dataPublicacaoRevista = in.nextLine();
                            int idParaRevista = gerenciador.getProximoIdItem();

                            // public Item(String isbn, int id, String titulo, String tipo, String[]
                            // autores, String editora, int ano,
                            // String edicao, String generoLiterario, int numeroDePaginas, String sinopse,
                            // String issn, String volume, String numero, String dataDePublicacao, String
                            // diretor,
                            // String duracao, String classificacaoIndicativa, String artista, String[]
                            // listaDeFaixas)
                            Item novaRevista = new Item(null,
                                    idParaRevista, tituloRevista, "Revista", null, editoraRevista,
                                    0, null, null,
                                    0, null, issn, volume, null, dataPublicacaoRevista, null, null,
                                    null,
                                    null, null);
                            gerenciador.adicionarItem(novaRevista);
                            System.out.println("O id para a revista é: " + idParaRevista);
                            gerenciador.setProximoIdItem(idParaRevista + 1);
                            System.out.println("\nRevista: " + tituloRevista + " id: " + idParaRevista);
                            break;
                        case "3":
                            System.out.println("--- Quem usa CD em 2026 ---");
                            System.out.print("Digite o nome do álbum: ");
                            String tituloCd = in.nextLine();
                            System.out.print("Digite o artista: ");
                            String artista = in.nextLine();
                            System.out.print("Digite a quantidade de faixas do cd: ");
                            int qtdFaixas = Integer.parseInt(in.nextLine());
                            String[] faixaInformadas = new String[qtdFaixas];
                            for (int i = 0; i < qtdFaixas; i++) {
                                System.out.print("Digite a faixa " + (i + 1) + ": ");
                                faixaInformadas[i] = in.nextLine();
                            }
                            int idParaCd = gerenciador.getProximoIdItem();

                            // public Item(String isbn, int id, String titulo, String tipo, String[]
                            // autores, String editora, int ano,
                            // String edicao, String generoLiterario, int numeroDePaginas, String sinopse,
                            // String issn, String volume, String numero, String dataDePublicacao, String
                            // diretor,
                            // String duracao, String classificacaoIndicativa, String artista, String[]
                            // listaDeFaixas)
                            Item novoCd = new Item(null, idParaCd, tituloCd, "CD", null, null, 0, null, null, 0, null,
                                    null, null, null, null, null, null, null, artista, faixaInformadas);
                            gerenciador.adicionarItem(novoCd);
                            System.out.println("O id para o CD é: " + idParaCd);
                            gerenciador.setProximoIdItem(idParaCd + 1);
                            System.out.println("\nCD: " + tituloCd + " id: " + idParaCd);
                            break;
                        case "4":
                            System.out.println("--- Quem usa DVD em 2026 ---");
                            System.out.print("Digite o titulo: ");
                            String tituloDvd = in.nextLine();
                            System.out.print("Digite o diretor: ");
                            String diretor = in.nextLine();
                            System.out.print("Digite a duração em minutos: ");
                            String duracao = in.nextLine();
                            System.out.println("Digite a classificação indicativa: ");
                            String classificacaoIndicativa = in.nextLine();
                            int idParaDvd = gerenciador.getProximoIdItem();

                            // public Item(String isbn, int id, String titulo, String tipo, String[]
                            // autores, String editora, int ano,
                            // String edicao, String generoLiterario, int numeroDePaginas, String sinopse,
                            // String issn, String volume, String numero, String dataDePublicacao, String
                            // diretor,
                            // String duracao, String classificacaoIndicativa, String artista, String[]
                            // listaDeFaixas)
                            Item novoDvd = new Item(null, idParaDvd, tituloDvd, "DVD", null, null, 0, null, null, 0,
                                    null, null, null, null, null, diretor, duracao, classificacaoIndicativa, null,
                                    null);
                            gerenciador.adicionarItem(novoDvd);
                            System.out.println("O id para o DVD é: " + idParaDvd);
                            gerenciador.setProximoIdItem(idParaDvd + 1);
                            System.out.println("\nDVD: " + tituloDvd + " id: " + idParaDvd);     
                            break;
                        case "5":
                            break;
                        default:
                            System.out.println("Digite um número entre 1 e 5");
                            break;
                    }
                    break;
                case "2":
                    System.out.println("--- Gerenciar Usuários ---");
                    System.out.println("[1] Cadastrar novo usuário");
                    System.out.println("[2] Voltar");
                    System.out.println("\nEscolha uma opção: ");
                    String subOpcao = in.nextLine();
                    switch (subOpcao) {
                        case "1":
                            System.out.println("--- Criando Novo Usuário ---");
                            System.out.print("Digite seu nome: ");
                            String nome = in.nextLine();
                            System.out.print("Digite seu e-mail: ");
                            String email = in.nextLine();
                            System.out.println("--- Ecolha De Categoria ---");
                            System.out.println(
                                    "1- Aluno de graduação / 2- Professor / 3- Aluno de pós-graduação / 4- Funcionário administrativo");
                            System.out.print("Escolha sua categoria: ");
                            String categoria = in.nextLine();
                            String categoriaFinal = "";
                            while (true) {
                                if (categoria.equals("1")) {
                                    categoriaFinal = "aluno de graduação";
                                    break;
                                } else if (categoria.equals("2")) {
                                    categoriaFinal = "Professor";
                                    break;
                                } else if (categoria.equals("3")) {
                                    categoriaFinal = "aluno de pós-graduação";
                                    break;
                                } else if (categoria.equals("4")) {
                                    categoriaFinal = "funcionário administrativo";
                                    break;
                                } else {
                                    System.out.println("Digite uma número entre 1 e 4");
                                }
                            }
                            int id = gerenciador.getProximoIdUsuario();
                            System.out.println("Seu id é: " + id);
                            Usuario novo = new Usuario(nome, email, gerenciador.getProximoIdUsuario(), categoriaFinal);
                            gerenciador.adicionarUsuario(novo);
                            gerenciador.setProximoIdUsuario(id + 1);
                            System.out.println("\nUsuário: " + nome + " id: " + id + " cadastrado com sucesso!");
                            break;

                        case "2":
                            break;
                        default:
                            System.out.println("Digite um número entre 1 e 3");
                            break;
                    }
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;

                default:
                    System.out.println("Digite um numero entre 1 e 5");
                    break;
            }
        }
    }
}
