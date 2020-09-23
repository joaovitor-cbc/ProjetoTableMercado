
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joao_vitor
 */
public class ProdutoTableModel extends AbstractTableModel {
    //linhas que serao adicionadas
    private List<Produto> dados = new ArrayList<>();
    //colunas
    private String [] colunas = {"Descrição","Quantidade", "Valor"};
    //para adicionar nome aos campos da coluna
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    //retornando os dados da linhas que tem dentro da lista
    @Override
    public int getRowCount() {
        return dados.size();
    }
    //retornando o tamanho das colunas
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    // metodo que pega a linha e a coluna e retorna dados
    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return dados.get(linha).getDescricao();
            case 1:
                return dados.get(linha).getQtd();
            case 2:
                return dados.get(linha).getValor();
        }
        return null;
    }
    /*metodo para alterar dados da tabela 
    *atraves do metodo que tem no abstractTableModel
    *usando o metodo para atualizar a tabela depois
    *da alteração fireTableRowsUpdated() passando as linhas
    *que foram alterada a primeira(first) e a ultima(last)
    */
    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
                switch(coluna){
            case 0:
                dados.get(linha).setDescricao((String) valor);
                break;
            case 1:
                dados.get(linha).setQtd(Integer.parseInt((String) valor));
                break;
            case 2:
                dados.get(linha).setValor(Double.parseDouble((String) valor));
                break;
        }
                this.fireTableRowsUpdated(linha, linha);
    }
    
    /*metodo para adicionar dados nas linhas da tabela
    * usando o metodo que tem dentro do abstractTableModel
    * fireTableDataChanged() que atualiza a tabela
    *quando a alteração nela.
    */
    public void addRow(Produto p){
        this.dados.add(p);
        this.fireTableDataChanged();
    }
    /*metodo para apagar linhas da tabela
    *chamando a lista dados usando o metodo remove e passando
    *a linha que sera apagada e depois chamando o metodo do
    *abstractTableModel o fireTableRowsDeleted que atualiza a tabela
    *apos apagar uma linha de dados dela.
    */
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
}
