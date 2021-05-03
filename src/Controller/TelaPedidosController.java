
package Controller;

import Beans.PedidoBeans;
import DAO.TelaPedidosDAO;
import javax.swing.table.DefaultTableModel;


public class TelaPedidosController {
    
    TelaPedidosDAO telaPedidosD;
    
    public TelaPedidosController(){
        telaPedidosD = new TelaPedidosDAO();
    }
    
     public void controlePesquisa(DefaultTableModel Modelo){
        telaPedidosD.mostrarPedidos(Modelo);
    }
     
     public void controleFechar(int idAlterado){
         telaPedidosD.fecharPedido(idAlterado);
     }
}
