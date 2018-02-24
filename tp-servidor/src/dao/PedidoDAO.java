package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.ClienteEntity;
import entity.PedidoEntity;
import excepcion.ClienteException;
import excepcion.PedidoException;
import hibernate.HibernateUtil;
import negocio.Cliente;
import negocio.Pedido;

public class PedidoDAO {

	private static PedidoDAO instancia;
	
	private PedidoDAO() {}
	
	public static PedidoDAO getInstancia() {
		if(instancia == null)
			instancia = new PedidoDAO();
		return instancia;
		
	}
	
	public PedidoEntity toEntity(Pedido p){
		
		PedidoEntity pe = new PedidoEntity();
		pe.setIdPedido(p.getIdPedido());
		pe.setDireccion(p.getDireccion());
		pe.setEstado(p.getEstado());
		pe.setFechaCreacion(p.getFechaCreacion());
		pe.setFechaEntregaEstimada(p.getFechaEntregaEstimada());
		pe.setMotivoRechazo(p.getMotivoRechazo());
        pe.setCliente(ClienteDAO.getInstancia().toEntity(p.getCliente()));
        //itemPedidoEntity esta comentado en la Entity por ahora
		
		return pe;
		
	}
	
	
	public void save(Pedido p) throws PedidoException{
		PedidoEntity pe = this.toEntity(p);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		try {
		s.save(pe);
		s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
			throw new PedidoException("Error al grabar pedido, o el pedido " + pe.getIdPedido() + " ya existe.");
		}
		s.close();
		
	}

	public Pedido toNegocio(PedidoEntity pe) {
		Pedido p = new Pedido();
		
		p.setIdPedido(pe.getIdPedido());
		p.setDireccion(pe.getDireccion());
		p.setEstado(pe.getEstado());
		p.setFechaCreacion(pe.getFechaCreacion());
		p.setFechaEntregaEstimada(pe.getFechaEntregaEstimada());
		
		p.setMotivoRechazo(pe.getMotivoRechazo());
		
		p.setCliente(ClienteDAO.getInstancia().toNegocio(pe.getCliente()));
		//Falta convertir ItemPedido a Negocio
		p.setItems(null);
		
		return p;
	}
	
	public Pedido findById(int idPedido) throws PedidoException{
		Pedido p;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		PedidoEntity auxPedido = (PedidoEntity) s.createQuery("From PedidoEntity c where c.idPedido = ?").setInteger(0, idPedido).uniqueResult();
		s.close();
		if(auxPedido == null) {
				throw new PedidoException("No existe un cliente con el id " + idPedido);
		}
		p = this.toNegocio(auxPedido);
		return p;
	}
	
	

	
}
