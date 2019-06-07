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
 * Classe que representa uma entidade 'Categoria' no Banco de Dados Será gerada
 * automaticamente uma tabela Categoria
 *
 * @author Roberto oliveira
 */
@Entity
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String descricao;

    /**
     * Construtor padrão da classe Categoria
     */
    public Categoria() {
    }

    /**
     * Construtor que recebe todos os parâmetros da classe Categoria
     *
     * @param descricao
     */
    public Categoria(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Método que retorna o id da categiria
     *
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Método que altera o id da categoria
     *
     * @param id
     */
    private void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que retorna a descrição da categoria
     *
     * @return String
     */
    @Column(length = 200, nullable = false)
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método que altera a descrição
     *
     * @param descricao
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
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Categoria[ id=" + id + " ]";
    }
}
