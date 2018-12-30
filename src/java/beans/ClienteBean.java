package beans;

import controller.Cliente;
import controller.ItemPedido;
import controller.NotaFiscal;
import controller.Pedido;
import controller.Usuario;
import dao.DAOCliente;
import dao.DAOItem;
import dao.DAOPedido;
import dao.DAOPedidoComum;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;




/**
 *
 * @author Vinicius
 */

@SessionScoped
@ManagedBean
public class ClienteBean implements Serializable{
    private Cliente cliente ;
    private DAOCliente daoCliente;
    
    protected DAOPedido daoPedido;
    
    private boolean info;
    private boolean cart;
    
    private List<ItemPedido> ip;
    boolean tipo; // tipo de pedido usano em minhaconta, decide entre pedido comum e delivery
    private String agendamento; //agendamento da entrega
    int valorMenuOption; // valor 1 ou 2 do tipo de agendamento na page minhaConta
    
    private List<Pedido> meusPedidos; // lista de pedidos realizados pelo cliente, page minha conta
    
    private NotaFiscal notaf; //pedido que será exposto na nota fiscal em minhaconta.xhtml
    
    public ClienteBean(){
        cliente = new Cliente();
        daoCliente = new DAOCliente();
        info = false;
        ip = new ArrayList<>();
        valorMenuOption = 0;
        agendamento = "Não especificado";
        daoPedido = new DAOPedido();        
    }
    
    public void finalizarPedido(){
        if(totalPedido() == 0.0)
            return;
        cliente.finalizarPedido(ip, tipo, agendamento);
        ip = new ArrayList<>();
        showGrowl();
    }
    
   
    public void showGrowlMenu() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Adicionado!", "Seu produto foi adicionado ao carrinho"));
        
    }
    public void showGrowl() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Obrigado!", "Seu pedido foi realizado"));
        
    }
    
    public String tipoPedido(){
        if(valorMenuOption == 1){
            tipo = true;
            return "Especifique o dia e a hora de entrega do seu produto.";
        }else{
            tipo = false;
            return "Deseja Realmente finalizar o pedido?";
        }
    }
    
    
    public float totalPedido(){
        if(ip.isEmpty())
            return (float) 0.0;
        
        float total = 0;
        for (int j = 0; j < ip.size(); j++) {
            total += ip.get(j).getPreco();
        }
        
        return total;
    }
    
    public String cadastrarLogarCliente(){ 
        daoCliente.SalvarCliente(cliente);
        return "sys/menu.xhtml?faces-redirect=true";
    }
    
    public String logarCliente(Usuario usr){
            
            if(!(cliente.getCpf() == null || (!(cliente.getCpf().equals(""))))){//caso tenha tentado uma senha errada
                return "sys/menu.xhtml?faces-redirect=true";
                //return retornar pra page de produtos | fazer as parada no index tbm
            }

            Cliente a = daoCliente.buscarCliente(usr.getCpf());
            if(a == null){ //caso o banco nao encontre nada
                info = true;
                return "";
            }
            if(a.getSenha().equals(usr.getSenha())){
                info = false;
                cliente = a;
                return "sys/menu.xhtml?faces-redirect=true";
            } else{
                info = true;
                return "";
            }
    }
    
    public void add(ItemPedido item){
        ip.add(item);
        showGrowlMenu();
    }
    public void remove(ItemPedido item){
        ip.remove(item);
    }
    
    public boolean isEmpty(){
        return ip.isEmpty();
    }
    
    public boolean isLogado(){
        if(cliente != null){
            if(!(cliente.getCpf() == null || cliente.getCpf().equals(""))){
                return true;
            }
        }
            return false;
    }

    /**
     *
     * @return String
     */
    public String sLogado(){
        if(cliente != null){
            if(!(cliente.getCpf() == null || cliente.getCpf().equals(""))){
                return "/index.xhtml?faces-redirect=true";
            }
        }
            return "/index.xhtml?faces-redirect=true";
    }
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isInfo() {
        return info;
    }

    public List<ItemPedido> getIp() {
        return ip;
    }

    public boolean isCart() {
        return cart;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public String getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(String agendamento) {
        this.agendamento = agendamento;
    }

    public int getValorMenuOption() {
        return valorMenuOption;
    }

    public void setValorMenuOption(int valorMenuOption) {
        this.valorMenuOption = valorMenuOption;
    }

    public List<Pedido> getMeusPedidos() {
        meusPedidos = null;
        meusPedidos = daoPedido.allPedidos(this.cliente.getCpf());
        return meusPedidos;
    }

    public NotaFiscal getNotaf() {
        return notaf;
    }

    
    
    public void gerarNF(Pedido p){
        notaf = new NotaFiscal();
        notaf.setCodigoPedido(p.getCodigoPedido());
        notaf.setCpfCliente(p.getCpfCliente());
        notaf.setValorTota(p.getPagamento().getValor());
        String[] horario = p.getPagamento().getDataPagamento().toString().split(" ");
        notaf.setDataPedido(horario[0]);
        notaf.setHora(horario[1]);
    }


    
    
    
}
