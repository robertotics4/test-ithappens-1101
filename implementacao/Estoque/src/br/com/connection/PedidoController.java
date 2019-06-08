/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.connection;

import br.com.dao.PedidoEstoqueDAO;
import static br.com.model.Filial_.estoque;
import br.com.model.PedidoEstoque;

/**
 * classe de controle dos pedidos
 *
 * @author Roberto Oliveira
 */
public abstract class PedidoController {

    public static boolean confirmOlder(PedidoEstoque pedidoEstoque) {
        PedidoEstoqueDAO pedao = new PedidoEstoqueDAO();
        Estoque estoque = pedidoEstoque.getFilial().getEstoque();

        if (pedidoEstoque.getTipoPedido() == PedidoEstoque.TipoPedido.SAIDA) {
            pedidoEstoque.getItensPedido().stream().forEach(ip -> {
                if (estoque.isAvailable(ip.getProduto(), ip.getQuantidade())) {

                } else {

                }
            });
        }

        return false;
    }
}
