/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;

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
    private String[] colunas = {"Sequencial", "Descrição", "Qtd", "Valor Unitário", "Valor Total"};

    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch (coluna) {
            case 0:
                return itens.get(linha).getId();
            case 1:
                return itens.get(linha).getProduto().getDescricao();
            case 2:
                return itens.get(linha).getProduto().getCodigoBarras();
            case 3:
                return itens.get(linha).getQuantidade();
            case 4:
                return itens.get(linha).getValorUnitario();
            case 5:
                return itens.get(linha).getQuantidade() * itens.get(linha).getValorUnitario();

        }

        return null;
    }

}
