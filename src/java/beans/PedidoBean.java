package beans;

import controller.Pedido;
import controller.PedidoComum;
import controller.PedidoDelivery;
import dao.DAOPedidoComum;
import dao.DAOPedidoDelivery;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Vinicius
 */
@SessionScoped
@ManagedBean
public class PedidoBean implements Serializable{
    List<PedidoDelivery> allPedidosDelivery;
    List<PedidoComum> allPedidosComuns;
    DAOPedidoComum daoComum;
    DAOPedidoDelivery daoDelivery;
    
    public PedidoBean(){
        daoComum = new DAOPedidoComum();
        daoDelivery = new DAOPedidoDelivery();
        
        allPedidosDelivery = daoDelivery.allPedidosDelivery();
        allPedidosComuns = daoComum.allPedidosComuns();
        
    }

    public void encerrarPedidoDelivery(PedidoDelivery pedido){
        pedido.setStatus(true);
        daoDelivery.AtualizarPedidoDelivery(pedido);
    }
    public void encerrarPedidoComum(PedidoComum pedido){
        pedido.setStatus(true);
        daoComum.AtualizarPedidoComum(pedido);
    }
    
    public List<PedidoDelivery> getAllPedidosDelivery() {
        return allPedidosDelivery;
    }

    public List<PedidoComum> getAllPedidosComuns() {
        return allPedidosComuns;
    }
    
    
    
}
