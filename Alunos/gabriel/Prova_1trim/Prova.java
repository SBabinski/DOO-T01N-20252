package Prova_1trim;

import java.util.Scanner;
import java.util.ArrayList;

public class Prova {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Emprestimo> emprestimos = new ArrayList<>();

        int opcao = 0;

        while (opcao != 9) {
            System.out.println("===== MENU BIBLIOTECA =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Cadastrar livro");
            System.out.println("3 - Buscar livro por título");
            System.out.println("4 - Buscar livro por autor");
            System.out.println("5 - Realizar empréstimo");
            System.out.println("6 - Realizar devolução");
            System.out.println("7 - Verificar disponibilidade de título");
            System.out.println("8 - Listar clientes");
            System.out.println("9 - Sair");
            System.out.print("Digite a opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println(" Cadastro de cliente");

                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    Cliente cliente = new Cliente(nome, cpf);
                    clientes.add(cliente);

                    System.out.println("Cliente cadastrado com sucesso!");

                    break;

                case 2:
                    System.out.println(" Cadastro de livro");

                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();

                    System.out.print("Digite o tipo de livro (comum ou raro): ");
                    String tipo = scanner.nextLine();

                    if (tipo.equalsIgnoreCase("raro")) {
                        livros.add(new LivroRaro(titulo, autor, tipo));
                    } else {


                        livros.add(new Livro(titulo, autor, tipo));
                    }

                    System.out.println("Livro cadastrado com sucesso!");

                    break;
                case 3:
                    System.out.print("Digite o título: ");
                    String titulobusca = scanner.nextLine();

                    boolean encontrado = false;
                    for (Livro livro : livros) {
                        if (livro.getTitulo().equalsIgnoreCase(titulobusca)) {
                            System.out.println("Livro encontrado: " + livro.getTitulo());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println(" Nenhum livro encontrado.");
                    }

                    break;

                case 4:
                    System.out.print("Digite o autor: ");
                    String autorBusca = scanner.nextLine();

                    boolean encontradoAutor = false;
                    for (Livro livro : livros) {
                        if (livro.getAutor().equalsIgnoreCase(autorBusca)) {
                            System.out.println(" Livro encontrado: " + livro.getAutor());
                            encontradoAutor = true;

                        }
                    }

                    if (!encontradoAutor) {
                        System.out.println(">> Nenhum livro encontrado para esse autor.");
                    }

                    break;

                case 5:
                    System.out.print("Digite o título do livro para empréstimo: ");
                    String tituloEmprestimo = scanner.nextLine();

                    boolean livroAchado = false;

                    for (int i = 0; i < livros.size(); i++) {
                        Livro l = livros.get(i);

                        if (l.getTitulo().equalsIgnoreCase(tituloEmprestimo)) {
                            livroAchado = true;

                            if (l.emprestar()) {
                                System.out.print("Digite o número de dias que o cliente ficará com o livro (maximo 7 dias de emprestimo): ");
                                int dias = scanner.nextInt();
                                scanner.nextLine(); 
                                l.setDiasEmprestimo(dias);

                            
                                System.out.println(" Empréstimo realizado com sucesso!");
                                

                            } else {
                                System.out.println(">> O livro já está emprestado.");
                            }
                        }
                    }

                    if (!livroAchado) {
                        System.out.println(">> Livro não encontrado na biblioteca.");
                    }

                    break;

                case 6:
                    System.out.println(" Realizando devolução");

                    System.out.println("Digite o nome do livro que deseja devolver:");
                    String nomeLivro = scanner.nextLine();

                    encontrado = false;

                    for (Livro l : livros) {
                        if (l.getTitulo().equalsIgnoreCase(nomeLivro)) {
                            if (!l.isDisponivel()) {
                                System.out.print("Digite quantos dias o livro ficou emprestado: ");
                                int diasEmprestados = scanner.nextInt();
                                scanner.nextLine(); // limpar buffer
                                
                                double taxaAtraso = 0.0;
                                if (diasEmprestados > 7) {
                                    taxaAtraso = 3.50;
                                    System.out.println(" ATENÇÃO: Devolução com atraso!");
                                    System.out.println(" Dias emprestados: " + diasEmprestados + " (limite: 7 dias)");
                                    System.out.println(" Taxa de atraso: R$ " + String.format("%.2f", taxaAtraso));
                                } else {
                                    System.out.println(">> Devolução dentro do prazo!");
                                }
                                
                                l.setDisponivel(true);
                                System.out.println("Livro devolvido com sucesso!");
                                
                                if (taxaAtraso > 0) {
                                    System.out.println(">> Total a pagar pela taxa de atraso: R$ " + String.format("%.2f", taxaAtraso));
                                }
                            } else {
                                System.out.println("Este livro já estava disponível na biblioteca.");
                            }
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Livro não encontrado na biblioteca.");
                    }

                    break;
                case 7:
                    System.out.print("Digite o título para verificar disponibilidade: ");
                    String tituloDisp = scanner.nextLine();

                    boolean livroEncontrado = false;
                    for (Livro livro : livros) {
                        if (livro.getTitulo().equalsIgnoreCase(tituloDisp)) {
                            livroEncontrado = true;
                            if (livro.isDisponivel()) {
                                System.out.println(">> Livro '" + tituloDisp + "' está DISPONÍVEL para empréstimo.");
                            } else {
                                System.out.println(">> Livro '" + tituloDisp + "' está EMPRESTADO no momento.");
                            }
                            break;
                        }
                    }

                    if (!livroEncontrado) {
                        System.out.println(">> Livro '" + tituloDisp + "' não encontrado na biblioteca.");
                    }
                    break;
                case 8:

                    System.out.println(" Listando clientes...");
                    for (Cliente v : clientes) {
                        System.out.println(
                                "Nome: " + v.getNome());

                    }
                    break;
                case 9:
                    System.out.println("Saindo do sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
            System.out.println();
        }

        scanner.close();
    }

}
