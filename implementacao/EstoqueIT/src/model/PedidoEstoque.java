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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Roberto Oliveira
 */
@Entity
public class PedidoEstoque implements Serializable {

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

    public PedidoEstoque() {
        itensPedido = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    public TipoPedido getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(TipoPedido tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    @OneToOne
    @Column(nullable = false)
    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    @OneToOne
    @Column(nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @OneToOne
    @Column(nullable = false)
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Column(length = 300, nullable = false)
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao.toUpperCase();
    }

    @OneToMany
    @Column(nullable = true)
    public List<ItensPedido> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItensPedido> itensPedido) {
        this.itensPedido = itensPedido;
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
