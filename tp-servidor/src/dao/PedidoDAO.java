package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.ItemPedidoEntity;
import entity.PedidoEntity;
import enumerator.EstadoPedido;
import excepcion.ArticuloException;
import excepcion.ItemPedidoException;
import excepcion.PedidoException;
import hibernate.HibernateUtil;
import negocio.ItemPedido;
import negocio.Pedido;

public class PedidoDAO {

	private static PedidoDAO instancia;
	
	private PedidoDAO() {}
	
	public static PedidoDAO getInstancia() {
		if(instancia == null)
			instancia = new PedidoDAO();
		return instancia;
		
	}
	
	
		
	public PedidoEntity toEntity(Pedido p) throws ArticuloException{
		
		PedidoEntity pe = new PedidoEntity();
		pe.setIdPedido(p.getIdPedido());
		pe.setDireccion(p.getDireccion());
		pe.setEstado(p.getEstado());
		pe.setFechaCreacion(p.getFechaCreacion());
		pe.setFechaEntregaEstimada(p.getFechaEntregaEstimada());
		pe.setMotivoRechazo(p.getMotivoRechazo());
        pe.setCliente(ClienteDAO.getInstancia().toEntity(p.getCliente()));
        List<ItemPedidoEntity> itemsE = new ArrayList<ItemPedidoEntity>();
		for (ItemPedido item: p.getItems()){
			itemsE.add(ItemPedidoDAO.getInstancia().toEntity(item));
		}
		return pe;
		
	}
	
	
	public void save(Pedido p) throws PedidoException, ItemPedidoException, ArticuloException{
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
	
	public void update(Pedido p) throws PedidoException, ArticuloException{
		PedidoEntity pe = this.toEntity(p);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		try {
		s.update(pe);
		s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
			throw new PedidoException("Error al actualizar el pedido" + pe.getIdPedido());
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
		p.setItems(null);
		
		return p;
	}
	
	public Pedido findById(int idPedido) throws PedidoException{
		Pedido p;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		PedidoEntity auxPedido = (PedidoEntity) s.createQuery("From PedidoEntity pe where pe.idPedido = ?").setInteger(0, idPedido).uniqueResult();
		s.close();
		if(auxPedido == null) {
				throw new PedidoException("No existe un pedido con el id " + idPedido);
		}
		p = this.toNegocio(auxPedido);
		return p;
	}
	
	public List<Pedido> getPendientes() throws PedidoException{
		List<Pedido> pedidos_pen = new ArrayList<Pedido>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		@SuppressWarnings("unchecked")
		List<PedidoEntity> auxPedidos = s.createQuery("From PedidoEntity pe where pe.estado = ? order by pe.fechaCreacion asc").setString(0, EstadoPedido.Pendiente.name()).list();
		s.close();
		if(auxPedidos == null) {
				throw new PedidoException("No existen Pedidos Pendientes");
		}
		for (PedidoEntity pe : auxPedidos) {
			pedidos_pen.add(this.toNegocio(pe));
		}
		
		return pedidos_pen;
	}

	public List<Pedido> getCompletados()throws PedidoException {
		List<Pedido> pedidos_com = new ArrayList<Pedido>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		List<PedidoEntity> auxPedidos = (List<PedidoEntity>)s.createQuery("From PedidoEntity pe where pe.estado = ? order by pe.fechaCreacion asc").setString(0, EstadoPedido.Completo.name()).list();
		s.close();
		if(auxPedidos == null) {
				throw new PedidoException("No existen pedidos completados");
		}
		for (PedidoEntity pe : auxPedidos) {
			pedidos_com.add(this.toNegocio(pe));
		}
		
		return pedidos_com;
	}

	public List<Pedido> getDespachados() throws PedidoException{
		List<Pedido> pedidos_des = new ArrayList<Pedido>();
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		List<PedidoEntity> auxPedidos = (List<PedidoEntity>)s.createQuery("From PedidoEntity pe where pe.estado = ? order by pe.fechaCreacion asc").setString(0, EstadoPedido.Despachado.name()).list();
		s.close();
		if(auxPedidos == null) {
				throw new PedidoException("No existen pedidos despachados");
		}
		for (PedidoEntity pe : auxPedidos) {
			pedidos_des.add(this.toNegocio(pe));
		}
		
		return pedidos_des;
	}
	

	
}
