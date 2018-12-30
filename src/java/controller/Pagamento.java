package controller;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Vinicius
 */
@Entity
public class Pagamento implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idPagamento;
    private float valor;
    private Date dataPagamento;

    public Pagamento() {
    }

    public Pagamento(int idPagamento, float valor, Date dataPagamento) {
        this.idPagamento = idPagamento;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
    }

    public Pagamento(float valor, Date dataPagamento) {
        this.valor = valor;
        this.dataPagamento = dataPagamento;
    }

 
    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }
    
    
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    
    
}
