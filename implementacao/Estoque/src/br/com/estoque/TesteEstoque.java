/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque;

import br.com.util.DataLoader;
import java.util.Scanner;

/**
 * Classe Principal para testes da aplicação
 *
 * @author Roberto Oliveira
 */
public class TesteEstoque {

    private static Scanner scanner = new Scanner(System.in);
    private static int opcao = -1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Carregando dados para teste
        DataLoader.load();

        do {
            System.out.println("SISTEMA DE ESTOQUE - ITHAPPENS");
            System.out.println("1. Usuarios");
            System.out.println("2. Clientes");
            System.out.println("3. Filiais");
            System.out.println("4. Produtos");
            System.out.println("5. Efetuar Pedidos (ENTRADA / SAÍDA)");
            System.out.println("0. Sair\n\n->: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    openUsuarios();
                    break;
                case 2:
                    openClientes();
                    break;
                case 3:
                    openFiliais();
                    break;
                case 4:
                    openProdutos();
                    break;
                case 5:
                    openPedido();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

            clear();
        } while (opcao != 0);

    }

    public static void openUsuarios() {
        opcao = -1;

        do {
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Excluir Usuários");
            System.out.println("0. Sair\n\n->: ");
            scanner.nextInt();
            clear();
        } while (opcao != 0);
    }

    public static void openClientes() {
        opcao = -1;

        do {
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Excluir Clientes");
            System.out.println("0. Sair\n\n->: ");
            scanner.nextInt();
            clear();
        } while (opcao != 0);
    }

    public static void openFiliais() {
        opcao = -1;

        do {
            System.out.println("1. Cadastrar Filial");
            System.out.println("2. Listar Filiais");
            System.out.println("3. Excluir Filiais");
            System.out.println("0. Sair\n\n->: ");
            scanner.nextInt();
        } while (opcao != 0);
    }

    public static void openProdutos() {
        opcao = -1;

        do {
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Excluir Produtos");
            System.out.println("0. Sair\n\n->: ");
            scanner.nextInt();
        } while (opcao != 0);
    }

    public static void openPedido() {
//        opcao = -1;
//
//        do {
//            System.out.println("1. Efetuar Pedido");
//            System.out.println("2. Listar Pedidos");
//            System.out.println("0. Sair\n\n->: ");
//            scanner.nextInt();
//            clear();
//
//            switch (opcao) {
//                case 1:
//                    System.out.println("Digite o nome da Filial: ");
//                    Filial filial = FilialController.find(scanner.nextLine());
//
//                    if (filial != null) {
//                        PedidoEstoque pedidoEstoque = new PedidoEstoque(filial.getEstoque());
//
//                        System.out.println("Digite o tipo de pedido (E = Entrada / S = Saida): ");
//                        if (scanner.nextLine().toUpperCase().charAt(0) == 'E') {
//
//                        } else if (scanner.nextLine().toUpperCase().charAt(0) == 'S') {
//                            System.out.println("Digite o nome do usuário: ");
//                            Usuario usuario = UsuarioController.find(scanner.nextLine());
//
//                            System.out.println("\nClientes --------------------------------");
//                            ClienteController.findAll();
//                            System.out.println("Digite o nome do cliente: ");
//                            Cliente cliente = ClienteController.find(scanner.nextLine());
//
//                            System.out.println("Digite a observação da entrega: ");
//                            pedidoEstoque.setObservacao(scanner.nextLine());
//                            pedidoEstoque.setCliente(cliente);
//                            pedidoEstoque.setUsuario(usuario);
//                            pedidoEstoque.setTipoPedido(PedidoEstoque.TipoPedido.SAIDA);
//
//                            System.out.println("\nProdutos --------------------------------");
//                            
//                            do {
//                                Estoque estoque = filial.getEstoque();
//                                EstoqueController.listProdutos(estoque);
//                                
//                                System.out.println("Digite o nome do produto a ser adicionado (OK para sair): ");
//                                
//                                ItensPedido itensPedido = new ItensPedido(pedidoEstoque);
//                                
//                            } while (!scanner.nextLine().toUpperCase().equals("OK"));
//                        }
//                    }
//
//                    break;
//                case 2:
//                    break;
//                default:
//                    System.out.println("Opção inválida.");
//            }
//        } while (opcao != 0);
    }

    public static void clear() {
        int contador = 0;

        for (contador = 0; contador < 50; contador++) {
            System.out.println("\r");
        }
    }

}
