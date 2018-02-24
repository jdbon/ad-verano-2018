package entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import negocio.EstadoPedido;

@Entity
@Table(name="pedidos")
public class PedidoEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ped_id")
	private Integer idPedido;
	
	@OneToMany
	@JoinColumn(name="ped_id")
	private List<ItemPedidoEntity> items;
	
	@OneToOne
	@JoinColumn(name="ped_cli")
	private ClienteEntity cliente;
	
	@Column(name="ped_direc")
	private String direccion;
	
	@Column(name="ped_tep")
	@Enumerated(EnumType.ORDINAL)
	private EstadoPedido estado;
	
	@Column(name="ped_fec_generacion")
	//@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Column(name="ped_fec_entrega")
	private Date fechaEntregaEstimada;
	
	@Column(name="ped_motivo_rechazo")
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
