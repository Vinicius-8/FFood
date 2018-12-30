package dao;

import controller.Cliente;
import java.io.Serializable;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import uti.HibernateUtil;

/**
 *
 * @author Vinicius
 */
public class DAOCliente implements Serializable{    
    private Session session;
    private Transaction transaction;

    private void session() throws HibernateException{
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public void SalvarCliente(Cliente cliente) {
        try {
            session();
            session.save(cliente);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao Salvar o cadastro" + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    //buscando cliente
    public Cliente buscarCliente(String cpf){
        Cliente resultado = null;
        try{
            session();
            Query selects = session.createQuery("From Cliente where cpf = '"+cpf+"'"); 
            resultado =  (Cliente) selects.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao buscar veiculo: "+e.getMessage());
        } finally {
            session.close();
        }
        return resultado;
    }

   
}
