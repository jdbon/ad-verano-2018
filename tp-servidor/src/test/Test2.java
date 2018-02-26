package test;

import dao.ArticuloDAO;
import excepcion.ArticuloException;
import excepcion.OrdenDeCompraException;
import negocio.Articulo;
import negocio.Lote;
import negocio.Movimiento;

public class Test2 {

	public static void main(String[] args) {
		try {
			Articulo a = ArticuloDAO.getInstancia().findByID(1);
			System.out.println(a.toString());
			
			for(Lote l : a.getLotes()){
				System.out.println(l.toString());
			}
			
			for(Movimiento m : a.getMovimientos()){
				System.out.println(m.toString());
			}
		
			
			
		} catch (ArticuloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
