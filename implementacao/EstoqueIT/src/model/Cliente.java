/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa uma entidade 'Cliente' no Banco de Dados
 * Será criada automaticamente uma tabela Cliente
 * @author Roberto Oliveira
 */
@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private Endereco endereco;
    private String telefone;

    /**
     * Método que retorna o id do cliente
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Método que altera o id do cliente
     * @param id 
     */
    private void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que retorna o nome do cliente
     * @return String
     */
    @Column(length = 200, nullable = false)
    public String getNome() {
        return nome;
    }

    /**
     * Método que altera o nome do cliente
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    /**
     * Método que retorna o endereço do cliente
     * @return Endereco
     */
    @Embedded
    @Column(nullable = false)
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Método que altera o endereço do Cliente
     * @param endereco 
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * Método que retorna o telefone do cliente
     * @return String
     */
    @Column(length = 20, nullable = false)
    public String getTelefone() {
        return telefone;
    }

    /**
     * Método que altera o telefone do cliente
     * @param telefone 
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // MÉTODOS GERADOS AUTOMATICAMENTE PELA PERSISTÊNCIA DO JAVA
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cliente[ id=" + id + " ]";
    }

}
