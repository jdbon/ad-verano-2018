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
	
public UbicacionEntity toEntity(Ubicacion u){
		
		UbicacionEntity ue = new UbicacionEntity();
		
		ue.setCodigo(u.getCodigo());
		ue.setArticulo(ArticuloDAO.getInstancia().toEntity(u.getArticulo()));
		ue.setLote(LoteDAO.getInstancia().toEntity(u.getLote()));
		ue.setCalle(u.getCalle());
		ue.setBloque(u.getBloque());
		ue.setEstanteria(u.getEstanteria());
		ue.setPosicion(u.getPosicion());
		ue.setCantidadActual(u.getCantidadActual());
		
		return ue;
		
	}
	
	public Ubicacion toNegocio(UbicacionEntity ue){
		Ubicacion u = new Ubicacion();
		
		u.setCodigo(ue.getCodigo());
		u.setArticulo(ArticuloDAO.getInstancia().toNegocio(ue.getArticulo()));
		u.setLote(LoteDAO.getInstancia().toNegocio(ue.getLote()));
		u.setCalle(ue.getCalle());
		u.setBloque(ue.getBloque());
		u.setEstanteria(ue.getEstanteria());
		u.setPosicion(ue.getPosicion());
		u.setCantidadActual(ue.getCantidadActual());
		
		return u;
	}

}
