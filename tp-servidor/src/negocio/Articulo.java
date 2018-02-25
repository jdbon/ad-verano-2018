package negocio;

import java.util.*;

import dao.ArticuloDAO;
import dao.OrdenDeCompraDAO;
import enumerator.EstadoOC;
import dto.ArticuloDTO;
import dto.LoteDTO;
import dto.OrdenDeCompraDTO;
import enumerator.Presentacion;
import enumerator.TipoMovimiento;
import excepcion.ArticuloException;
import excepcion.OrdenDeCompraException;

public class Articulo {

	private int codigoBarra;
	private String descripcion;
	private Presentacion presentacion;
	private int tama�o;
	private int unidad;
	private float precioVenta;
	private int cantidadOrdenDeCompra;
	private List<Lote> lotes;
	private int cantidadReservada;
	private List<Movimiento> movimientos;
	private List<OrdenDeCompra> ordenes;

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

	public Integer getTama�o() {
		return tama�o;
	}

	public void setTama�o(Integer tama�o) {
		this.tama�o = tama�o;
	}

	public Integer getUnidad() {
		return unidad;
	}

	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getCantidadOrdenDeCompra() {
		return cantidadOrdenDeCompra;
	}

	public void setCantidadOrdenDeCompra(int cantidadOrdenDeCompra) {
		this.cantidadOrdenDeCompra = cantidadOrdenDeCompra;
	}

	public int getCantidadReservada() {
		return cantidadReservada;
	}

	public void setCantidadReservada(int cantidadReservada) {
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
		result = prime * result + Float.floatToIntBits(precioVenta);
		result = prime * result + ((presentacion == null) ? 0 : presentacion.hashCode());
		result = prime * result + tama�o;
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
		if (Float.floatToIntBits(precioVenta) != Float.floatToIntBits(other.precioVenta))
			return false;
		if (presentacion != other.presentacion)
			return false;
		if (tama�o != other.tama�o)
			return false;
		if (unidad != other.unidad)
			return false;
		return true;
	}

	public boolean calcularStock(int cantidadSolicitada) throws ArticuloException, OrdenDeCompraException {
		
		int cantLibre = 0;
		int cantFaltante = 0;
		int sumaMovimientos = 0;
		int cantidadOC = 0;
		int cantParaPedir = 0;
		boolean resultado = true;
		for(Movimiento movimiento: this.movimientos){
			if (movimiento.tipo == TipoMovimiento.Alta){
				sumaMovimientos = sumaMovimientos + movimiento.getCantidad();
			}else{
				sumaMovimientos = sumaMovimientos - movimiento.getCantidad();
			}
		}
		cantLibre = sumaMovimientos - this.cantidadReservada;
		if (cantLibre <  cantidadSolicitada & cantLibre > 0){
			cantFaltante = cantidadSolicitada - cantLibre;
			cantParaPedir = (int) Math.ceil(this.cantidadOrdenDeCompra%cantFaltante);
			for (int i=1; i>cantParaPedir ;i++){
				if (i==cantParaPedir){
					this.generarOC(this, cantFaltante);
				}
				this.generarOC(this, this.cantidadOrdenDeCompra);
			}
			resultado = false;
		}else{
			for (OrdenDeCompra oc: this.ordenes){
				if(oc.getEstado() == EstadoOC.Pendiente){
					cantidadOC = cantidadOC + (oc.getCantidadXcomprar() - oc.getCantidadReservada());
				}
			}
		}
		ArticuloDAO.getInstancia().update(this);
		this.cantidadReservada = this.cantidadReservada + cantidadSolicitada;
		return resultado;
	}

	private void generarOC(Articulo articulo, int cantReservada) throws OrdenDeCompraException {
	
		OrdenDeCompra oC = new OrdenDeCompra(articulo, cantReservada);
		this.ordenes.add(oC);
		OrdenDeCompraDAO.getInstancia().save(oC);
		
	}

public ArticuloDTO toDTO() {
		
		ArticuloDTO ArDTO = new ArticuloDTO();
		
		ArDTO.setCantidadOrdenDeCompra(this.cantidadOrdenDeCompra);
		ArDTO.setCantidadReservada(this.cantidadReservada);
		ArDTO.setCodigoBarra(this.codigoBarra);
		ArDTO.setDescripcion(this.descripcion);
		ArDTO.setPrecioVenta(this.precioVenta);
		ArDTO.setPresentacion(this.presentacion);
		ArDTO.setTama�o(this.tama�o);
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
