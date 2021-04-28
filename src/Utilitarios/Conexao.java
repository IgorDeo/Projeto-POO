package Utilitarios;

import java.sql.Connection;
import com.mysql.jdbc.Driver;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


//Conexao com banco de dados local
public class Conexao {
    private final String url = "jdbc:mysql://localhost:3306/restaurante";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String usuario = "root";
    private final String senha = "";
    private static Connection con;
    
    public Conexao(){
        try {
            con = DriverManager.getConnection(url, usuario, senha);
            con.setAutoCommit(false);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso", "Conectado", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Conectar ao Banco de Dados", "Erro", 0);
        }
    }
    
    public static Connection getConnection(){
        if (con == null){
            new Conexao();
        }
        return con;
    }
    
    public static void fecharConexao(){
        try {
            if(!con.isClosed()){
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args){
        Conexao.getConnection();
    }
    
}


