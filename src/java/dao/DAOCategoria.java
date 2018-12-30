package dao;


import controller.Categoria;
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
public class DAOCategoria implements Serializable{
    private Session session;
    private Transaction transaction;

    private void session() throws HibernateException {

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    public List<Categoria> allCategorias(){
        List resultado = null;
        try{
            session();
            Query selects = session.createQuery("from Categoria");
            resultado = selects.list();
             transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao buscar todos da categoria: " + e.getMessage());
        } finally {
            session.close();
        }
        return resultado;
    }

}
