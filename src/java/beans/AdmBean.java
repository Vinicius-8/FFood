package beans;

import controller.Administrador;
import controller.Usuario;
import dao.DAOAdm;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vinicius
 */

@ManagedBean
@SessionScoped
public class AdmBean implements Serializable{
    private Administrador adm;
    private DAOAdm daoAdm;
    
    //alert na pagina admin
    private boolean info;
    
    //dashboard
    private boolean pedidos;
    private boolean item;
    
    public AdmBean(){
        adm = new Administrador();
        daoAdm = new DAOAdm();
        info = false;
        pedidos = true;
        item = false;
    }
    
    
    
    public String logarAdm(Usuario usr){
        
        if(!(adm.getCpf() == null || adm.getCpf().equals(""))){

            return "admin.xhtml?faces-redirect=true";
        }
        
        Administrador _adm = daoAdm.buscarAdm(usr.getCpf());
        if (_adm == null){

            info = true;
            return "";
        }
        
        if (_adm.getSenha().equals(usr.getSenha())){
            adm = _adm;
            info = false;
            return "dashboard.xhtml?faces-redirect=true";
        }else{

            info = true;
            return "";
        }
    }
        
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }
        
    public boolean isLogado() {
        if (adm != null) {
            if (!(adm.getCpf() == null || adm.getCpf().equals(""))) {
                return true;
            }
        }
        return false;
    }
    
    public void switiPedidos(){
        pedidos = true;
        item = false;
    }
    public void switiItens(){
        item = true;
        pedidos = false;
    }
    
    public Administrador getAdm() {
        return adm;
    }

    public boolean isInfo() {
        return info;
    }

    public boolean isPedidos() {
        return pedidos;
    }

    public boolean isItem() {
        return item;
    }
    
    
}
