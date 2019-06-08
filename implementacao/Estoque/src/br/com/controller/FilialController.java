/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.FilialDAO;
import br.com.model.Filial;
import java.util.List;

/**
 * Classe responsável em controlar as entidades das filiais
 *
 * @author Roberto Oliveira
 */
public class FilialController {

    private static FilialDAO fdao;

    /**
     * Método que salva uma filial no banco de dados
     * @param filial - filial a ser salva
     * @return Filial
     */
    public static Filial save(Filial filial) {
        // Validação dos dados
        if (filial != null) {
            if (filial.getEstoque() != null
                    && !filial.getNome().equals("")
                    && !filial.getCpnj().equals("")
                    && !filial.getTelefone().equals("")) {
                fdao = new FilialDAO();
                fdao.persist(filial);
                System.out.println("Filial " + filial.getNome() + " inserida com sucesso!");

                return filial;
            }
        }

        System.out.println("Filial inválida");
        return null;
    }

    /**
     * Método que busca uma filial no banco de dados
     * @param nome - nome da filial a ser encontrada
     * @return Filial
     */
    public static Filial find(String nome) {
        // Validação dos dados
        if (!nome.equals("")) {
            fdao = new FilialDAO();
            Filial retorno = fdao.findByNome(nome);

            if (retorno != null) {
                print(retorno);
                return retorno;
            } else {
                System.out.println("Filial não encontrada");
            }
        }

        System.out.println("Filial inválida");
        return null;
    }

    /**
     * Método que lista todas as filiais salvas no banco de dados
     * @return List
     */
    public static List<Filial> findAll() {
        fdao = new FilialDAO();
        List<Filial> lista = fdao.getList();

        lista.stream().forEach(f -> {
            print(f);
        });

        return lista;
    }

    /**
     * Método que imprime uma filial
     * @param filial - filial a ser impressa
     */
    public static void print(Filial filial) {
        System.out.println("Código: " + String.valueOf(filial.getId()));
        System.out.println("Nome: " + filial.getNome());
        System.out.println("CNPJ: " + filial.getCpnj());
        System.out.println("Telefone: " + filial.getTelefone());
        System.out.println("Imprimindo estoque --------------------------------");
        EstoqueController.print(filial.getEstoque());
    }
}
