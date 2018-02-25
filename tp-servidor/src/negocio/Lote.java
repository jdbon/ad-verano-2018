package negocio;

import java.util.Date;

import entity.LoteEntity;

public class Lote {
	
	private Integer idLote;
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

public LoteDTO toDTO() {
		
		LoteDTO LDTO = new LoteDTO();
		
		LDTO.setIdLote(this.idLote);
		LDTO.setNroLote(this.nroLote);
		LDTO.setVencimiento(this.vencimiento);
				
			return LDTO;
		}
	

}
