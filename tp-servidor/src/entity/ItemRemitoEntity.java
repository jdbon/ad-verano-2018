package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.Articulo;

@Entity
@Table(name="item_remitos")
public class ItemRemitoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="itr_id")
	private Integer idItemRemito;
	
	@OneToOne
	@JoinColumn(name="itr_art")
	private Articulo articulo;
	
	@Column(name="itr_cant")
	private Integer cantidad;
	
	public ItemRemitoEntity() {}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	

}
