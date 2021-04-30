package DAO;


import Beans.EntregadorBeans;
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

public class EntregadorDAO {
    
    
    public EntregadorDAO(){
        
        
    }
    
    public void cadastrarEntregador(EntregadorBeans entregador){
        try {
            String SQLInsertion = "insert into entregadores(entre_nome, entre_status, entre_data_cadastro) values (?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, entregador.getNome());
            st.setString(2, "Livre");
            st.setString(3, Corretores.converterDataSQL(entregador.getDataCad()));
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso", "Sucesso!", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));          
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Entregador", "Erro", 0, new ImageIcon("imagens/ico_sair.png"));
        }
        
    }
    
    public String proximoEntregador(){
        String SQLSelection = "select * from entregadores order by entre_id desc limit 1 ";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if((rs.next())){
                return (Integer.parseInt(rs.getString("entre_id")) + 1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Registro", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            return "0";
        }      
    }
    
    public void buscarEntregador(String pesquisa, DefaultTableModel modelo){  
        try {
            String SQLSelection = "select * from entregadores where entre_nome like '%" + pesquisa + "%' ";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                modelo.addRow(new Object[] {rs.getString("entre_id"), rs.getString("entre_nome"), Corretores.converterDataBr(rs.getString("entre_data_cadastro"))});
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Entregador", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
    }
    
    public EntregadorBeans preencherCampos(int id){
        EntregadorBeans entregador;
        entregador = new EntregadorBeans();
        try {
            String SQLSelection = "select * from entregadores where entre_id = ? ";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                entregador.setId(rs.getInt("entre_id"));
                entregador.setNome(rs.getString("entre_nome"));
                entregador.setDataCad(Corretores.converterDataBr((rs.getString("entre_data_cadastro"))));
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Entregador", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            
        }
        return entregador;
    }
    
    public void editarEntregador(EntregadorBeans entregador){
        try {
            String SQLInsertion = "update entregadores set entre_nome = ? where entre_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, entregador.getNome());
            st.setInt(2, entregador.getId());
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Editado com Sucesso", "Sucesso!", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Registro", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
    }
}
