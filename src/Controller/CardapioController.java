
package Controller;

import Beans.CardapioBeans;
import DAO.CardapioDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CardapioController {
    
    CardapioDAO cardapioD;
    
    public CardapioController(){
        cardapioD = new CardapioDAO();
    }
    
    public boolean verificarDados(CardapioBeans cardapio){
        if(cardapio.getDescricao().equals("")){
            JOptionPane.showMessageDialog(null, "Peencha o campo Nome", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            return false;
        }
        if(cardapio.getTipo().equals("Selecione um tipo")){
            JOptionPane.showMessageDialog(null, "Selecione um tipo", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            return false;
        }
        if(cardapio.getValor().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha o valor", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            return false;
        }
        cardapioD.cadastrarPrato(cardapio);
        return true;
    }
    
    public String controleDeCodigo(){
        return cardapioD.proximoPrato();
    }
    
    public void controlePesquisa(String pesquisa, DefaultTableModel modelo){
        cardapioD.buscarPrato(pesquisa, modelo);
    }
    
    public CardapioBeans controlePreencherCampos(int codigo){
        return cardapioD.preencherCampos(codigo);
    }
    
    public boolean verificarDadosEditar(CardapioBeans cardapio){
        if(cardapio.getDescricao().equals("")){
            JOptionPane.showMessageDialog(null, "Peencha o campo Nome", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            return false;
        }
        if(cardapio.getTipo().equals("Selecione um tipo")){
            JOptionPane.showMessageDialog(null, "Selecione um tipo", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            return false;
        }
        if(cardapio.getValor().equals("")){
            JOptionPane.showMessageDialog(null, "Preencha o valor", "Erro", 0, new ImageIcon(getClass().getResource("/Icones/ico_sair.png")));
            return false;
        }
        cardapioD.editarPrato(cardapio);
        return true;
    }
}
