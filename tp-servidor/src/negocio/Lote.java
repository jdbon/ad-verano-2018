package negocio;

import java.util.Date;

import entity.LoteEntity;

public class Lote {
	
	private Integer nroLote;
	private Date vencimiento;
	
	public Lote() {		
	}

	public Integer getNroLote() {
		return nroLote;
	}

	public void setNroLote(Integer nroLote) {
		this.nroLote = nroLote;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}
	
	public LoteEntity toEntity(Lote lote) {
		LoteEntity loteEntity = new LoteEntity();
		loteEntity.setNroLote(lote.getNroLote());
		loteEntity.setVencimiento(lote.getVencimiento());
		
		return loteEntity;
	}
	

}
