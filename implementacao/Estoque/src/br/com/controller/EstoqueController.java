/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.model.Estoque;
import br.com.model.PedidoEstoque;
import br.com.model.Produto;
import java.util.List;

/**
 * Classe responsável em controlar as entidades dos estoques
 *
 * @author Roberto Oliveira
 */
public class EstoqueController {

    /**
     * Método que lista os produtos de um estoque
     *
     * @param estoque - estoque dos produtos a serem listados
     * @return List
     */
    public static List<Produto> listProdutos(Estoque estoque) {
        // Validando dados
        if (estoque != null) {
            List<Produto> lista = estoque.getProdutos();

            lista.stream().forEach(p -> {
                ProdutoController.print(p);
            });

            return lista;
        }

        return null;
    }

    /**
     * Método que lista os pedidos de um estoque
     *
     * @param estoque - estoque dos pedidos a serem listados
     * @return List
     */
    public static List<PedidoEstoque> listPedidos(Estoque estoque) {
        // Validando dados
        if (estoque != null) {
            List<PedidoEstoque> lista = estoque.getPedidos();

            lista.stream().forEach(p -> {
                PedidoEstoqueController.print(p);
            });

            return lista;
        }

        return null;
    }

    /**
     * Método que imprime um estoque
     *
     * @param estoque - estoque a ser impresso
     */
    public static void print(Estoque estoque) {
        System.out.println("Código: " + String.valueOf(estoque.getId()));
        System.out.printf("Quantidade Mínima: %d", estoque.getQtdMinima());
        System.out.printf("Valor total: %.2f", estoque.getValorTotal());
        System.out.printf("Imprimindo produtos -----------------------------------");
        listProdutos(estoque);
        System.out.printf("Imprimindo pedidos do estoque -------------------------");
        listPedidos(estoque);
    }
}
