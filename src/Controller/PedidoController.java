
package Controller;

import Beans.PedidoBeans;
import DAO.PedidoDAO;
import GUI.PedidoTela;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class PedidoController {
    PedidoDAO pedidoD;
    
    public PedidoController(){
        pedidoD = new PedidoDAO();
    }
    
    public void controleDeItens(String pesquisa, List<String> listaDeItens){
        pedidoD.pesquisaDeItens(pesquisa, listaDeItens);
    }
    
    public double controleDeValor(String pesquisa){
        return pedidoD.valorDoItem(pesquisa);
    }
    
    public int controleDeCodigo(String pesquisa){
        return pedidoD.valorDoCodigo(pesquisa);
    }
    
    public boolean verificaItens(String valor, String quantidade, String id, String item){
        if(quantidade.equals("")){
            JOptionPane.showMessageDialog(null, "Preencha o campo quantidade", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
                return false;         
        }
        
        try{
                int x = Integer.parseInt(quantidade);
                if(x == 0){
                    JOptionPane.showMessageDialog(null, "Insira um valor diferente de 0", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
                    PedidoTela.txtQuantidade.setText("1");
                    PedidoTela.txtQuantidade.grabFocus();
                    return false;
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Valor inválido, insira um valor inteiro", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
                PedidoTela.txtQuantidade.setText("1");
                PedidoTela.txtQuantidade.grabFocus();

                return false;
            }
        
        if(valor.equals("")){
            JOptionPane.showMessageDialog(null, "Peencha o campo Valor", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            return false;
        }
        if(id.equals("")){
            JOptionPane.showMessageDialog(null, "Peencha o campo Id", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            return false;
        }
        if(item.equals("")){
            JOptionPane.showMessageDialog(null, "Peencha o campo Item", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            return false;
        }
        return true;
    }
    
    public void controleDePedido(String idCliente, String idFuncionario, String total, int tamanhoTabela, PedidoBeans pedidoB){
        pedidoD.cadastrarPedido(idCliente, idFuncionario, total, tamanhoTabela, pedidoB);
    }
}
