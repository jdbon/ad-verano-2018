package negocio;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import dao.PedidoDAO;
import dto.PedidoDTO;
import enumerator.EstadoPedido;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import excepcion.PedidoException;

public class Pedido {

	private int idPedido;
	private List<ItemPedido> items;
	private Cliente cliente;
	private String direccion;
	private EstadoPedido estado;
	private Date fechaCreacion;
	private Date fechaEntregaEstimada;
	private String motivoRechazo;
	
	public Pedido () {}
	
	public Pedido(int idCliente, String direccion) throws ClienteException {

		this.direccion = direccion;
		this.items = new ArrayList<ItemPedido>();
		this.estado = EstadoPedido.Pendiente;
		this.fechaCreacion = Date.valueOf(LocalDate.now());
		this.cliente = buscarCLiente(idCliente);		
		
	}
	
	public PedidoDTO toDTO () {
		PedidoDTO pe = new PedidoDTO();
		pe.setIdPedido(this.idPedido);
		pe.setDireccion(this.direccion);
		pe.setEstado(this.estado);
		pe.setFechaCreacion(this.fechaCreacion);
		pe.setFechaEntregaEstimada(this.fechaEntregaEstimada);
		pe.setMotivoRechazo(this.motivoRechazo);
		pe.setClienteDTO(this.cliente.toDTO());
        
		return pe;
	}
	
	public void agregarItemPedido(int articuloSolicitado, int cantidadSolicitada) throws ArticuloException {
		
		ItemPedido itemPedido = new ItemPedido(articuloSolicitado, cantidadSolicitada);
		this.items.add(itemPedido);
	}

	private Cliente buscarCLiente(int idCliente) throws ClienteException {
		
		Cliente cliente = ClienteDAO.getInstancia().findByID(idCliente);
		
		return cliente;
	}
	
	public boolean verificarStock() {
		
		boolean parcial;
		parcial = true;
		for (ItemPedido item: this.items){
			if (parcial == true){
				parcial = item.verificarStock();
			}
		}
		
		return parcial;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public List<ItemPedido> getItems() {
		return items;
	}

	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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

	public void save() throws PedidoException {
		// TODO Auto-generated method stub
		PedidoDAO.getInstancia().save(this);
		
	}
	
}
