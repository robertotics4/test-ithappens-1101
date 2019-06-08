/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.EstoqueDAO;
import br.com.dao.PedidoEstoqueDAO;
import br.com.model.Estoque;
import static br.com.model.Filial_.estoque;
import br.com.model.ItensPedido;
import br.com.model.PedidoEstoque;
import java.util.List;

/**
 * Classe responsável em controlar as entidades dos pedidos do estoque
 *
 * @author Roberto Oliveira
 */
public class PedidoEstoqueController {

    private static PedidoEstoqueDAO pdao = new PedidoEstoqueDAO();

    /**
     * Método que salva um pedido do estoque
     *
     * @param pedidoEstoque - pedido do estoque a ser salvo
     * @return PedidoEstoque
     */
    public static PedidoEstoque save(PedidoEstoque pedidoEstoque) {
        // Validação dos dados
        if (pedidoEstoque != null) {
            if (!pedidoEstoque.getTipoPedido().equals("")
                    && pedidoEstoque.getFilial() != null
                    && pedidoEstoque.getUsuario() != null
                    && pedidoEstoque.getCliente() != null
                    && !pedidoEstoque.getObservacao().equals("")
                    && !pedidoEstoque.getItensPedido().isEmpty()
                    && pedidoEstoque.getFormaPagamento() != null
                    && !(pedidoEstoque.getValorTotal() < 0)) {

                pdao = new PedidoEstoqueDAO();
                EstoqueDAO edao = new EstoqueDAO();
                Estoque estoqueAtual = pedidoEstoque.getEstoque();

                if (pedidoEstoque.getTipoPedido() == PedidoEstoque.TipoPedido.SAIDA) {
                    // Saída de produtos no estoque - decrementando quantidade
                    pedidoEstoque.getItensPedido().stream().forEach(i -> {
                        // Verificando a disponibilidade do item
                        if (estoqueAtual.isAvailable(i.getProduto(), i.getQuantidade())) {
                            int contador = 0;
                            for (contador = 0; contador < i.getQuantidade(); contador++) {
                                estoqueAtual.getProdutos().remove(i.getProduto());
                            }
                        }
                    });

                    pdao.persist(pedidoEstoque);
                    edao.update(estoqueAtual);
                    System.out.println("Pedido do estoque do tipo " + pedidoEstoque.getTipoPedido().toString() + " efetuado com sucesso!");
                } else {
                    // Entrada de produtos no estoque - incrementando quantidade
                    pedidoEstoque.getItensPedido().stream().forEach(i -> {
                        int contador = 0;
                        for (contador = 0; contador < i.getQuantidade(); contador++) {
                            estoqueAtual.getProdutos().add(i.getProduto());
                        }
                    });

                    pdao.persist(pedidoEstoque);
                    edao.persist(estoqueAtual);
                    System.out.println("Pedido do estoque do tipo " + pedidoEstoque.getTipoPedido().toString() + " efetuado com sucesso!");
                }

                return pedidoEstoque;
            }
        }

        System.out.println("Cliente inválido");
        return null;
    }

    /**
     * Método que retorna a lista de itens do pedido
     *
     * @param pedidoEstoque - pedido do estoque
     * @return List
     */
    public static List<ItensPedido> listItensPedido(PedidoEstoque pedidoEstoque) {
        // Validando dados
        if (estoque != null) {
            List<ItensPedido> lista = pedidoEstoque.getItensPedido();

            lista.stream().forEach(i -> {
                ItensPedidoController.print(i);
            });

            return lista;
        }

        return null;
    }

    /**
     * Método que imprime um pedido do estoque
     *
     * @param pedidoEstoque - pedido do estoque a ser impresso
     */
    public static void print(PedidoEstoque pedidoEstoque) {
        System.out.println("Código: " + String.valueOf(pedidoEstoque.getId()));
        System.out.println("Tipo do Pedido: " + pedidoEstoque.getTipoPedido().toString());
        System.out.println("Observação: " + pedidoEstoque.getObservacao());
        System.out.printf("ValorTotal %.2f: ", String.valueOf(pedidoEstoque.getValorTotal()));
        System.out.println("Forma de pagamento: " + pedidoEstoque.getFormaPagamento().getDescricao());
        System.out.println("Imprimindo a filial do pedido ----------------------------------------");
        FilialController.print(pedidoEstoque.getFilial());
        System.out.println("Imprimindo o usuário do pedido ---------------------------------------");
        UsuarioController.print(pedidoEstoque.getUsuario());
        System.out.println("Imprimindo o cliente do pedido ----------------------------------------");
        ClienteController.print(pedidoEstoque.getCliente());
        System.out.println("Imprimindo os itens do pedido -----------------------------------------");
        listItensPedido(pedidoEstoque);
    }
}
