package DAO;

import Beans.PedidoBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    public void cadastrarPedido(String idCliente, String idFuncionario, String total, int tamanhoTabela, PedidoBeans pedidoB){
        Date data = new Date();
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        try {
            String SQLInsert = "insert into pedidos(ped_cliente_id, ped_fun_id, ped_ent_id, ped_data, ped_hora, ped_total, ped_status) values (?,?,?,?,?,?,?)";
            PreparedStatement st;
            st = Conexao.getConnection().prepareCall(SQLInsert);
            st.setString(1, idCliente);
            st.setString(2, idFuncionario);
            st.setString(3, "1");
            st.setString(4, formatoData.format(data));
            st.setString(5, formatoHora.format(data));
            st.setString(6, total.replace(',','.'));
            st.setString(7, "Pedido Aberto");
            
            st.execute();
            cadastrarItens(idCliente, idFuncionario, idDoPedido(), tamanhoTabela, pedidoB);
            idDoPedido();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro salvo com Sucesso", "Sucesso", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            //JOptionPane.showMessageDialog(null, "Erro ao Buscar Código do Item do Cardápio", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            }
        
        
    }
    
   public String idDoPedido(){
       String id = "0"; 
       try {
            
            String SQLSelection = "select ped_id from pedidos order by ped_id desc limit 1";
            PreparedStatement st;
            st = Conexao.getConnection().prepareCall(SQLSelection);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               id = rs.getString("ped_id");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Código do Item do Cardápio", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
       return id;
   }
    
   public void cadastrarItens(String idCliente, String idFuncionario, String idPedido, int tamanhoTabela, PedidoBeans pedidoB){
       for (int i = 0; i < tamanhoTabela; i++) {
           String SQLInsert = "insert into item(item_ent_id, item_fun_id, item_cli_id, item_ped_id, item_card_id, item_quantidade) values(?,?,?,?,?,?)";
           PreparedStatement st;
           try {
               st = Conexao.getConnection().prepareCall(SQLInsert);
               st.setString(1, "1");
               st.setString(2, idFuncionario);
               st.setString(3, idCliente);
               st.setString(4, idPedido);
               st.setInt(5, pedidoB.getIdCardapio(i));
               st.setInt(6, pedidoB.getQuantidade(i));
               
               st.execute();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
                //JOptionPane.showMessageDialog(null, "Erro ao Buscar Código do Item do Cardápio", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
           }
       }
   }
}