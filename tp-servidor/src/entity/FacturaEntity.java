package entity;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="faturas")
public class FacturaEntity {
	@Id
	@Column(name="fac_id")
	private Integer nroFactura;
	@ManyToOne
	@JoinColumn(name="cli_id")
	private ClienteEntity clienteEntity;
	@OneToMany
	@JoinColumn(name="itf_fac")
	private List<ItemFacturaEntity> itemsEntity;
	@Enumerated(EnumType.STRING)
	private TipoFacturaEntity tipoEntity;
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

	public List<ItemFacturaEntity> getItems() {
		return itemsEntity;
	}

	public void setItems(List<ItemFacturaEntity> items) {
		this.itemsEntity = items;
	}

	public TipoFacturaEntity getTipo() {
		return tipoEntity;
	}

	public void setTipo(TipoFacturaEntity tipo) {
		this.tipoEntity = tipo;
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
