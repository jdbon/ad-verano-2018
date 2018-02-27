package test;

import java.util.Date;

import dao.ArticuloDAO;
import enumerator.EstadoOC;
import excepcion.ArticuloException;
import excepcion.OrdenDeCompraException;
import negocio.Articulo;
import negocio.OrdenDeCompra;

public class TestOC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Grabar una OC
		java.util.Date dia = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(dia.getTime());
		
		OrdenDeCompra oc = new OrdenDeCompra();
		try {
			Articulo a = ArticuloDAO.getInstancia().findByID(1);
			oc.setArticulo(a);
			oc.setCantidadReservada(100);
			oc.setCantidadXcomprar(a.getCantidadOrdenDeCompra());
			oc.setEstado(EstadoOC.Pendiente);
			oc.setFechaCreacion(sqlDate);
			oc.save();
		} catch (ArticuloException | OrdenDeCompraException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
