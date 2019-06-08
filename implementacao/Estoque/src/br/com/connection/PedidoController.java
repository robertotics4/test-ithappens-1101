/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.connection;

import br.com.model.PedidoEstoque;

/**
 *
 * @author Roberto Oliveira
 */
public abstract class PedidoController {

    public static void confirmOlder (PedidoEstoque pedidoEstoque) {
        pedidoEstoque.getItensPedido().stream().forEach(ip -> {
            
        });
    }
}
