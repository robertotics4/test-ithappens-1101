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

/**
 * Classe que representa uma entidade Forma de Pagamento no Banco de Dados
 * @author Roberto Oliveira
 */
@Entity
public class FormaPagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String descricao;

    /**
     * Construtor padrão da classe FormaPagamento
     */
    public FormaPagamento() {
    }

    /**
     * Construtor que recebe o parâmetro descrição
     * @param descricao - descrição da forma de pagamento
     */
    public FormaPagamento(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Método que retorna o id da forma de pagamento
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Método que altera o id da forma de pagamento
     * @param id - id da forma de pagamento
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que retorna a descrição da forma de pagamento
     * @return String
     */
    @Column(length = 200, nullable = false)
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método que altera a descrição da forma de pagamento
     * @param descricao - descrição da forma de pagamento
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
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
        if (!(object instanceof FormaPagamento)) {
            return false;
        }
        FormaPagamento other = (FormaPagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.FormaPagamento[ id=" + id + " ]";
    }

}
