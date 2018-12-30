package beans;

import controller.Usuario;
import dao.DAOCliente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Vinicius
 */
@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
    private Usuario usuario;
    private DAOCliente daoC;
    public UsuarioBean(){
        usuario = new Usuario();
        daoC = new DAOCliente();
    }
    
    public void init(){
        daoC.buscarCliente("");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
