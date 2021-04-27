/*
 * Projeto final de Programa��o Orientada a Objetos
 * Each line should be prefixed with  * 
 */
package DAO;

import Beans.ClienteBeans;
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

/**
 *
 * @author igord
 */
public class ClienteDAO {
    
    
    public ClienteDAO(){
        
        
    }
    
    public void cadastrarCliente(ClienteBeans cliente){
        try {
            String SQLInsertion = "insert into clientes (cliente_nome, cliente_rua, cliente_bairro, cliente_telefone, cliente_data_cadastro) values (?,?,?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRua());
            st.setString(3, cliente.getBairro());
            st.setString(4, cliente.getTelefone());
            st.setString(5, Corretores.converterDataSQL(cliente.getDataCad()));
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso", "Sucesso!", 1, new ImageIcon("imagens/ok.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("imagens/ico_sair.png"));
            //JOptionPane.showMessageDialog(null, "Erro ao Conectar ao Banco de Dados", "Erro", 0, new ImageIcon("imagens/ico_sair.png"));
        }
        
    }
    
    public String proximoCliente(){
        String SQLSelection = "select * from clientes order by cliente_id desc limit 1 ";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if((rs.next())){
                return (Integer.parseInt(rs.getString("cliente_id")) + 1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Registro", "Erro", 0, new ImageIcon("imagens/ico_sair.png"));
            return "0";
        }      
    }
    
    public void buscarCliente(String pesquisa, DefaultTableModel modelo){  
        try {
            String SQLSelection = "select * from clientes where cliente_nome like '%" + pesquisa + "%' ";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                modelo.addRow(new Object[] {rs.getString("cliente_id"), rs.getString("cliente_nome"), rs.getString("cliente_rua"), rs.getString("cliente_bairro"), rs.getString("cliente_telefone")});
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "Erro", 0, new ImageIcon("imagens/ico_sair.png"));
        }
    }
    public ClienteBeans preencherCampos(int id){
        ClienteBeans cliente;
        cliente = new ClienteBeans();
        try {
            String SQLSelection = "select * from clientes where cliente_id = ? ";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                cliente.setId(rs.getInt("cliente_id"));
                cliente.setNome(rs.getString("cliente_nome"));
                cliente.setRua(rs.getString("cliente_rua"));
                cliente.setBairro(rs.getString("cliente_bairro"));
                cliente.setTelefone(rs.getString("cliente_telefone"));
                cliente.setDataCad(Corretores.converterDataBr((rs.getString("cliente_data_cadastro"))));
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "Erro", 0, new ImageIcon("imagens/ico_sair.png"));
        }
        return cliente;
    }
    
    public void editarCliente(ClienteBeans cliente){
        try {
            String SQLInsertion = "update clientes set cliente_nome = ?, cliente_rua = ?, cliente_bairro = ?, cliente_telefone = ? where cliente_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getRua());
            st.setString(3, cliente.getBairro());
            st.setString(4, cliente.getTelefone());
            st.setInt(5, cliente.getId());
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Editado com Sucesso", "Sucesso!", 1, new ImageIcon("imagens/ok.png"));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("imagens/ico_sair.png"));
            JOptionPane.showMessageDialog(null, "Erro ao Editar ao Banco de Dados", "Erro", 0, new ImageIcon("imagens/ico_sair.png"));
        }
    }
}
