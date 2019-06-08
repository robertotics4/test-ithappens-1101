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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Carregando dados para teste
        DataLoader.load();

        int opcao = 0;

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

    }

    public static void openClientes() {

    }

    public static void openFiliais() {

    }

    public static void openProdutos() {

    }

    public static void openPedido() {
        int opcao = 0;

        do {
            System.out.println("Digite o nome da filial para o pedido");

        } while (opcao != 0);
    }

    public static void clear() {
        int contador = 0;

        for (contador = 0; contador < 50; contador++) {
            System.out.println("\r");
        }
    }

}
