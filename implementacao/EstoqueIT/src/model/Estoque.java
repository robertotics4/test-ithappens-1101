/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Classe que representa uma entidade de Estoque no Banco de Dados
 * Será gerada automaticamente uma tabela Estoque
 * @author Roberto Oliveira
 */
@Entity
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private List<ProdutoEstoque> produtos;
    private int qtdMinima;
    private double valorTotal;

    /**
     * Construtor padrão da classe Estoque
     */
    public Estoque() {
        produtos = new ArrayList<>();
        qtdMinima = 0;
        valorTotal = 0;
    }

    /**
     * Método que retorna o id do Estoque
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Método que altera o id do Estoque
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que retorna a lista de produtos no Estoque
     * @return List<ProdutoEstoque>
     */
    @OneToMany
    @Column(nullable = true)
    public List<ProdutoEstoque> getProdutos() {
        return produtos;
    }

    /**
     * Método que altera a lista de produtos no Estoque
     * @param produtos 
     */
    public void setProdutos(List<ProdutoEstoque> produtos) {
        this.produtos = produtos;
    }

    /**
     * Método que retorna a quantidade mínima de produtos
     * @return int
     */
    @Column(nullable = false)
    public int getQtdMinima() {
        return qtdMinima;
    }

    /**
     * Método que altera a quantidade mínima de produtos
     * @param qtdMinima 
     */
    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    /**
     * Método que retorna o Valor total dos produtos
     * @return double
     */
    @Column(nullable = false)
    public double getValorTotal() {
        produtos.stream().forEach(p -> {
            valorTotal += p.getProduto().getPrecoCusto();
        });

        return valorTotal;
    }

    /**
     * Método que altera o valor total dos produtos
     * @param valorTotal 
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
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
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Estoque[ id=" + id + " ]";
    }

}
