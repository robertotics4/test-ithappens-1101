/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Classe que representa um elemento embutido de Endereço. Não é uma entidade no banco de dados
 * @author Roberto Oliveira
 */
@Embeddable
public class Endereco {
    
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    /**
     * Construtor padrão da classe Endereço
     */
    public Endereco() {}
    
    /**
     * Construtor que recebe todos parâmetros da classe Endereço
     * @param endereco - endereço do local
     * @param bairro - bairro
     * @param cidade - cidade
     * @param cep - CEP do local
     */
    public Endereco(String endereco, String bairro, String cidade, String cep) {
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    /**
     * Método que retorna o endereço
     * @return String
     */
    @Column(length = 300, nullable = true)
    public String getEndereco() {
        return endereco;
    }

    /**
     * Método que altera o endereço
     * @param endereco - endereço
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco.toUpperCase();
    }

    /**
     * Método que retorna o bairro
     * @return String
     */
    @Column(length = 200, nullable = true)
    public String getBairro() {
        return bairro;
    }

    /**
     * Método que altera o bairro
     * @param bairro - bairro do endereço
     */
    public void setBairro(String bairro) {
        this.bairro = bairro.toUpperCase();
    }

    /**
     * Método que retorna a cidade
     * @return String
     */
    @Column(length = 200, nullable = true)
    public String getCidade() {
        return cidade;
    }

    /**
     * Método que altera a cidade
     * @param cidade - cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade.toUpperCase();
    }

    /**
     * Método que retorna a UF (Estado)
     * @return String
     */
    @Column(length = 2, nullable = true)
    public String getUf() {
        return uf;
    }

    /**
     * Método que altera a UF(Estado)
     * @param uf - estado (UF)
     */
    public void setUf(String uf) {
        this.uf = uf.toUpperCase();
    }

    /**
     * Método que retorna o CEP
     * @return String
     */
    @Column(length = 9, nullable = true)
    public String getCep() {
        return cep;
    }

    /**
     * Método que altera o CEP
     * @param cep - CEP do local
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

}
