package DAO;


import Beans.FuncionarioBeans;
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

public class FuncionarioDAO {
    
    
    public FuncionarioDAO(){
        
        
    }
    
    public void cadastrarFuncionario(FuncionarioBeans funcionario){
        try {
            String SQLInsertion = "insert into funcionarios(fun_nome, fun_cargo, fun_data_cadastro) values (?,?,?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, funcionario.getNome());
            st.setString(2, funcionario.getCargo());
            st.setString(3, Corretores.converterDataSQL(funcionario.getDataCad()));
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Salvo com Sucesso", "Sucesso!", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            //JOptionPane.showMessageDialog(null, "Erro ao Conectar ao Banco de Dados", "Erro", 0, new ImageIcon("imagens/ico_sair.png"));
        }
        
    }
    
    public String proximoFuncionario(){
        String SQLSelection = "select * from funcionarios order by fun_id desc limit 1 ";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if((rs.next())){
                return (Integer.parseInt(rs.getString("fun_id")) + 1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Registro", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            return "0";
        }      
    }
    
    public void buscarFuncionario(String pesquisa, DefaultTableModel modelo){  
        try {
            String SQLSelection = "select * from funcionarios where fun_nome like '%" + pesquisa + "%' ";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                modelo.addRow(new Object[] {rs.getString("fun_id"), rs.getString("fun_nome"), rs.getString("fun_cargo"), Corretores.converterDataBr(rs.getString("fun_data_cadastro"))});
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
    }
    
    public FuncionarioBeans preencherCampos(int id){
        FuncionarioBeans funcionario;
        funcionario = new FuncionarioBeans();
        try {
            String SQLSelection = "select * from funcionarios where fun_id = ? ";
            PreparedStatement st;
            st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                funcionario.setId(rs.getInt("fun_id"));
                funcionario.setNome(rs.getString("fun_nome"));
                funcionario.setCargo(rs.getString("fun_cargo"));
                funcionario.setDataCad(Corretores.converterDataBr((rs.getString("fun_data_cadastro"))));
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Funcionario", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
        return funcionario;
    }
    
    public void editarFuncionario(FuncionarioBeans funcionario){
        try {
            String SQLInsertion = "update funcionarios set fun_nome = ?, fun_cargo = ? where fun_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, funcionario.getNome());
            st.setString(2, funcionario.getCargo());
            st.setInt(3, funcionario.getId());
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro Editado com Sucesso", "Sucesso!", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "Erro", 0, new ImageIcon("imagens/ico_sair.png"));
            JOptionPane.showMessageDialog(null, "Erro ao Editar ao Banco de Dados", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
    }
}
