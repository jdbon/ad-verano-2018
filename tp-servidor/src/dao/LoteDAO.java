package dao;

import entity.LoteEntity;
import negocio.Lote;

public class LoteDAO {
	
	private static LoteDAO instancia;
	
	private LoteDAO() {}
	
	public static LoteDAO getInstancia() {
		if(instancia == null)
			instancia = new LoteDAO();
		return instancia;
		
	}
	
	public LoteEntity toEntity(Lote l){
		
		LoteEntity le = new LoteEntity();
		
		le.setIdLote(l.getIdLote());
		le.setNroLote(l.getNroLote());
		le.setVencimiento(l.getVencimiento());
		
		return le;
		
	}
	
	public Lote toNegocio(LoteEntity le){
		Lote l = new Lote();
		
		l.setIdLote(le.getIdLote());
		l.setNroLote(le.getNroLote());
		l.setVencimiento(l.getVencimiento());
		l.setArt(ArticuloDAO.getInstancia().toNegocio(le.getArt()));
		
		return l;
	}

}
