/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.CategoriaDAO;
import dao.EstoqueDAO;
import dao.FilialDAO;
import dao.FormaPagamentoDAO;
import dao.ProdutoDAO;
import dao.ProdutoEstoqueDAO;
import dao.UsuarioDAO;
import model.Categoria;
import model.Estoque;
import model.Filial;
import model.FormaPagamento;
import model.Produto;
import model.ProdutoEstoque;
import model.Usuario;

/**
 * Classe que possui os métodos de configuração do Sistema Métodos de criação de
 * usuários padrão e alimentação do Banco de Dados para testes
 *
 * @author Roberto Oliveira
 */
public class ConfiguracoesSistema {

    /**
     * Método que carrega todas as configurações iniciais do sistema
     */
    public static void load() {

        // Criando o usuário padrão do sistema
        UsuarioDAO udao = new UsuarioDAO();
        Usuario usuario = udao.findByNome("admin");

        if (usuario == null) {
            // Se não existir nenhum usuário, o sistema estará carregando pela primeira vez
            usuario = new Usuario();
            usuario.setNome("admin");
            usuario.setSenha("123456");
            udao.persist(usuario);

            // Criando as formas de pagamento padrão
            FormaPagamentoDAO fpDao = new FormaPagamentoDAO();
            fpDao.persist(new FormaPagamento("Dinheiro"));
            fpDao.persist(new FormaPagamento("Débito"));
            fpDao.persist(new FormaPagamento("Cartão de Crédito"));

            // Executando método de simulação de dados
            simulateData();
        }
    }

    /**
     * Método responsável
     */
    private static void simulateData() {
        // Criando uma filial
        FilialDAO fdao = new FilialDAO();
        Filial filial = new Filial();
        filial.setNome("Mix Mateus Cohama");
        filial.setCpnj("64.177.381/0001-61");
        filial.setTelefone("(98) 3225-7888");

        // Criando categorias
        CategoriaDAO cdao = new CategoriaDAO();
        Categoria ct1 = new Categoria("Não perecíveis");
        Categoria ct2 = new Categoria("Frios");
        cdao.persist(ct1);
        cdao.persist(ct2);

        // Criando produtos
        ProdutoDAO pdao = new ProdutoDAO();
        Produto p1 = new Produto();
        p1.setCodigoBarras("1234567890");
        p1.setDescricao("Macarrão Estrela");
        p1.setCategoria(ct1);
        p1.setPrecoCusto(1.60);
        p1.setPrecoVenda(2.10);
        pdao.persist(p1);

        Produto p2 = new Produto();
        p2.setCodigoBarras("3548756321");
        p2.setDescricao("Iogurte Italac");
        p2.setCategoria(ct2);
        p2.setPrecoCusto(3.00);
        p2.setPrecoVenda(3.69);
        pdao.persist(p2);

        // Criando um estoque
        EstoqueDAO edao = new EstoqueDAO();
        Estoque estoque = new Estoque();
        estoque.setQtdMinima(0);

//        // Criando produtos para serem adicionados no estoque
//        ProdutoEstoqueDAO pedao = new ProdutoEstoqueDAO();
//        ProdutoEstoque pe1 = new ProdutoEstoque();
//        pe1.setProduto(p1);
//        pe1.setQtdProduto(50);
//        pedao.persist(pe1);
//        
//        ProdutoEstoque pe2 = new ProdutoEstoque();
//        pe2.setProduto(p2);
//        pe2.setQtdProduto(25);
//        pedao.persist(pe2);
//
//        // Adicionando produtos ao estoque
//        estoque.getProdutos().add(pe1);
//        estoque.getProdutos().add(pe2);
        edao.persist(estoque);

        // Adicionando estoque à filial
        filial.setEstoque(estoque);
        fdao.persist(filial);
    }
}
