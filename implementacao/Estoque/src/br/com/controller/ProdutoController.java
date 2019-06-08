/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.ProdutoDAO;
import br.com.model.Produto;
import java.util.List;

/**
 * Classe responsável em controlar as entidades dos produtos
 *
 * @author Roberto Oliveira
 */
public class ProdutoController {

    private static ProdutoDAO pdao;

    /**
     * Método que salva um produto no banco de dados
     *
     * @param produto - produto a ser salvo
     * @return Produto
     */
    public static Produto save(Produto produto) {
        // Validação dos dados
        if (produto != null) {
            if (!produto.getCodigoBarras().equals("")
                    && !produto.getDescricao().equals("")
                    && !produto.getCategoria().equals("")
                    && !(produto.getPrecoCusto() <= 0) && !(produto.getPrecoVenda() <= 0)) {
                pdao = new ProdutoDAO();
                pdao.persist(produto);
                System.out.println("Produto " + produto.getDescricao() + " inserido com sucesso!");

                return produto;
            }
        }

        System.out.println("Produto inválido");
        return null;
    }

    /**
     * Método que busca um produto pelo sequencial
     *
     * @param sequencial - código sequencial do produto a ser encontrado
     * @return Produto
     */
    public static Produto find(Long sequencial) {
        // Validação dos dados
        if (!(sequencial <= 0)) {
            pdao = new ProdutoDAO();
            Produto retorno = pdao.findById(sequencial);

            if (retorno != null) {
                return retorno;
            } else {
                System.out.println("Produto não encontrado");
            }
        }

        System.out.println("Produto inválido");
        return null;
    }

    /**
     * Método que busca um produto pelo código de barras ou descrição
     *
     * @param codigoBarras - código de barras do produto a ser encontrado
     * @param descricao - descrição do produto a ser encontrado
     * @return Produto
     */
    public static Produto find(String codigoBarras, String descricao) {
        // Validação dos dados
        if (!codigoBarras.equals("")) {
            pdao = new ProdutoDAO();
            Produto retorno = pdao.findByCodBarras(codigoBarras);

            if (retorno != null) {
                return retorno;
            } else {
                System.out.println("Produto não encontrado");
            }
        }

        if (!descricao.equals("")) {
            pdao = new ProdutoDAO();
            Produto retorno = pdao.findByCodBarras(descricao);

            if (retorno != null) {
                return retorno;
            } else {
                System.out.println("Produto não encontrado");
            }
        }

        System.out.println("Produto inválido");
        return null;
    }

    /**
     * Método que retorna todos os produtos salvos no banco de dados
     *
     * @return List
     */
    public static List<Produto> findAll() {
        pdao = new ProdutoDAO();
        List<Produto> lista = pdao.getList();

        lista.stream().forEach(p -> {
            System.out.println("Código: " + String.valueOf(p.getId()));
            System.out.println("Código de Barras: " + p.getCodigoBarras());
            System.out.println("Descrição: " + p.getDescricao());
            System.out.println("Categoria: " + p.getCategoria());
            System.out.printf("Preço de Custo: %.2f", p.getPrecoCusto());
            System.out.printf("Preço de Venda: %.2f", p.getPrecoVenda());
        });

        return lista;
    }
}
