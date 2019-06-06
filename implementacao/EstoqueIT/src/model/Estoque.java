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
 *
 * @author Roberto Oliveira
 */
@Entity
public class Estoque implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private List<ProdutoEstoque> produtos;
    private int qtdMinima;
    private double valorTotal;

    public Estoque() {
        // CONSTRUTOR PADRÃO COM AS CONFIGURAÇÕES INICIAIS
        produtos = new ArrayList<>();
        qtdMinima = 0;
        valorTotal = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany
    @Column(nullable = true)
    public List<ProdutoEstoque> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoEstoque> produtos) {
        this.produtos = produtos;
    }

    @Column(nullable = false)
    public int getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    @Column(nullable = false)
    public double getValorTotal() {
        produtos.stream().forEach(p -> {
            valorTotal += p.getProduto().getPrecoCusto();
        });

        return valorTotal;
    }

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
