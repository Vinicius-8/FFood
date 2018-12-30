package dao;

import controller.Endereco;
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
public class DAOEndereco implements Serializable{
    private Session session;
    private Transaction transaction;

    private void session() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public void SalvarEndereco(Endereco endereco) {
        try {
            session();
            session.save(endereco);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao Salvar o cadastro" + e.getMessage());
        } finally {
            session.close();
        }
    }

    //buscando endereco
    public List<Endereco> buscarEndereco(int enderecoId) {
        List<Endereco> resultado = null;
        try {
            session();
            Query selects = session.createQuery("From Endereco where idEndereco = '" + enderecoId + "'");
            resultado = selects.list();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao buscar endereco dados");
        } finally {
            session.close();
        }
        return resultado;
    }

}
