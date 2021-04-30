
package Controller;

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
}
