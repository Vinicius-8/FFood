package controller;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class NotaFiscal implements Serializable {
    private int codigoPedido;
    private String dataPedido;
    private float valorTota;
    private String cpfCliente;
    private String hora;
    private List<ItemPedido> itensPedidos;

    public NotaFiscal(int codigoPedido, String dataPedido, float valorTota, String cpfCliente, String hora, List<ItemPedido> itensPedidos) {
        this.codigoPedido = codigoPedido;
        this.dataPedido = dataPedido;
        this.valorTota = valorTota;
        this.cpfCliente = cpfCliente;
        this.hora = hora;
        this.itensPedidos = itensPedidos;
    }
    
    public NotaFiscal(){
        
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public float getValorTota() {
        return valorTota;
    }

    public void setValorTota(float valorTota) {
        this.valorTota = valorTota;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }
    
    
    
    
}
