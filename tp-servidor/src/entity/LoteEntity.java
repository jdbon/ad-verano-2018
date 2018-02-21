package entity;

import java.util.Date;

public class LoteEntity {
	
	private Integer nroLote;
	private Date vencimiento;
	
	public LoteEntity() {
		super();
		
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

}
