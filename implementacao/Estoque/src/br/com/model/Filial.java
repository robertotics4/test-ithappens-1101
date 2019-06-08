/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Classe que representa uma entidade Filial no Banco de Dados Será gerada
 * automaticamente uma tabela Filial
 *
 * @author Roberto Oliveira
 */
@Entity
public class Filial implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Estoque estoque;
    private String nome;
    private String cpnj;
    private String telefone;

    /**
     * Construtor padrão da classe Filial
     */
    public Filial() {

    }

    /**
     * Construtor que recebe todos os parâmetros da classe Filial
     *
     * @param estoque
     * @param nome
     * @param cpnj
     * @param telefone
     */
    public Filial(Estoque estoque, String nome, String cpnj, String telefone) {
        this.estoque = estoque;
        this.nome = nome;
        this.cpnj = cpnj;
        this.telefone = telefone;
    }

    /**
     * Método que retorna o id da Filial
     *
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Método que altera o id da Filial
     *
     * @param id
     */
    private void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que retorna o nome da Filial
     *
     * @return String
     */
    @Column(length = 200, nullable = false)
    public String getNome() {
        return nome;
    }

    /**
     * Método que altera o nome da Filial
     *
     * @param nome - nome da filial
     */
    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    /**
     * Método que retorna o estoque da Filial
     *
     * @return String
     */
    @OneToOne
    public Estoque getEstoque() {
        return estoque;
    }

    /**
     * Método que altera o estoque da Filial
     *
     * @param estoque - estoque da filial
     */
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    /**
     * Método que retorna o CNPJ da Filial
     *
     * @return String
     */
    @Column(length = 18, nullable = false)
    public String getCpnj() {
        return cpnj;
    }

    /**
     * Método que altera o CNPJ da Filial
     *
     * @param cpnj - CNPJ da filial
     */
    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    /**
     * Método que retorna o telefone da Filial
     *
     * @return String
     */
    @Column(length = 20, nullable = false)
    public String getTelefone() {
        return telefone;
    }

    /**
     * Método que altera o telefone da Filial
     *
     * @param telefone - telefone da filial
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // ABAIXO O CÓDIGO GERADO AUTOMATICAMENTE PELA PERSISTÊNCIA DO JAVA
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filial)) {
            return false;
        }
        Filial other = (Filial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Filial[ id=" + id + " ]";
    }

}
