package DAO;

import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class PedidoDAO {
    public void pesquisaDeItens(String pesquisa, List<String> listaDeItens){
        
        try {
            String SQLPesquisa = "select * from cardapio where card_descricao like '%" + pesquisa + "%' ";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLPesquisa);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                listaDeItens.add(rs.getString("card_descricao"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Item do Cardápio", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
    }
    
    public double valorDoItem(String pesquisa){
        try {
            String SQLPesquisa = "select * from cardapio where card_descricao = ?";
            PreparedStatement st;  
            st = Conexao.getConnection().prepareStatement(SQLPesquisa);
            st.setString(1, pesquisa);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getDouble("card_valor");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Valor Do Item do Cardápio", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
        return 0;
    }
    
    public int valorDoCodigo(String pesquisa){
        try {
            String SQLPesquisa = "select * from cardapio where card_descricao = ?";
            PreparedStatement st;  
            st = Conexao.getConnection().prepareStatement(SQLPesquisa);
            st.setString(1, pesquisa);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getInt("card_id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Código do Item do Cardápio", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
        return 0;
    }
    
    
    
}
