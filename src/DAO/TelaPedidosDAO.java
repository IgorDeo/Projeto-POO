
package DAO;

import Beans.PedidoBeans;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TelaPedidosDAO {
    
    public TelaPedidosDAO(){
    
}
    
    public void mostrarPedidos(DefaultTableModel modelo){
        try {
            String SQLPesquisa = "select * from pedidos where ped_status = 'Pedido Aberto' ";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLPesquisa);
            
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                modelo.addRow(new Object[] {rs.getString("ped_id"), Corretores.converterDataBr(rs.getString("ped_data")), rs.getString("ped_hora"), rs.getString("ped_status") } );
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
    }
    
    public void fecharPedido(int id){
        try {
            String SQLInsertion = "update pedidos set ped_status = 'Pedido Fechado' where ped_id = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setInt(1, id);
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Pedido Fechado com Sucesso", "Sucesso!", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Fechar Pedido", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
        }
    }
    
    
    
    
    
}
