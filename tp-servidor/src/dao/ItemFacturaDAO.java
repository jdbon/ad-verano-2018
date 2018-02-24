package dao;

import entity.*;
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
	
	
	
	
	
	

}
