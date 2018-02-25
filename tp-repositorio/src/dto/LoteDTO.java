package dto;

import java.io.Serializable;
import java.util.Date;

public class LoteDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6449567659498380241L;
	private Integer idLote;
	private String nroLote;
	private Date vencimiento;
	
	public LoteDTO() {}

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
	
	

}
