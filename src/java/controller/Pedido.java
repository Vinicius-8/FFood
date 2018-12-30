package controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Vinicius
 */



@MappedSuperclass
public class Pedido implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigoPedido;
    private String cpfCliente;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedidos;
    @OneToOne(cascade = CascadeType.ALL)
    private Pagamento pagamento;
    private boolean status = false;

    /**
     *
     * @param codigoPedido
     * @param cpfCliente
     * @param itensPedidos
     * @param pagamento
     * @param status
     */
    public Pedido(int codigoPedido, String cpfCliente, List<ItemPedido> itensPedidos, Pagamento pagamento, boolean status) {
        this.codigoPedido = codigoPedido;
        this.cpfCliente = cpfCliente;
        this.itensPedidos = itensPedidos;
        this.pagamento = pagamento;
        this.status = status;
    }

    public Pedido(String cpfCliente, List<ItemPedido> itensPedidos, Pagamento pagamento, boolean status) {
        this.cpfCliente = cpfCliente;
        this.itensPedidos = itensPedidos;
        this.pagamento = pagamento;
        this.status = status;
    }
    
    

    public Pedido() {
    }
    
    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<ItemPedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
