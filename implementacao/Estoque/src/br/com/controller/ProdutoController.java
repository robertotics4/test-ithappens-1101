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
                System.out.println("Código: " + String.valueOf(retorno.getId()));
                System.out.println("Código de Barras: " + retorno.getCodigoBarras());
                System.out.println("Descrição: " + retorno.getDescricao());
                System.out.println("Categoria: " + retorno.getCategoria());
                System.out.printf("Preço de Custo: %.2f", retorno.getPrecoCusto());
                System.out.printf("Preço de Venda: %.2f", retorno.getPrecoVenda());
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
        if (!codigoBarras.equals("") && !descricao.equals("")) {
            pdao = new ProdutoDAO();
            Produto retorno = new Produto();

            if (!descricao.equals("")) {
                retorno = pdao.findByCodBarras(codigoBarras);
            }

            if (!descricao.equals("")) {
                retorno = pdao.findByCodBarras(descricao);
            }

            if (retorno != null) {
                print(retorno);
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

        if (lista.isEmpty()) {
            System.out.println("Não existem produtos cadastrados");
        } else {
            lista.stream().forEach(p -> {
                print(p);
            });

            return lista;
        }

        return null;
    }

    /**
     * Método que imprime um produto
     *
     * @param produto - produto a ser impresso
     */
    public static void print(Produto produto) {
        System.out.println("Código: " + String.valueOf(produto.getId()));
        System.out.println("Código de Barras: " + produto.getCodigoBarras());
        System.out.println("Descrição: " + produto.getDescricao());
        System.out.println("Categoria: " + produto.getCategoria());
        System.out.printf("Preço de Custo: %.2f", produto.getPrecoCusto());
        System.out.printf("Preço de Venda: %.2f", produto.getPrecoVenda());
    }
}
