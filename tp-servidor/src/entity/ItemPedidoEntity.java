package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import negocio.Articulo;

@Entity
@Table(name="items-pedidos")
public class ItemPedidoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ite_id")
	private Integer idItemPedido;
	
	@OneToMany
	@JoinColumn(name="ite_art")
	private Articulo articulo;
	
	@Column(name="ite_cant")
	private Integer cantidadSolicitada;
	
	@Column(name="ite_cant_res")
	private Integer cantidadReservada;
	
	@Column(name="ite_sub_tot")
	private float subTotal;
	
	
	public ItemPedidoEntity() {}
	
	
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	public Integer getCantidadReservada() {
		return cantidadReservada;
	}
	public void setCantidadReservada(Integer cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	} 
	
	
}
