package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.ArticuloEntity;
import entity.ItemPedidoEntity;
import entity.LoteEntity;
import excepcion.ItemPedidoException;
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
	
	public void update(ItemPedido ip) throws ItemPedidoException{
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

	public ItemPedidoEntity toEntity(ItemPedido itped){
		ItemPedidoEntity itpedE = new ItemPedidoEntity();
		itpedE.setCantidadReservada(itped.getCantidadReservada());
		itpedE.setCantidadSolicitada(itped.getCantidadSolicitada());
		itpedE.setSubTotal(itped.getSubTotal());
		return itpedE;
	}
	
	public ItemPedido toNegocio(ItemPedidoEntity itpedE){
		ItemPedido itped = new ItemPedido();
		itped.setCantidadReservada(itped.getCantidadReservada());
		itped.setCantidadSolicitada(itped.getCantidadSolicitada());
		itped.setSubTotal(itped.getSubTotal());
		return itped;
	}

}
