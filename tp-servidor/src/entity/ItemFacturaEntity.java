package entity;

import javax.persistence.*;

@Entity
@Table(name="items_facturas")
public class ItemFacturaEntity {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer itf_id;
//	@OneToOne
//	@JoinColumn(name="art_id")
//	@Column(name="itf_art")
//	private ArticuloEntity articulo;
	@Column(name="itf_cant")
	private Integer cantidad;
	@Column(name="itf_sub_tot")
	private float subTotal;
	
	public ItemFacturaEntity(){
	}
	
//	public ArticuloEntity getArticulo() {
//		return articulo;
//	}
//	public void setArticulo(ArticuloEntity articulo) {
//		this.articulo = articulo;
//	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	
	
	public Integer getItf_id() {
		return itf_id;
	}

	public void setItf_id(Integer itf_id) {
		this.itf_id = itf_id;
	}
	
	
	
}
