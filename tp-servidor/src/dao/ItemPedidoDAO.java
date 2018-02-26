package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.ArticuloEntity;
import entity.ItemPedidoEntity;
import entity.LoteEntity;
import entity.PedidoEntity;
import excepcion.ArticuloException;
import excepcion.ItemPedidoException;
import excepcion.PedidoException;
import hibernate.HibernateUtil;
import negocio.Articulo;
import negocio.ItemPedido;
import negocio.Lote;
import negocio.Movimiento;

public class ItemPedidoDAO {

	private static ItemPedidoDAO instancia;
	public ItemPedidoDAO() {}
	
	public static ItemPedidoDAO getInstancia(){
		if(instancia == null)
			instancia = new ItemPedidoDAO();
		return instancia;
	}
	
	public void update(ItemPedido ip) throws ItemPedidoException, ArticuloException{
		ItemPedidoEntity ipe = this.toEntity(ip);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		try {
		s.update(ipe);
		s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
			throw new ItemPedidoException("Error al actualizar el ItemPedido" + ipe.getIdItemPedido());
		}
		s.close();
		
	}

	public ItemPedidoEntity toEntity(ItemPedido itped) throws ArticuloException{
		ItemPedidoEntity itpedE = new ItemPedidoEntity();
		itpedE.setCantidadReservada(itped.getCantidadReservada());
		itpedE.setCantidadSolicitada(itped.getCantidadSolicitada());
		itpedE.setSubTotal(itped.getSubTotal());
		itpedE.setArtE(ArticuloDAO.getInstancia().toEntity(ArticuloDAO.getInstancia().findByID(itped.getArticulo().getCodigoBarra())));
		return itpedE;
	}
	
	public ItemPedido toNegocio(ItemPedidoEntity itpedE) throws ArticuloException{
		ItemPedido itped = new ItemPedido();
		itped.setCantidadReservada(itped.getCantidadReservada());
		itped.setCantidadSolicitada(itped.getCantidadSolicitada());
		itped.setSubTotal(itped.getSubTotal());
		//itped.setArticulo(ArticuloDAO.getInstancia().findByID(itpedE.getArticulo().getCodigoBarra()));
		return itped;
	}

	public void save(ItemPedido item) throws ItemPedidoException, ArticuloException {
		
		ItemPedidoEntity ipE = this.toEntity(item);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		try {
		s.save(ipE);
		s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
			throw new ItemPedidoException("Error al grabar item pedido" + ipE.getIdItemPedido());
		}
		s.close();
	}

}
