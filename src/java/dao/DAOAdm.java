package dao;

import controller.Administrador;
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
public class DAOAdm implements Serializable{
    private Session session;
    private Transaction transaction;

    private void session() throws HibernateException {

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    public Administrador buscarAdm(String cpf) {
        Administrador resultado = null;
        try {
            session();
            Query selects = session.createQuery("From Administrador where cpf = '" + cpf + "'");
            resultado = (Administrador) selects.uniqueResult();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao buscar adm: " + e.getMessage());
        } finally {
            session.close();
        }
        return resultado;
    }
}
