package DAO;


import Beans.CardapioBeans;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class CardapioDAO {
    
    
    public CardapioDAO(){
        
        
    }
    
    public void cadastrarPrato(CardapioBeans cardapio){
        try {
            String SQLInsertion = "insert into cardapio(card_descricao, card_tipo, card_valor) values (?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, cardapio.getDescricao());
            st.setString(2, cardapio.getTipo());
            st.setDouble(3, cardapio.getValor());
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso", "Sucesso!", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            //JOptionPane.showMessageDialog(null, "Erro ao Conectar ao Banco de Dados", "Erro", 0, new ImageIcon("imagens/ico_sair.png"));
        }
        
    }
    
    public String proximoPrato(){
        String SQLSelection = "select * from cardapio order by card_id desc limit 1 ";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if((rs.next())){
                return (Integer.parseInt(rs.getString("card_id")) + 1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Registro", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            return "0";
        }      
    }
    
    public void buscarPrato(String pesquisa, DefaultTableModel modelo){  
        try {
            String SQLSelection = "select * from cardapio where card_descricao like '%" + pesquisa + "%' ";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                modelo.addRow(new Object[] {rs.getString("card_id"), rs.getString("card_descricao"), rs.getString("card_tipo"), rs.getDouble("card_valor")});
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Item do Cardapio", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
    }
    
    public CardapioBeans preencherCampos(int id){
        CardapioBeans cardapio;
        cardapio = new CardapioBeans();
        try {
            String SQLSelection = "select * from cardapio where card_id = ? ";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                cardapio.setId(rs.getInt("card_id"));
                cardapio.setDescricao(rs.getString("card_descricao"));
                cardapio.setTipo(rs.getString("card_tipo"));
                cardapio.setValor((rs.getDouble("card_valor")));
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Prato", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
        return cardapio;
    }
    
    public void editarPrato(CardapioBeans cardapio){
        try {
            String SQLInsertion = "update cardapio set card_descricao = ?, card_tipo = ?, card_valor = ? where fun_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, cardapio.getDescricao());
            st.setString(2, cardapio.getTipo());
            st.setDouble(3, cardapio.getValor());
            st.setInt(4, cardapio.getId());
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Editado com Sucesso", "Sucesso!", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("imagens/ico_sair.png"));
            JOptionPane.showMessageDialog(null, "Erro ao Editar ao Banco de Dados", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
    }
}
