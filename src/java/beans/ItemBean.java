package beans;

import controller.Categoria;
import controller.ItemPedido;
import dao.DAOCategoria;
import dao.DAOItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Vinicius
 */
@ManagedBean
@SessionScoped
public class ItemBean implements Serializable{
    private ItemPedido item;
    private DAOItem daoItem;
    private DAOCategoria daoCategoria;
    private List<Categoria> allCategorias;
    
    private List<ItemPedido> ic;
    
    private List<ItemPedido> hamburgers;
    private List<ItemPedido> pizza;
    private List<ItemPedido> bebida;
    private List<ItemPedido> salada;
    private List<ItemPedido> sobremesa;
    private List<ItemPedido> acompanhamento;
    
    
    
    
    public ItemBean(){
        item = new ItemPedido();
        daoItem = new DAOItem();
        daoCategoria = new DAOCategoria();
        ic = new ArrayList<>(new DAOItem().allItensPedidos());
        spliterator();
    }
    
    public void spliterator(){
        hamburgers =  new ArrayList<>();
        pizza =  new ArrayList<>();
        bebida =  new ArrayList<>();
        salada =  new ArrayList<>();
        sobremesa =  new ArrayList<>();
        acompanhamento = new ArrayList<>();
        
        for (int i = 0; i < ic.size(); i++) {
            int id = ic.get(i).getCategoria().getCodigoCategoria(); 
            
            switch (id) {
                case 1:
                    hamburgers.add(ic.get(i));
                    break;
                case 2:
                    pizza.add(ic.get(i));
                    break;
                case 3:
                    bebida.add(ic.get(i));
                    break;
                case 4:
                    salada.add(ic.get(i));
                    break;
                case 5:
                    sobremesa.add(ic.get(i));
                    break;
                case 6:
                    acompanhamento.add(ic.get(i));
                    break;
                default:
                    break;
            }      
        }
    }

    public void cadastrar(){
        daoItem.salvarItem(item);
        item = new ItemPedido();
    }

    public ItemPedido getItem() {
        return item;
    }

    public List<Categoria> getAllCategorias() {
        allCategorias = daoCategoria.allCategorias();
        return allCategorias;
    }

    public List<ItemPedido> getIc() {
        return ic;
    }

    public List<ItemPedido> getHamburgers() {
        return hamburgers;
    }

    public List<ItemPedido> getPizza() {
        return pizza;
    }

    public List<ItemPedido> getBebida() {
        return bebida;
    }

    public List<ItemPedido> getSalada() {
        return salada;
    }

    public List<ItemPedido> getSobremesa() {
        return sobremesa;
    }

    public List<ItemPedido> getAcompanhamento() {
        return acompanhamento;
    }
    
    
    
}
