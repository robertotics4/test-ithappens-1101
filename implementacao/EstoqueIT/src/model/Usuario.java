/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa uma entidade Usuário no Banco de Dados
 * Uma tabela Usuário será criada automaticamente
 * @author Roberto Oliveira
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private String senha;

    /**
     * Método que retorna o id do usuário
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Método que altera o id do usuário
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que retorna o nome do usuário
     * @return String
     */
    @Column(length = 200, unique = true, nullable = false)
    public String getNome() {
        return nome;
    }

    /**
     * Método que altera o nome do usuário
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retorna a senha do usuário
     * @return String
     */
    @Column(nullable = false)
    public String getSenha() {
        return this.senha;
    }

    /**
     * Método que altera a senha do usuário
     * @param senha 
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    // CÓDIGO GERADO AUTOMATICAMENTE PELA PERSISTÊNCIA DO JAVA
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuario[ id=" + id + " ]";
    }
}
