/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.FormaPagamentoDAO;
import dao.UsuarioDAO;
import model.FormaPagamento;
import model.Usuario;

/**
 *
 * @author Roberto Oliveira
 */
public class ConfiguracoesSistema {

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
            
            
            
        }
    }
}
