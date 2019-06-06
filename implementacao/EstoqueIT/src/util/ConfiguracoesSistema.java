/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.UsuarioDAO;
import model.Usuario;

/**
 *
 * @author Roberto Oliveira
 */
public class ConfiguracoesSistema {

    public static void load() {
        UsuarioDAO udao = new UsuarioDAO();
        Usuario usuario = udao.findByNome("admin");

        if (usuario == null) {
            usuario = new Usuario();
            usuario.setNome("admin");
            usuario.setSenha("123456");
            udao.persist(usuario);
        }
    }
}
