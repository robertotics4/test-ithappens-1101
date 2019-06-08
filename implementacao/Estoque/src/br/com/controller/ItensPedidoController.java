/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.ItensPedidoDAO;
import br.com.model.ItensPedido;
import java.util.List;

/**
 * Classe responsável em controlar as entidades dos itens do pedido
 *
 * @author Roberto Oliveira
 */
public class ItensPedidoController {

    private static ItensPedidoDAO idao;

    /**
     * Método que salva um item do pedido no banco de dados
     *
     * @param itensPedido - item do pedido
     * @return ItensPedido
     */
    public static ItensPedido save(ItensPedido itensPedido) {
        // Validação dos dados
        if (itensPedido != null) {
            if (itensPedido.getProduto() != null
                    && !itensPedido.getStatusItem().toString().equals("")
                    && !(itensPedido.getQuantidade() < 0)
                    && !(itensPedido.getValorUnitario() < 0)) {

                List<ItensPedido> itensAdicionados = itensPedido.getPedidoEstoque().getItensPedido();

                itensAdicionados.stream().forEach(i -> {
                    if (itensPedido.getId() == i.getId()) {
                        System.out.println("Não é possível adicionar um item já existente no pedido");
                    } else {
                        idao = new ItensPedidoDAO();
                        idao.persist(itensPedido);
                        System.out.println("Item " + itensPedido.getProduto().getDescricao() + " adicionado ao pedido!");
                    }
                });

                return itensPedido;
            }
        }

        System.out.println("Item inválido");
        return null;
    }

    /**
     * Método que imprime um item do pedido
     *
     * @param itensPedido - item do pedido a ser impresso
     */
    public static void print(ItensPedido itensPedido) {
        System.out.println("Código: " + String.valueOf(itensPedido.getId()));
        System.out.println("Status do item: " + itensPedido.getStatusItem().toString());
        System.out.println("Quantidade do item: " + String.valueOf(itensPedido.getQuantidade()));
        System.out.println("Valor unitário: " + String.valueOf(itensPedido.getValorUnitario()));
        System.out.println("Imprimindo o produto do item --------------------------------------");
        ProdutoController.print(itensPedido.getProduto());
    }

}
