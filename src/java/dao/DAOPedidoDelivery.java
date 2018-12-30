package dao;

import controller.PedidoDelivery;
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
public class DAOPedidoDelivery implements Serializable{
    private Session session;
    private Transaction transaction;

    private void session() throws HibernateException {

        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }
    
    public void SalvarPedido(PedidoDelivery pedido) {
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
    public List<PedidoDelivery> allPedidosDelivery() {
        List<PedidoDelivery> resultado = null;
        try {
            session();
            Query selects = session.createQuery("from PedidoDelivery");
            resultado = selects.list();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao buscar todos os PedidosDeliverys >> " + e.getMessage());
        } finally {
            session.close();
        }

        return resultado;
    }
    public List<PedidoDelivery> allPedidosDelivery(String cpf) {
        List<PedidoDelivery> resultado = null;
        try {
            session();
            Query selects = session.createQuery("from PedidoDelivery where cpfCliente = "+cpf);
            resultado = selects.list();
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println("Erro ao buscar todos os PedidosDeliverys >> " + e.getMessage());
        } finally {
            session.close();
        }

        return resultado;
    }
    
    public void AtualizarPedidoDelivery(PedidoDelivery pedido) {
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
