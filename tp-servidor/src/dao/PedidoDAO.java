package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import entity.PedidoEntity;

import excepcion.PedidoException;
import hibernate.HibernateUtil;
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
		if(p.getCliente() != null)
			pe.setCliente(ClienteDAO.getInstancia().toEntity(p.getCliente()));
		else
			pe.setCliente(null);
		
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
			throw new PedidoException("El pedido " + pe.getIdPedido() + " ya existe.");
		}
		s.close();
		
	}
	
	

	
}
