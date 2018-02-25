package dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import enumerator.EstadoPedido;


public class PedidoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2071632209672397718L;

	private int idPedido;
	private List<ItemPedidoDTO> items;
	private ClienteDTO cliente;
	private String nombreCliente;
	private String direccion;
	private EstadoPedido estado;
	private Date fechaCreacion;
	private Date fechaEntregaEstimada;
	private String motivoRechazo;

	
	
	public PedidoDTO() {
		
	}


	public Integer getIdPedido() {
		return idPedido;
	}



	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}



	public List<ItemPedidoDTO> getItems() {
		return items;
	}



	public void setItems(List<ItemPedidoDTO> items) {
		this.items = items;
	}



	public String getNombreCliente() {
		return nombreCliente;
	}



	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
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


	public ClienteDTO getClienteDTO() {
		return clienteDTO;
	}


	public void setClienteDTO(ClienteDTO clienteDTO) {
		this.clienteDTO = clienteDTO;
	}
	
}
