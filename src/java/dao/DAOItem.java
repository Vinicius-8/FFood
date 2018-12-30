package dao;

import controller.ItemPedido;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import uti.HibernateUtil;

/**
 *
 * @author Vinicius
 */
public class DAOItem implements Serializable{    
    private Session session;
    private Transaction transaction;

    private void session() throws HibernateException{
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    public void salvarItem(ItemPedido item){
        try{
            session();
            session.save(item);
            transaction.commit();
        }catch (HibernateException e) {
            System.out.println("Erro ao Salvar o item" + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    public List<ItemPedido> allItensPedidos(){
        List<ItemPedido> resultado = null;
        try{
            session();
            Query selects = session.createQuery("from ItemPedido");
            resultado = selects.list();
            transaction.commit();
        }catch (HibernateException e) {
            System.out.println("Erro ao buscar todos os itens" + e.getMessage());
        } finally {
            session.close();
        }
        
        return resultado;
    }
    
 
}
