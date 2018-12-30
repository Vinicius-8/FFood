package controller;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Vinicius
 */
@Entity
public class Categoria implements Serializable {
    @Id
    private int codigoCategoria;
    private String nomeCategoria;

    public Categoria() {
    }

    public Categoria(int codigoCategoria, String nomeCategoria) {
        this.codigoCategoria = codigoCategoria;
        this.nomeCategoria = nomeCategoria;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    
    
}
