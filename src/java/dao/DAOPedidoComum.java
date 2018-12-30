package dao;

import controller.PedidoComum;
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
public class DAOPedidoComum implements Serializable{
    private Session session;
    private Transaction transaction;

    private void session() throws HibernateException {

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    public void SalvarPedido(PedidoComum pedido) {
        try {
            session();
            session.save(pedido);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao Salvar o pedido comum" + e.getMessage());
        } finally {
            session.close();
        }
    }
    
    public List<PedidoComum> allPedidosComuns() {
        List<PedidoComum> resultado = null;
        try {
            session();
            Query selects = session.createQuery("from PedidoComum");
            resultado = selects.list();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao buscar todos os PedidosComuns >> " + e.getMessage());
        } finally {
            session.close();
        }

        return resultado;
    }
    public List<PedidoComum> allPedidosComuns(String cpf) {
        List<PedidoComum> resultado = null;
        try {
            session();
            Query selects = session.createQuery("from PedidoComum where cpfCliente = "+cpf);
            resultado = selects.list();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao buscar todos os PedidosComuns >> " + e.getMessage());
        } finally {
            session.close();
        }

        return resultado;
    }
    
    public void AtualizarPedidoComum(PedidoComum pedido) {
        try {
            session();
            session.update(pedido);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao atualizar o pedidoComum");
        } finally {
            session.close();
        }
    }
}
