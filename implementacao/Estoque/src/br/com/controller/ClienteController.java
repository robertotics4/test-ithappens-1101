/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.ClienteDAO;
import br.com.model.Cliente;
import java.util.List;

/**
 * Classe responsável em controlar as entidades dos clientes
 *
 * @author Roberto Oliveira
 */
public class ClienteController {

    private static ClienteDAO cdao;

    /**
     * Método que salva um cliente no banco de dados
     *
     * @param cliente - cliente a ser salvo
     * @return Cliente
     */
    public static Cliente save(Cliente cliente) {
        // Validação dos dados
        if (cliente != null) {
            if (!cliente.getNome().equals("") && !cliente.getEndereco().equals("") && !cliente.getTelefone().equals("")) {
                cdao = new ClienteDAO();
                cdao.persist(cliente);
                System.out.println("Cliente " + cliente.getNome() + " inserido com sucesso!");

                return cliente;
            }
        }

        System.out.println("Cliente inválido");
        return null;
    }

    /**
     * Método que busca um cliente pelo nome no banco de dados
     *
     * @param nome - nome do cliente a ser encontrado
     * @return Cliente
     */
    public static Cliente find(String nome) {
        // Validação dos dados
        if (!nome.equals("")) {
            cdao = new ClienteDAO();
            Cliente retorno = cdao.findByNome(nome);

            if (retorno != null) {
                print(retorno);
                return retorno;
            } else {
                System.out.println("Cliente não encontrado");
            }
        }

        System.out.println("Cliente inválido");
        return null;
    }

    /**
     * Método que retorna todos os clientes salvos
     *
     * @return List
     */
    public static List<Cliente> findAll() {
        cdao = new ClienteDAO();
        List<Cliente> lista = cdao.getList();

        lista.stream().forEach(c -> {
            print(c);
        });

        return lista;
    }

    /**
     * Método que remove um cliente do banco
     *
     * @param cliente - cliente a ser removido
     * @return Cliente
     */
    public static Cliente remove(Cliente cliente) {
        // Validação dos dados
        if (cliente != null) {
            cdao = new ClienteDAO();
            Cliente retorno = cdao.findById(cliente.getId());

            if (retorno != null) {
                cdao.remove(cliente);
                System.out.println("Cliente " + cliente.getNome() + " inserido com sucesso!");
                return retorno;
            } else {
                System.out.println("Cliente não encontrado");
            }
        }

        System.out.println("Cliente inválido");
        return null;
    }

    /**
     * Método que imprime um cliente
     * @param cliente - cliente a ser impresso
     */
    public static void print(Cliente cliente) {
        System.out.println("Código: " + String.valueOf(cliente.getId()));
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Telefone: " + cliente.getTelefone());
    }
}
