/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque;

import br.com.util.DataLoader;

/**
 * Classe Principal para testes da aplicação
 * @author Roberto Oliveira
 */
public class TesteEstoque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Carregando dados para teste
        DataLoader.load();
    }
    
}
