/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.UsuarioDAO;
import br.com.model.Usuario;
import java.util.List;

/**
 * Classe responsável em controlar as entidades dos usuarios
 *
 * @author Roberto Oliveira
 */
public abstract class UsuarioController {

    private static UsuarioDAO udao;

    /**
     * Método responsável por guardar um novo usuário
     *
     * @param usuario - usuário a ser inserido
     * @return Usuario
     */
    public static Usuario save(Usuario usuario) {
        // Validação dos dados
        if (usuario != null) {
            if (!usuario.getNome().equals("") && !usuario.getSenha().equals("")) {
                udao = new UsuarioDAO();
                udao.persist(usuario);
                System.out.println("Usuário " + usuario.getNome() + " inserido com sucesso!");

                return usuario;
            }
        }

        System.out.println("Usuário inválido");
        return null;
    }

    /**
     * Método que busca um usuário pelo nome
     *
     * @param nome - nome do usuário a ser encontrado
     * @return Usuario
     */
    public static Usuario find(String nome) {
        // Validação dos dados
        if (!nome.equals("")) {
            udao = new UsuarioDAO();
            Usuario retorno = udao.findByNome(nome);

            if (retorno != null) {
                print(retorno);
                return retorno;
            } else {
                System.out.println("Usuário não encontrado");
            }
        }

        System.out.println("Usuário inválido");
        return null;
    }

    /**
     * Método que retorna a lista de todos os usuários
     *
     * @return List
     */
    public static List<Usuario> findAll() {
        udao = new UsuarioDAO();
        List<Usuario> lista = udao.getList();

        lista.stream().forEach(u -> {
            print(u);
        });

        return lista;
    }

    /**
     * Método que deleta um usuário do banco de dados
     *
     * @param usuario - usuário a ser removido
     * @return Usuario
     */
    public static Usuario remove(Usuario usuario) {
        // Validação dos dados
        if (usuario != null) {
            udao = new UsuarioDAO();
            Usuario retorno = udao.findById(usuario.getId());

            if (retorno != null) {
                udao.remove(usuario);
                System.out.println("Usuário " + usuario.getNome() + " inserido com sucesso!");
                return retorno;
            } else {
                System.out.println("Usuário não encontrado");
            }
        }

        System.out.println("Usuário inválido");
        return null;
    }

    /**
     * Método que imprime um usuário
     * @param usuario - usuário a ser impresso
     */
    public static void print(Usuario usuario) {
        System.out.println("Código: " + String.valueOf(usuario.getId()));
        System.out.println("Nome: " + usuario.getNome());
    }
}
