package controller;

import dao.DAOPedidoComum;
import dao.DAOPedidoDelivery;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Vinicius
 */

@Entity
public class Cliente extends Usuario implements Serializable {
    
    private String tel;  
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    private Pedido pedido;

    public Cliente() {
        endereco = new Endereco();
        pedido = new Pedido();
    }

    public Cliente(String tel, Endereco endereco, String cpf, String nome, String senha) {
        super(cpf, nome, senha);
        this.tel = tel;
        this.endereco = endereco;
    }

    public void finalizarPedido(List<ItemPedido> itens, boolean tipo,String agenda){
        float total = 0;
        for (int j = 0; j < itens.size(); j++) {
            total += itens.get(j).getPreco();
        }
        
        java.util.Date date = new java.util.Date();
        
        
        if(tipo){//true se o pedido for delivery
            PedidoDelivery pd = new PedidoDelivery(agenda, endereco, this.getCpf(), itens, new Pagamento(total, (Date) date), false);
            new DAOPedidoDelivery().SalvarPedido(pd);
        }else{
            PedidoComum pc = new PedidoComum( this.getCpf(), itens, new Pagamento(total, (Date) date) , false);
            //pc.setItensPedidos(itens);
            new DAOPedidoComum().SalvarPedido(pc);
            
        }
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    
    
    @Override
    public String toString() {
        return "Cliente{" +"nome = "+getNome()+ " , tel=" + tel + ", endereco=" + endereco + '}';
    }
    
    
    
}
