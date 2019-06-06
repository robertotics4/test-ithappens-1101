/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 *
 * @author Roberto Oliveira
 */
public abstract class Criptografia {

    private static final BasicTextEncryptor cryptor = new BasicTextEncryptor();

    public static String encrypt(String senha) {
        cryptor.setPasswordCharArray("senhaCryptor".toCharArray());
        return cryptor.encrypt(senha);
    }

    public static String decrypt(String senha) {
        return cryptor.decrypt(senha);
    }
}
