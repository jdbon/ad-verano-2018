package dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.*;
import excepcion.ClienteException;
import excepcion.ItemFacturaException;
import hibernate.HibernateUtil;
import negocio.*;

public class ItemFacturaDAO {
	
	private static ItemFacturaDAO instancia;	

	public ItemFacturaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static ItemFacturaDAO getInstancia(){
		if(instancia == null)
			instancia = new ItemFacturaDAO();
		return instancia;
	}
	
	public ItemFacturaEntity toEntity(ItemFactura item){
		ItemFacturaEntity it = new ItemFacturaEntity();
		it.setCantidad(item.getCantidad());
		it.setSubTotal(item.getSubTotal());
		
		return it;
	}

	public ItemFactura toNegocio(ItemFacturaEntity it){
		ItemFactura item = new ItemFactura();
		item.setArticulo(null); // pendiente traer el articulo cuando avancemos en el mapeo 
		item.setCantidad(it.getCantidad());
		item.setSubTotal(it.getSubTotal());
		return item;
	}
	
	public void save(ItemFactura it) throws  ItemFacturaException{
		ItemFacturaEntity item = this.toEntity(it);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		try {
		s.save(item);
		s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
			throw new ItemFacturaException("El item factura " + item.getItf_id() + " ya existe.");
		}
		s.close();
		
	}
	
	
	
	


}
