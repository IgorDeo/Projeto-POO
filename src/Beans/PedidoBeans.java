
package Beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igord
 */
public class PedidoBeans {
    
    private int idPedido;
    private int idCliente;
    private int idFuncionario;
    private int idEntregador;
    private String data;
    private String hora;
    private double valor;
    private String status;
    private List<Integer> idCardapio;
    private List<Integer> quantidade;
    
    public PedidoBeans(){
        idCardapio = new ArrayList<>();
        quantidade = new ArrayList<>();
    }

    public List<Integer> getIdCardapio() {
        return idCardapio;
    }

    public void setIdCardapio(List<Integer> idCardapio) {
        this.idCardapio = idCardapio;
    }

    public List<Integer> getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(List<Integer> quantidade) {
        this.quantidade = quantidade;
    }
       
    
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public int getIdEntregador() {
        return idEntregador;
    }

    public void setIdEntregador(int idEntregador) {
        this.idEntregador = idEntregador;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
