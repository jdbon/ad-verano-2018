package negocio;

import java.util.Date;

import dto.LoteDTO;
import dto.OrdenDeCompraDTO;
import entity.LoteEntity;

public class Lote {
	
	private int idLote;
	private String nroLote;
	private Date vencimiento;
	
	
	public Lote() {		
	}
	
	public Integer getIdLote() {
		return idLote;
	}

	public void setIdLote(Integer idLote) {
		this.idLote = idLote;
	}

	public String getNroLote() {
		return nroLote;
	}

	public void setNroLote(String nroLote) {
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
	
	public LoteDTO toDTO() {
		
		LoteDTO LDTO = new LoteDTO();
		
		LDTO.setIdLote(this.idLote);
		LDTO.setNroLote(this.nroLote);
		LDTO.setVencimiento(this.vencimiento);
				
			return LDTO;
	}
	
	public String toString(){
		return "Nro lote: " + this.getNroLote() + " - Venc: " + this.getVencimiento();
	}
	

}

