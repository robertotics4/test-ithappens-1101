/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import br.com.dao.ClienteDAO;
import br.com.dao.EstoqueDAO;
import br.com.dao.FilialDAO;
import br.com.dao.FormaPagamentoDAO;
import br.com.dao.ProdutoDAO;
import br.com.dao.UsuarioDAO;
import br.com.model.Cliente;
import br.com.model.Estoque;
import br.com.model.Filial;
import br.com.model.FormaPagamento;
import br.com.model.Produto;
import br.com.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável em carregar dados no banco de dados para testes da
 * aplicação
 *
 * @author Roberto Oliveira
 */
public class DataLoader {

    /**
     * Método responsável em carregar os dados principais da aplicação e
     * persisti-los no banco de dados
     */
    public static void load() {
        // Criando um usuário padrão
        UsuarioDAO udao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setNome("admin");
        usuario.setSenha("1234");
        udao.persist(usuario);

        // Criando Clientes
        ClienteDAO cdao = new ClienteDAO();
        Cliente c1 = new Cliente();
        c1.setNome("Roberto");
        c1.setEndereco("Rua Projetada SN n 3");
        c1.setTelefone("(98) 98548-5478");
        cdao.persist(c1);

        Cliente c2 = new Cliente();
        c2.setNome("Vinicius");
        c2.setEndereco("Rua Emílio de Menezes 121");
        c2.setTelefone("(98) 98543-9856");
        cdao.persist(c2);

        // Criando Produtos
        ProdutoDAO pdao = new ProdutoDAO();
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("3214512458", "Queijo Piracanjuba", "Frios", 25.00, 27.90));
        produtos.add(new Produto("1354874596", "Margarina Primor", "Frios", 1.69, 2.00));
        produtos.add(new Produto("2845796547", "Pão de forma", "Padaria", 3.00, 3.49));
        produtos.add(new Produto("3287596412", "Iogurte Itambé", "Frios", 3.55, 4.00));
        produtos.add(new Produto("9578412365", "Presunto Seara", "Frios", 15.00, 18.00));
        produtos.add(new Produto("9658741528", "Mortadela Seara", "Frios", 12.25, 14.69));
        produtos.add(new Produto("9687452893", "Bolo de Fubá", "Padaria", 6.00, 8.50));
        produtos.add(new Produto("9874587412", "Picanha", "Açougue", 30.00, 34.90));
        produtos.add(new Produto("1354874596", "Sabão em pó Ype", "Limpeza", 3.60, 4.20));
        produtos.add(new Produto("3978547896", "Cerveja Glacial", "Bebidas", 0.99, 1.55));

        produtos.stream().forEach(p -> {
            pdao.persist(p);
        });

        // Criando as formas de pagamento
        FormaPagamentoDAO fpdao = new FormaPagamentoDAO();
        FormaPagamento fp1 = new FormaPagamento("Dinheiro");
        FormaPagamento fp2 = new FormaPagamento("Cartão");
        FormaPagamento fp3 = new FormaPagamento("Débito");
        fpdao.persist(fp1);
        fpdao.persist(fp2);
        fpdao.persist(fp3);

        // Criando um estoque
        EstoqueDAO edao = new EstoqueDAO();
        Estoque estoque = new Estoque();
        List<Produto> listaDeProdutos = pdao.getList();
        estoque.setProdutos(listaDeProdutos);
        edao.persist(estoque);
        
        // Criando uma Filial
        FilialDAO fdao = new FilialDAO();
        Filial filial = new Filial(estoque, "Mix Mateus Cohama", "02.989.291/0001-18", "(98) 3695-9874");
        fdao.persist(filial);
    }
}
