package negocio;

import java.time.LocalDate;
import java.sql.Date;
import dao.OrdenDeCompraDAO;
import dto.OrdenDeCompraDTO;
import enumerator.EstadoOC;
import excepcion.OrdenDeCompraException;

public class OrdenDeCompra {
	
	private int nroOrdenDeCompra;
	private Articulo articulo;
	private int cantidadXcomprar;
	private EstadoOC estado;
	private Date fechaRecepcion;
	private int cantidadReservada;
	private Date fechaCreacion;
	
	public OrdenDeCompra(Articulo art, int cantReservada) {
		this.articulo = art;
		this.cantidadXcomprar = art.getCantidadOrdenDeCompra();
		this.estado = EstadoOC.Pendiente;
		this.cantidadReservada = cantReservada;
		this.fechaCreacion = Date.valueOf(LocalDate.now());;
		
	}
	
	public OrdenDeCompra() {}
	
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	
	public void save() throws OrdenDeCompraException{
		OrdenDeCompraDAO.getInstancia().save(this);
	}

	public Integer getNroOrdenDeCompra() {
		return nroOrdenDeCompra;
	}

	public void setNroOrdenDeCompra(Integer nroOrdenDeCompra) {
		this.nroOrdenDeCompra = nroOrdenDeCompra;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public int getCantidadXcomprar() {
		return cantidadXcomprar;
	}

	public void setCantidadXcomprar(int cantidadXcomprar) {
		this.cantidadXcomprar = cantidadXcomprar;
	}

	public EstadoOC getEstado() {
		return estado;
	}

	public void setEstado(EstadoOC estado) {
		this.estado = estado;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public int getCantidadReservada() {
		return cantidadReservada;
	}

	public void setCantidadReservada(int cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}

	public OrdenDeCompraDTO toDTO() {
		
		OrdenDeCompraDTO OCDTO = new OrdenDeCompraDTO();
		
		OCDTO.setCantidadReservada(this.cantidadReservada);
		OCDTO.setCantidadXcomprar(this.cantidadXcomprar);
		OCDTO.setEstado(this.estado);
		OCDTO.setFechaRecepcion(this.fechaRecepcion);
		OCDTO.setNroOrdenDeCompra(this.nroOrdenDeCompra);
		OCDTO.setFechaCreacion(this.fechaCreacion);
		OCDTO.setArticuloDTO(this.articulo.toDTO());
		return OCDTO;
		}
		
	}
