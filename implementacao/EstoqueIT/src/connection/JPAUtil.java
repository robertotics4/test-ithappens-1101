/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Roberto Oliveira
 */
public class JPAUtil {

    private static EntityManagerFactory factory;
    private static String user = "root";
    private static String pass = "root";
    private static String enderecoServidor = "localhost";
    private static String portaServidor = "3306";
    private static Map proprieties = getProprieties(user, pass);

    static {
        factory = Persistence.createEntityManagerFactory("EstoqueITPU", proprieties);

    }

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public static void close() {
        factory.close();
    }

    public static Map getProprieties(String user, String pass) {
        Map pmap = new HashMap();

        pmap.put("javax.persistence.jdbc.url", getUrl());
        pmap.put("javax.persistence.jdbc.user", user);
        pmap.put("javax.persistence.jdbc.password", pass);
        pmap.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        pmap.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
        pmap.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        pmap.put("hibernate.show_sql", "true");
        pmap.put("hibernate.format_sql", "true");
        pmap.put("hibernate.hbm2ddl.auto", "update");

        return pmap;
    }

    public static String getEnderecoServidor() {
        return JPAUtil.enderecoServidor;
    }

    public static String getPortaServidor() {
        return JPAUtil.portaServidor;
    }

    public static String getUrl() {
        return "jdbc:mysql://" + JPAUtil.enderecoServidor + ":" + JPAUtil.portaServidor + "/estoqueit?createDatabaseIfNotExist=true";
    }
}
