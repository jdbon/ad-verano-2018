package test;

import dao.ArticuloDAO;
import dao.UbicacionDAO;
import excepcion.ArticuloException;
import excepcion.UbicacionException;
import negocio.Articulo;
import negocio.Lote;
import negocio.Ubicacion;

public class Test2 {

	public static void main(String[] args) {
		try {
			Articulo a = ArticuloDAO.getInstancia().findByID(1);
			System.out.println(a.toString());
			
			for(Lote l : a.getLotes()){
				System.out.println(l.toString());
			}
			
//			for(Movimiento m : a.getMovimientos()){
//				System.out.println(m.toString());
//			}
			
			try {
				Ubicacion u = UbicacionDAO.getInstancia().findById("A010101");
				System.out.println(u.toString());
			} catch (UbicacionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			
		} catch (ArticuloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
