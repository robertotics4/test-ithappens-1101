/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Roberto Oliveira
 */
@Embeddable
public class Endereco {
    
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco() {}
    
    public Endereco(String endereco, String bairro, String cidade, String cep) {
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    @Column(length = 300, nullable = true)
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.toUpperCase();
    }

    @Column(length = 200, nullable = true)
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro.toUpperCase();
    }

    @Column(length = 200, nullable = true)
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade.toUpperCase();
    }

    @Column(length = 2, nullable = true)
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf.toUpperCase();
    }

    @Column(length = 9, nullable = true)
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
