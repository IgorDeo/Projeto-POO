/*
 * Projeto final de Programa��o Orientada a Objetos
 * Each line should be prefixed with  * 
 */
package Beans;


public class ClienteBeans {
    private int id;
    private String nome;
    private String rua;
    private String bairro;
    private String telefone;
    private String dataCad;
    
    
    public ClienteBeans(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int codigo) {
        this.id = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataCad() {
        return dataCad;
    }

    public void setDataCad(String dataCad) {
        this.dataCad = dataCad;
    }
    
    
}
