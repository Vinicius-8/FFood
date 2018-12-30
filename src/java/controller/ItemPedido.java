package controller;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Vinicius
 */
@Entity
public class ItemPedido implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigoItem;
    private String nomeItem;
    @OneToOne
    private Categoria categoria;
    private float preco;
    private String imgPath;

    public ItemPedido() {
    }

    public ItemPedido(int codigoItem, String nomeItem, Categoria categoria, float preco, String imgPath) {
        this.codigoItem = codigoItem;
        this.nomeItem = nomeItem;
        this.categoria = categoria;
        this.preco = preco;
        this.imgPath = imgPath;
    }


    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    
    @Override
    public String toString() {
        return "ItemPedido{" + "codigoItem=" + codigoItem + ", nomeItem=" + nomeItem + ", categoria=" + categoria.getNomeCategoria() + ", preco=" + preco + '}';
    }
    
    
    
}
