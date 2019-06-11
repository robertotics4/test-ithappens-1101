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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 * Classe que representa uma entidade de Pedido no Banco de Dados Será criada
 * automaticamente uma tabela PedidoEstoque
 *
 * @author Roberto Oliveira
 */
@Entity
public class PedidoEstoque implements Serializable {

    /**
     * Enum que representa o tipo do pedido
     */
    public enum TipoPedido {
        ENTRADA, SAIDA
    }

    private static final long serialVersionUID = 1L;

    private Long id;
    private TipoPedido tipoPedido;
    private Filial filial;
    private Usuario usuario;
    private Cliente cliente;
    private String observacao;
    private List<ItensPedido> itensPedido;
    private FormaPagamento formaPagamento;
    private double valorTotal;
    private Estoque estoque;

    /**
     * Construtor padrão da classe ProdutoEstoque
     *
     * @param estoque - estoque relacionado ao pedido
     */
    public PedidoEstoque(Estoque estoque) {
        itensPedido = new ArrayList<>();
        valorTotal = 0;
        this.estoque = estoque;
    }

    /**
     * Construtor que recebe todos os parâmetros da classe PedidoEstoque
     *
     * @param tipoPedido - tipo do pedido
     * @param filial - filial do pedido
     * @param usuario - usuario do pedido
     * @param cliente - cliente do pedido
     * @param observacao - observação do pedido
     * @param itensPedido - item do pedido
     * @param formaPagamento - forma de pagamento do pedido
     * @param estoque - estoque relacionado ao pedido
     */
    public PedidoEstoque(TipoPedido tipoPedido, Filial filial, Usuario usuario, Cliente cliente, String observacao, List<ItensPedido> itensPedido, FormaPagamento formaPagamento, Estoque estoque) {
        this.tipoPedido = tipoPedido;
        this.filial = filial;
        this.usuario = usuario;
        this.cliente = cliente;
        this.observacao = observacao;
        this.itensPedido = itensPedido;
        this.formaPagamento = formaPagamento;
    }

    /**
     * Método que retorna o id do pedido
     *
     * @return Long
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    /**
     * Método que altera o id do pedido
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que retorna o tipo do pedido
     *
     * @return TipoPedido
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    /**
     * Método que altera o tipo do pedido
     *
     * @param tipoPedido - tipo do pedido
     */
    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    /**
     * Método que retorna a filial
     *
     * @return Filial
     */
    @OneToOne
    public Filial getFilial() {
        return filial;
    }

    /**
     * Método que altera a filial
     *
     * @param filial - filial
     */
    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    /**
     * Método que retorna o usuário
     *
     * @return Usuario
     */
    @OneToOne
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Método que altera o usuário
     *
     * @param usuario - usuário
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que retorna o cliente
     *
     * @return Cliente
     */
    @OneToOne
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Método que altera o cliente
     *
     * @param cliente - cliente
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Método que retorna a observação
     *
     * @return String
     */
    @Column(length = 300, nullable = false)
    public String getObservacao() {
        return observacao;
    }

    /**
     * Método que altera a observação
     *
     * @param observacao - observação
     */
    public void setObservacao(String observacao) {
        this.observacao = observacao.toUpperCase();
    }

    /**
     * Método que retorna os itens do pedido
     *
     * @return List
     */
    @OneToMany
    @Column(nullable = true)
    public List<ItensPedido> getItensPedido() {
        return itensPedido;
    }

    /**
     * Método que altera os itens do pedido
     *
     * @param itensPedido - itens do pedido
     */
    public void setItensPedido(List<ItensPedido> itensPedido) {
        this.itensPedido = itensPedido;
    }

    /**
     * Método que retorna a forma de pagamento
     *
     * @return FormaPagamento
     */
    @ManyToOne
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * Mètodo que altera a forma de pagamento
     *
     * @param formaPagamento
     */
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * Método que retorna o valor total
     *
     * @return double
     */
    @Transient
    public double getValorTotal() {
        valorTotal = 0;

        itensPedido.stream().forEach(i -> {
            valorTotal += i.getValorUnitario();
        });

        return valorTotal;
    }

    /**
     * Método que altera o valor total
     *
     * @param valorTotal - valor total do pedido
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Método que retorna o estoque relacionado ao pedido
     *
     * @return Estoque
     */
    @Transient
    public Estoque getEstoque() {
        return estoque;
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
        if (!(object instanceof PedidoEstoque)) {
            return false;
        }
        PedidoEstoque other = (PedidoEstoque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PedidoEstoque[ id=" + id + " ]";
    }

}
