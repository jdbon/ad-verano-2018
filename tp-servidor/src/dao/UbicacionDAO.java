package dao;

import entity.UbicacionEntity;
import negocio.Ubicacion;

public class UbicacionDAO {
	
	private static UbicacionDAO instancia;
	
	public UbicacionDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static UbicacionDAO getInstancia () {
		if(instancia==null)
			instancia = new UbicacionDAO();
		return instancia;
	}
	
	public UbicacionEntity toEntity (Ubicacion ub) {
		UbicacionEntity ubE = new UbicacionEntity();
		ubE.setArticulo(ArticuloDAO.getInstancia().toEntity(ub.getArticulo()));
		ubE.setBloque(ub.getBloque());
		
		
		return null;
	}

}
