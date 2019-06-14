/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

import br.com.dao.ItensPedidoDAO;
import br.com.model.ItensPedido;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que cria um modelo para a tabela dos itens do pedido
 *
 * @author Roberto Oliveira
 */
public class ItensPedidoTableModel extends AbstractTableModel {

    private List<ItensPedido> itens = new ArrayList<>();
    private String[] colunas = {"Descrição", "Quantidade", "Valor Unitário", "Valor Total"};

    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int coluna) {

        return colunas[coluna];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return itens.get(linha).getProduto().getDescricao();
            case 1:
                return itens.get(linha).getQuantidade();
            case 2:
                return "R$ " + String.valueOf(itens.get(linha).getValorUnitario());
            case 3:
                return "RS " + String.valueOf(itens.get(linha).getQuantidade() * itens.get(linha).getValorUnitario());
        }

        return null;
    }

    public void addRow(ItensPedido itensPedido) {
        this.itens.add(itensPedido);
        this.fireTableDataChanged();
    }

    public void removeRow(ItensPedido itensPedido) {
        this.itens.remove(itensPedido);
        this.fireTableDataChanged();
    }

    public List<ItensPedido> getData() {
        return this.itens;
    }
}
