/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * Classe que possui métodos de criptografia de senhas utilizando a biblioteca Jasypt
 * @author Roberto Oliveira
 */
public abstract class Criptografia {

    private static final BasicTextEncryptor cryptor = new BasicTextEncryptor();

    /**
     * Método para criptografar uma senha
     * @param senha - senha a ser criptografada
     * @return String
     */
    public static String encrypt(String senha) {
        cryptor.setPasswordCharArray("senhaCryptor".toCharArray());
        return cryptor.encrypt(senha);
    }

    /**
     * Método para descriptografar uma senha
     * @param senha - senha a ser descriptografada
     * @return String
     */
    public static String decrypt(String senha) {
        return cryptor.decrypt(senha);
    }
}
