package controller;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



/**
 *
 * @author Vinicius
 */
@Entity
public class PedidoDelivery extends Pedido implements Serializable{
    private String agendamento;
     
    @OneToOne
    @JoinColumn(name="fk_idEndereco", referencedColumnName="idEndereco")
    private Endereco endereco;
    
    public PedidoDelivery() {
    }

    public PedidoDelivery(String agendamento, Endereco endereco, int codigoPedido, String cpfCliente, List<ItemPedido> itensPedidos, Pagamento pagamento, boolean status) {
        super(codigoPedido, cpfCliente, itensPedidos, pagamento, status);
        this.agendamento = agendamento;
        this.endereco = endereco;
    }

    public PedidoDelivery(String agendamento, Endereco endereco, String cpfCliente, List<ItemPedido> itensPedidos, Pagamento pagamento, boolean status) {
        super(cpfCliente, itensPedidos, pagamento, status);
        this.agendamento = agendamento;
        this.endereco = endereco;
    }
    

    public String getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(String agendamento) {
        this.agendamento = agendamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
}
