package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.OrdenDeCompraEntity;
import excepcion.OrdenDeCompraException;
import hibernate.HibernateUtil;
import negocio.OrdenDeCompra;

public class OrdenDeCompraDAO {
	
	private static OrdenDeCompraDAO instancia;
	
	private OrdenDeCompraDAO() {}
	
	public static OrdenDeCompraDAO getInstancia() {
		if(instancia == null)
			instancia = new OrdenDeCompraDAO();
		return instancia;
		
	}
	
	public OrdenDeCompra toNegocio(OrdenDeCompraEntity oce){
		OrdenDeCompra oc = new OrdenDeCompra();
		
		oc.setArticulo(ArticuloDAO.getInstancia().toNegocio(oce.getArticulo()));
		oc.setCantidadReservada(oce.getCantidadReservada());
		oc.setCantidadXcomprar(oce.getCantidadXcomprar());
		oc.setEstado(oce.getEstado());
		oc.setFechaRecepcion(oce.getFechaRecepcion());
		oc.setNroOrdenDeCompra(oce.getNroOrdenDeCompra());
		
		return oc;
	}
	
	public OrdenDeCompraEntity toEntity(OrdenDeCompra oc){
		OrdenDeCompraEntity oce = new OrdenDeCompraEntity();
		
		oce.setArticulo(ArticuloDAO.getInstancia().toEntity(oc.getArticulo()));
		oce.setCantidadReservada(oc.getCantidadReservada());
		oce.setCantidadXcomprar(oc.getCantidadXcomprar());
		oce.setEstado(oc.getEstado());
		oce.setFechaRecepcion(oc.getFechaRecepcion());
		oce.setNroOrdenDeCompra(oc.getNroOrdenDeCompra());
		
		
		return oce;
	}
	
	public void save(OrdenDeCompra oc) throws OrdenDeCompraException{
		OrdenDeCompraEntity oce = this.toEntity(oc);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		try {
		s.save(oce);
		s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
			throw new OrdenDeCompraException("Error al grabar OC, o la OC " + oce.getNroOrdenDeCompra() + " ya existe.");
		}
		s.close();
	}
	
	public OrdenDeCompra findById(int idOC) throws OrdenDeCompraException{
		OrdenDeCompra oc;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		OrdenDeCompraEntity auxOrdenDeCompra = (OrdenDeCompraEntity) s.createQuery("From OrdenDeCompraEntity oce where oce.nroOrdenDeCompra = ?").setInteger(0, idOC).uniqueResult();
		s.close();
		if(auxOrdenDeCompra == null) {
				throw new OrdenDeCompraException("No existe una OC con el id " + idOC);
		}
		oc = this.toNegocio(auxOrdenDeCompra);
		return oc;
	}

}
