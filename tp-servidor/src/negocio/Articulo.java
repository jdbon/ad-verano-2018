package negocio;

import java.util.*;

import dto.ArticuloDTO;
import dto.LoteDTO;
import dto.OrdenDeCompraDTO;
import enumerator.Presentacion;

public class Articulo {

	private int codigoBarra;
	private String descripcion;
	private Presentacion presentacion;
	private int tamaño;
	private int unidad;
	private Float precioVenta;
	private int cantidadOrdenDeCompra;
	private List<Lote> lotes;
	private int cantidadReservada;
	private List<Movimiento> movimientos;

	public Articulo() {
		super();
		lotes = new ArrayList<Lote>();
		movimientos = new ArrayList<Movimiento>();
	}

	public Integer getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(Integer codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Presentacion getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

	public Integer getTamaño() {
		return tamaño;
	}

	public void setTamaño(Integer tamaño) {
		this.tamaño = tamaño;
	}

	public Integer getUnidad() {
		return unidad;
	}

	public void setUnidad(Integer unidad) {
		this.unidad = unidad;
	}

	public Float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(Float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Integer getCantidadOrdenDeCompra() {
		return cantidadOrdenDeCompra;
	}

	public void setCantidadOrdenDeCompra(Integer cantidadOrdenDeCompra) {
		this.cantidadOrdenDeCompra = cantidadOrdenDeCompra;
	}

	public Integer getCantidadReservada() {
		return cantidadReservada;
	}

	public void setCantidadReservada(Integer cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	
	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}

	public List<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidadOrdenDeCompra;
		result = prime * result + cantidadReservada;
		result = prime * result + codigoBarra;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((lotes == null) ? 0 : lotes.hashCode());
		result = prime * result + ((movimientos == null) ? 0 : movimientos.hashCode());
		result = prime * result + ((precioVenta == null) ? 0 : precioVenta.hashCode());
		result = prime * result + ((presentacion == null) ? 0 : presentacion.hashCode());
		result = prime * result + tamaño;
		result = prime * result + unidad;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		if (cantidadOrdenDeCompra != other.cantidadOrdenDeCompra)
			return false;
		if (cantidadReservada != other.cantidadReservada)
			return false;
		if (codigoBarra != other.codigoBarra)
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (lotes == null) {
			if (other.lotes != null)
				return false;
		} else if (!lotes.equals(other.lotes))
			return false;
		if (movimientos == null) {
			if (other.movimientos != null)
				return false;
		} else if (!movimientos.equals(other.movimientos))
			return false;
		if (precioVenta == null) {
			if (other.precioVenta != null)
				return false;
		} else if (!precioVenta.equals(other.precioVenta))
			return false;
		if (presentacion != other.presentacion)
			return false;
		if (tamaño != other.tamaño)
			return false;
		if (unidad != other.unidad)
			return false;
		return true;
	}

public ArticuloDTO toDTO() {
		
		ArticuloDTO ArDTO = new ArticuloDTO();
		
		ArDTO.setCantidadOrdenDeCompra(this.cantidadOrdenDeCompra);
		ArDTO.setCantidadReservada(this.cantidadReservada);
		ArDTO.setCodigoBarra(this.codigoBarra);
		ArDTO.setDescripcion(this.descripcion);
		ArDTO.setPrecioVenta(this.precioVenta);
		ArDTO.setPresentacion(this.presentacion);
		ArDTO.setTamaño(this.tamaño);
		ArDTO.setUnidad(this.unidad);

			List<LoteDTO> auxLOTEDTO = new ArrayList<LoteDTO>();
			for (Lote lote : this.lotes) {
				auxLOTEDTO.add(lote.toDTO());
			}
		
		ArDTO.setLotesDTO(auxLOTEDTO);
		
		//falta transformar en DTO movimientos
		
		return ArDTO;
			
		
		}
	
	
	

}
