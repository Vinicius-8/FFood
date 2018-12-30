package controller;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author Vinicius
 */
@Entity
public class PedidoComum extends Pedido implements Serializable{

    public PedidoComum(String cpfCliente, List<ItemPedido> itensPedidos, Pagamento pagamento, boolean status) {
        super(cpfCliente, itensPedidos, pagamento, status);
    }

    public PedidoComum() {
    }
    
}
