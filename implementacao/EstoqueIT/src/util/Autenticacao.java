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
public class Autenticacao {

    public static Usuario authenticate(String nomeDigitado, String senhaDigitada) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = dao.findByNome(nomeDigitado);

        if (usuario != null) {
            String nomeBanco = usuario.getNome();
            String senhaBanco = usuario.getSenha();

            if (senhaBanco.equals(senhaDigitada) && nomeBanco.equals(nomeDigitado)) {
                return usuario;
            }
        }

        return null;
    }
}
