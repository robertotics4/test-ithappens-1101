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
import javax.persistence.OneToOne;

/**
 * Classe que representa uma entidade de Produto no Banco de Dados
 * Será criada automaticamente uma tabela Produto
 * @author Roberto Oliveira
 */
@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String codigoBarras;
    private String descricao;
    private Categoria categoria;
    private double precoCusto;
    private double precoVenda;

    /**
     * Método que retorna o id do produto
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Método que altera o id do produto
     * @param id 
     */
    private void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que retorna o código de barras do produto
     * @return String
     */
    @Column(length = 50, nullable = false)
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * Método que altera o código de barras do produto
     * @param codigoBarras 
     */
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras.toUpperCase();
    }

    /**
     * Método que altera a descrição do produto
     * @return String
     */
    @Column(length = 200, nullable = false)
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método que altera a descrição do produto
     * @param descricao 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao.toUpperCase();
    }

    /**
     * Método que retorna a categoria do produto
     * @return Categoria
     */
    @OneToOne
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Método que altera a categoria do produto
     * @param categoria 
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Método que retorna o preço de custo do produto
     * @return double
     */
    @Column(nullable = false)
    public double getPrecoCusto() {
        return precoCusto;
    }

    /**
     * Método que altera o preço de custo do produto
     * @param precoCusto 
     */
    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    /**
     * Método que retorna o preço de venda do produto
     * @return double
     */
    @Column(length = 200, nullable = false)
    public double getPrecoVenda() {
        return precoVenda;
    }

    /**
     * Método que altera o preço de venda do produto
     * @param precoVenda 
     */
    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produto[ id=" + id + " ]";
    }
    
}
