/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque;

import br.com.dao.ClienteDAO;
import br.com.dao.FilialDAO;
import br.com.dao.FormaPagamentoDAO;
import br.com.dao.PedidoEstoqueDAO;
import br.com.dao.ProdutoDAO;
import br.com.dao.UsuarioDAO;
import br.com.model.Cliente;
import br.com.model.Filial;
import br.com.model.FormaPagamento;
import br.com.model.ItensPedido;
import br.com.model.PedidoEstoque;
import br.com.model.Produto;
import static br.com.model.Produto_.descricao;
import br.com.model.Usuario;
import br.com.util.DataLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Principal para testes da aplicação
 *
 * @author Roberto Oliveira
 */
public class TesteEstoque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Carregando dados para teste
        DataLoader.load();

        // Simulando uma venda
        Filial filial = new FilialDAO().findByNome("Mix Mateus Cohama");
        Usuario usuario = new UsuarioDAO().findByNome("ADMIN");
        Cliente cliente = new ClienteDAO().findByNome("Roberto");
        FormaPagamento formaPagamento = new FormaPagamentoDAO().findByDescricao("CARTAO");

        PedidoEstoqueDAO pedao = new PedidoEstoqueDAO();
        PedidoEstoque pe1 = new PedidoEstoque();
        pe1.setTipoPedido(PedidoEstoque.TipoPedido.SAIDA);
        pe1.setFilial(filial);
        pe1.setUsuario(usuario);
        pe1.setCliente(cliente);
        pe1.setObservacao("Testando a primeira venda no estoque");
        
        // Incluindo itens no pedido
        ProdutoDAO pdao = new ProdutoDAO();
        List<Produto> listaProdutos = pdao.getList();
        
        List<ItensPedido> itensPedido = new ArrayList<>();
        itensPedido.add(new ItensPedido(listaProdutos.get(0), ItensPedido.StatusItem.ATIVO, 5, listaProdutos.get(0).getPrecoVenda()));
        itensPedido.add(new ItensPedido(listaProdutos.get(1), ItensPedido.StatusItem.ATIVO, 10, listaProdutos.get(1).getPrecoVenda()));
        itensPedido.add(new ItensPedido(listaProdutos.get(2), ItensPedido.StatusItem.ATIVO, 3, listaProdutos.get(2).getPrecoVenda()));
        itensPedido.add(new ItensPedido(listaProdutos.get(3), ItensPedido.StatusItem.ATIVO, 20, listaProdutos.get(3).getPrecoVenda()));
        itensPedido.add(new ItensPedido(listaProdutos.get(4), ItensPedido.StatusItem.ATIVO, 4, listaProdutos.get(4).getPrecoVenda()));
        itensPedido.add(new ItensPedido(listaProdutos.get(5), ItensPedido.StatusItem.ATIVO, 1, listaProdutos.get(5).getPrecoVenda()));
        itensPedido.add(new ItensPedido(listaProdutos.get(6), ItensPedido.StatusItem.ATIVO, 2, listaProdutos.get(6).getPrecoVenda()));
        itensPedido.add(new ItensPedido(listaProdutos.get(7), ItensPedido.StatusItem.ATIVO, 5, listaProdutos.get(7).getPrecoVenda()));
        itensPedido.add(new ItensPedido(listaProdutos.get(8), ItensPedido.StatusItem.ATIVO, 6, listaProdutos.get(8).getPrecoVenda()));
        itensPedido.add(new ItensPedido(listaProdutos.get(9), ItensPedido.StatusItem.ATIVO, 2, listaProdutos.get(9).getPrecoVenda()));
        pe1.setItensPedido(itensPedido);
        pe1.setFormaPagamento(formaPagamento);
        
    }

}
