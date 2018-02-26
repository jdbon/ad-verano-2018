package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="lotes")
public class LoteEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lot_id")
	private Integer idLote;
	
	@Column(name="lot_nro")
	private String nroLote;
	
	@Column(name="lot_vto")
	private Date vencimiento;
	
	@OneToOne
	@JoinColumn(name="lot_art")
	private ArticuloEntity articuloE;
	
	public ArticuloEntity getArt() {
		return articuloE;
	}

	public void setArt(ArticuloEntity art) {
		this.articuloE = art;
	}

	public LoteEntity() {
		super();
		
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



}
