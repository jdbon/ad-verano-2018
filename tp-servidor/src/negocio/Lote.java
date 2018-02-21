package negocio;

import java.util.Date;

public class Lote {
	
	private Integer nroLote;
	private Date vencimiento;
	
	public Lote() {
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
