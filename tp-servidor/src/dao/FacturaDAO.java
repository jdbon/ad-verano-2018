package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.FacturaEntity;
import entity.PedidoEntity;
import excepcion.FacturaException;
import excepcion.PedidoException;
import hibernate.HibernateUtil;
import negocio.Factura;

public class FacturaDAO {
	
	private static FacturaDAO instancia;
	
	private FacturaDAO() {}
	
	public static FacturaDAO getInstancia() {
		if(instancia == null)
			instancia = new FacturaDAO();
		return instancia;
		
	}
	
	public FacturaEntity toEntity(Factura f){
		FacturaEntity fe = new FacturaEntity();
		
		fe.setFecha(f.getFecha());
		fe.setNroFactura(f.getNroFactura());
		fe.setTipo(f.getTipo());
		fe.setTotal(f.getTotal());
		
		fe.setCliente(ClienteDAO.getInstancia().toEntity(f.getCliente()));
		fe.setPedido(PedidoDAO.getInstancia().toEntity(f.getPedido()));
		
		//Falta llamar a ItemPedidoDAO.getInstancia().toEntity
		fe.setItems(null);
		
		
		return fe;
	}
	
	public Factura toNegocio(FacturaEntity fe){
		Factura f = new Factura();
		
		f.setFecha(fe.getFecha());
		f.setNroFactura(fe.getNroFactura());
		f.setTipo(f.getTipo());
		f.setTipo(fe.getTipo());
		
		f.setCliente(ClienteDAO.getInstancia().toNegocio(fe.getCliente()));
		f.setPedido(PedidoDAO.getInstancia().toNegocio(fe.getPedido()));
		
		
		return f;
	}
	
	public void save(Factura f) throws FacturaException{
		
		FacturaEntity fe = this.toEntity(f);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		try {
		s.save(fe);
		s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
			throw new FacturaException("La factura " + fe.getNroFactura() + " ya existe.");
		}
		s.close();
	}

}
