/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * Classe que representa a entidade de Itens do Pedido no Banco de Dados Será
 * criada automaticamente uma tabela ItensPedido
 *
 * @author Roberto Oliveira
 */
@Entity
public class ItensPedido implements Serializable {

    /**
     * Enum que representa o status do item
     */
    public enum StatusItem {
        ATIVO, CANCELADO, PROCESSADO
    }

    private static final long serialVersionUID = 1L;
    private Long id;
    private Produto produto;
    private StatusItem statusItem;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;

    /**
     * Construtor padrão da classe ItensPedido
     */
    public ItensPedido() {
        statusItem = StatusItem.ATIVO;
        quantidade = 0;
    }

    /**
     * Método que retorna o id do item do pedido
     *
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Método que altera o id do item do pedido
     *
     * @param id - id do item do pedido
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que retorna o produto do item do pedido
     *
     * @return Produto
     */
    @ManyToOne
    public Produto getProduto() {
        return produto;
    }

    /**
     * Método que altera o produto do item do pedido
     *
     * @param produto - produto do item do pedido
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Método que retorna o estado do item do pedido
     *
     * @return StatusItem
     */
    @Enumerated
    @Column(nullable = false)
    public StatusItem getStatusItem() {
        return statusItem;
    }

    /**
     * Método que altera o estado do item do pedido
     *
     * @param statusItem - estado do item do pedido
     */
    public void setStatusItem(StatusItem statusItem) {
        this.statusItem = statusItem;
    }

    /**
     * Método que retorna a quantidade de itens do pedido
     *
     * @return int
     */
    @Column(nullable = false)
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * Método que altera a quantidade de itens do pedido
     *
     * @param quantidade - quantidade de itens do pedido
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Método que retorna o valor unitário do item do pedido
     *
     * @return double
     */
    @Column(nullable = false)
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * Método que altera o valor unitário do item do pedido
     *
     * @param valorUnitario - valor unitário do item do pedido
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * Método que retorna o valor total do pedido
     *
     * @return double
     */
    @Transient
    public double getValorTotal() {
        return quantidade * valorUnitario;
    }

    /**
     * Método que altera o valor total do pedido
     *
     * @param valorTotal - valor total do pedido
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    // CÓDIGO GERADO AUTOMATICAMENTE PELA PERSISTêNCIA DO JAVA
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItensPedido)) {
            return false;
        }
        ItensPedido other = (ItensPedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ItensPedido[ id=" + id + " ]";
    }

}
