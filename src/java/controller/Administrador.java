package controller;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Vinicius
 */
@Entity
public class Administrador extends Usuario implements Serializable {

    public Administrador() {
    }
    
    
    public Administrador(String cpf, String nome, String senha) {
        super(cpf, nome, senha);
    }
        
}
