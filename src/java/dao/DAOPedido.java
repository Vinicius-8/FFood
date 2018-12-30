package dao;

import controller.Pedido;
import controller.PedidoComum;
import controller.PedidoDelivery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class DAOPedido implements Serializable {
    
    DAOPedidoDelivery dD;
    DAOPedidoComum dc;
    
    
    public DAOPedido(){
        dD = new DAOPedidoDelivery();
        dc =  new DAOPedidoComum();
    }
    
    public List<Pedido> allPedidos(String cpf){
        List<Pedido> pedidos = new ArrayList<>();
        List<PedidoDelivery> pedidosDelivery = dD.allPedidosDelivery(cpf);
        List<PedidoComum> pedidosComum = dc.allPedidosComuns(cpf);
        pedidos.addAll(pedidosDelivery);
        pedidos.addAll(pedidosComum);
        return pedidos;
    }
    
}
