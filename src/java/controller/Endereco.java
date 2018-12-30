package controller;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Vinicius
 */
@Entity
public class Endereco implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idEndereco;
    private String cep;
    private String bairro;
    private String rua;
    private String numero;
    
    private String complemento;

    public Endereco() {
    }

    public Endereco(int idEndereco, String cep, String bairro, String rua, String numero, String complemento) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    @Override
    public String toString() {
        return "CEP: "+ cep + " | Rua: "+rua+" | Nº: "+ numero;
    }
    
    
    
}
