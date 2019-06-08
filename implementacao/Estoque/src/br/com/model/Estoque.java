/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

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
 * Classe que representa uma entidade de Estoque no Banco de Dados Será gerada
 * automaticamente uma tabela Estoque
 *
 * @author Roberto Oliveira
 */
@Entity
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private List<PedidoEstoque> pedidos;
    private List<Produto> produtos;
    private int qtdMinima;
    private double valorTotal;

    /**
     * Construtor padrão da classe Estoque
     */
    public Estoque() {
        pedidos = new ArrayList<>();
        produtos = new ArrayList<>();
        qtdMinima = 0;
        valorTotal = 0;
    }

    /**
     * Método que retorna o id do Estoque
     *
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Método que altera o id do Estoque
     *
     * @param id
     */
    private void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que retorna a lista de pedidos do estoque
     *
     * @return List
     */
    @OneToMany
    public List<PedidoEstoque> getPedidos() {
        return pedidos;
    }

    /**
     * Método que altera a lista de pedidos do estoque
     *
     * @param pedidos - lista de pedidos do estoque
     */
    public void setPedidos(List<PedidoEstoque> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * Método que retorna a lista de produtos do estoque
     *
     * @return List
     */
    @OneToMany
    public List<Produto> getProdutos() {
        return produtos;
    }

    /**
     * Método que altera a lista de produtos do estoque
     *
     * @param produtos - produtos do estoque
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    /**
     * Método que retorna a quantidade mínima de produtos
     *
     * @return int
     */
    @Column(nullable = false)
    public int getQtdMinima() {
        return qtdMinima;
    }

    /**
     * Método que altera a quantidade mínima de produtos
     *
     * @param qtdMinima - quantidade mínima de produtos
     */
    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    /**
     * Método que retorna o Valor total dos produtos
     *
     * @return double
     */
    @Column(nullable = false)
    public double getValorTotal() {
        produtos.stream().forEach(p -> {
            valorTotal += p.getPrecoCusto();
        });

        return valorTotal;
    }

    /**
     * Método que altera o valor total dos produtos
     *
     * @param valorTotal - valor total dos produtos
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Método que informa se o produto está disponível no estoque
     *
     * @param produto - produto desejado
     * @param quantidade - quantidade desejada
     * @return boolean
     */
    public boolean isAvailable(Produto produto, int quantidade) {
        if (quantidade > 0 && quantidade <= produtos.size()) {
            return true;
        } else {
            return false;
        }
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
