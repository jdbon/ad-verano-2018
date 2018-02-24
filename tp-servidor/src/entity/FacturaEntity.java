package entity;

import java.util.*;

import javax.persistence.*;

import enumerator.TipoFactura;

@Entity
@Table(name="facturas")
public class FacturaEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	@Column(name="fac_id")
	private Integer nroFactura;
	@ManyToOne
	@JoinColumn(name="fac_cli")
	private ClienteEntity clienteEntity;
//	@OneToMany
//	@JoinColumn(name="itf_fac")
//	private List<ItemFacturaEntity> itemsEntity;
	@Column(name="fac_tfa")
	@Enumerated(EnumType.STRING)
	private TipoFactura tipo;
	@Column(name="fac_tot")
	private float total;
	@OneToOne
	@JoinColumn(name="fac_ped")
	private PedidoEntity pedidoEntity;
	@Column(name="fac_fec")
	private Date fecha;
	
	public FacturaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(Integer nroFactura) {
		this.nroFactura = nroFactura;
	}

	public ClienteEntity getCliente() {
		return clienteEntity;
	}

	public void setCliente(ClienteEntity cliente) {
		this.clienteEntity = cliente;
	}

//	public List<ItemFacturaEntity> getItems() {
//		return itemsEntity;
//	}
//
//	public void setItems(List<ItemFacturaEntity> items) {
//		this.itemsEntity = items;
//	}

	public TipoFactura getTipo() {
		return tipo;
	}

	public void setTipo(TipoFactura tipo) {
		this.tipo = tipo;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public PedidoEntity getPedido() {
		return pedidoEntity;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedidoEntity = pedido;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	

}
