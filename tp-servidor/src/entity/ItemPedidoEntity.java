package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.Articulo;

@Entity
@Table(name="items_pedidos")
public class ItemPedidoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ite_id")
	private Integer idItemPedido;
	
	@Column(name="ite_cant")
	private Integer cantidadSolicitada;
	
	@Column(name="ite_cant_res")
	private Integer cantidadReservada;
	
	@Column(name="ite_sub_tot")
	private float subTotal;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ite_ped")
	private PedidoEntity pedidoE;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="ite_art")
	private ArticuloEntity artE;	
	
	public ItemPedidoEntity() {}
	
	
	public PedidoEntity getPedidoE() {
		return pedidoE;
	}


	public void setPedidoE(PedidoEntity pedidoE) {
		this.pedidoE = pedidoE;
	}


	public ArticuloEntity getArtE() {
		return artE;
	}


	public void setArtE(ArticuloEntity artE) {
		this.artE = artE;
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
