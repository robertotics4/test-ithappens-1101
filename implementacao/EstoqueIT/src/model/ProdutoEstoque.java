/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa uma entidade ProdutoEstoque
 *
 * @author Roberto Oliveira
 */
@Entity
public class ProdutoEstoque implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private Produto produto;
    private int qtdProduto;

    /**
     * Construtor padrão da classe ProdutoEstoque
     */
    public ProdutoEstoque() {
    }

    /**
     * Construtor que recebe todos os parâmetros da classe ProdutoEstoque
     *
     * @param produto - produto
     * @param qtdProduto - quantidade de produtos
     */
    public ProdutoEstoque(Produto produto, int qtdProduto) {
        this.produto = produto;
        this.qtdProduto = qtdProduto;
    }

    /**
     * Método que retorna o id do Produto do Estoque
     *
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Método que altera o id do produto do estoque
     *
     * @param id - id do produto no estoque
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que retorna o produto do estoque
     *
     * @return Produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Método que retorna o produto do estoque
     *
     * @param produto - produto no estoque
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Método que retorna a quantidade de produtos no estoque
     *
     * @return int
     */
    public int getQtdProduto() {
        return qtdProduto;
    }

    /**
     * Método que altera a quantidade de produtos no estoque
     *
     * @param qtdProduto - quantidade de produtos no estoque
     */
    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
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
        if (!(object instanceof ProdutoEstoque)) {
            return false;
        }
        ProdutoEstoque other = (ProdutoEstoque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ProdutoEstoque[ id=" + id + " ]";
    }

}
