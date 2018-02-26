package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="items_pedidos")
public class ItemPedidoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ite_id")
	private Integer idItemPedido;
	
	@OneToOne
	@JoinColumn(name="ite_art")
	private ArticuloEntity articulo;
	
	@Column(name="ite_cant")
	private Integer cantidadSolicitada;
	
	@Column(name="ite_cant_res")
	private Integer cantidadReservada;
	
	@Column(name="ite_sub_tot")
	private float subTotal;
	
	@ManyToOne
	@JoinColumn(name="ite_ped")
	private PedidoEntity pedido;
	
	
	public ItemPedidoEntity() {}
	
	
	
	public PedidoEntity getPedido() {
		return pedido;
	}



	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}



	public ArticuloEntity getArticulo() {
		return articulo;
	}
	public void setArticulo(ArticuloEntity articulo) {
		this.articulo = articulo;
	}
	
	
	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public Integer getIdItemPedido() {
		return idItemPedido;
	}


	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
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
