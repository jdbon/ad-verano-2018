package entity;

import java.sql.Date;


import javax.persistence.*;

import negocio.EstadoPedido;

@Entity
public class PedidoEntity {
	
	@Id
	@Column(name="ped_id")
	private Integer idPedido;
	
	//private List<ItemPedidoEntity> items;
	
	@OneToOne
	@JoinColumn(name="cli_id")
	private ClienteEntity cliente;
	
	@Column(name="ped_direc")
	private String direccion;
	
	@Column(name="ped_tep")
	@Enumerated(EnumType.STRING)
	private EstadoPedido estado;
	
	@Column(name="ped_fec_generacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Column(name="ped_fec_entrega")
	private Date fechaEntregaEstimada;
	
	@Column(name="ped_fec_motivo_rechazo")
	private String motivoRechazo;

	
	
	public PedidoEntity() {
		super();
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEntregaEstimada() {
		return fechaEntregaEstimada;
	}

	public void setFechaEntregaEstimada(Date fechaEntregaEstimada) {
		this.fechaEntregaEstimada = fechaEntregaEstimada;
	}

	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}
	
	

}
