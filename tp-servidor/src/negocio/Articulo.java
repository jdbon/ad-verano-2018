package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.ArticuloDAO;
import dao.OrdenDeCompraDAO;
import dao.PedidoDAO;
import dto.ArticuloDTO;
import dto.LoteDTO;
import dto.MovimientoDTO;
import enumerator.EstadoOC;
import enumerator.Presentacion;
import enumerator.TipoMovimiento;
import excepcion.ArticuloException;
import excepcion.OrdenDeCompraException;
import excepcion.PedidoException;

public class Articulo {

	private int codigoBarra;
	private String descripcion;
	private Presentacion presentacion;
	private int tamaño;
	private int unidad;
	private float precioVenta;
	private int cantidadOrdenDeCompra;
	private List<Lote> lotes;
	private int cantidadReservada;
	private List<Movimiento> movimientos;
	private List<OrdenDeCompra> ordenes;

	public Articulo() {
		lotes = new ArrayList<Lote>();
		movimientos = new ArrayList<Movimiento>();
		ordenes = new ArrayList<OrdenDeCompra>();
	}

	public int getCodigoBarra() {
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

	public int getTamaño() {
		return tamaño;
	}

	public void setTamaño(Integer tamaño) {
		this.tamaño = tamaño;
	}

	public int getUnidad() {
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
		if (Float.floatToIntBits(precioVenta) != Float.floatToIntBits(other.precioVenta))
			return false;
		if (presentacion != other.presentacion)
			return false;
		if (tamaño != other.tamaño)
			return false;
		if (unidad != other.unidad)
			return false;
		return true;
	}
	
	

	public boolean calcularStock(int cantidadSolicitada) throws ArticuloException, OrdenDeCompraException {
		
		int cantLibre = 0;
		int cantFaltante = 0;
		int sumaMovimientos = 0;
		int cantParaPedir = 0;
		boolean resultado = true;
		for(Movimiento movimiento: this.movimientos){
			if (movimiento.tipo == TipoMovimiento.ALTA){
				sumaMovimientos = sumaMovimientos + movimiento.getCantidad();
			}else{
				sumaMovimientos = sumaMovimientos - movimiento.getCantidad();
			}
		}
		cantLibre = sumaMovimientos - this.cantidadReservada;
		if (cantLibre <  cantidadSolicitada & cantLibre >= 0){
			cantFaltante = cantidadSolicitada - cantLibre;
			cantParaPedir = (int) Math.ceil(cantFaltante/this.cantidadOrdenDeCompra);
			for (int i = 1; i > cantParaPedir ; i++){
				if (i == cantParaPedir){
					this.generarOC(cantFaltante);
					cantFaltante = 0;
				}
				this.generarOC(this.cantidadOrdenDeCompra);
				cantFaltante = cantFaltante - this.cantidadOrdenDeCompra;
			}
			this.cantidadReservada = this.cantidadReservada + cantidadSolicitada;
			resultado = false;
		}else{
			if (cantLibre > cantidadSolicitada){
				this.cantidadReservada = this.cantidadReservada - cantidadSolicitada;
			}else{
				cantFaltante = cantidadSolicitada;
				for (OrdenDeCompra oc: this.ordenes){
					if((oc.getCantidadXcomprar() - oc.getCantidadReservada()) > 0 
							& (oc.getCantidadXcomprar() - oc.getCantidadReservada()) >= cantidadSolicitada){
						oc.setCantidadReservada(oc.getCantidadReservada()+cantidadSolicitada);
						//update
						cantFaltante = 0;
					}else{
						if((oc.getCantidadXcomprar() - oc.getCantidadReservada()) > 0 
								& (oc.getCantidadXcomprar() - oc.getCantidadReservada()) < cantidadSolicitada){
							cantFaltante = cantidadSolicitada - (oc.getCantidadXcomprar() - oc.getCantidadReservada());
							oc.setCantidadReservada(oc.getCantidadReservada() + (cantidadSolicitada - cantFaltante));
							//update
						}
					}
				}
				if (cantFaltante > 0){
					cantParaPedir = (int) Math.ceil(cantFaltante/this.cantidadOrdenDeCompra);
					for (int i=1; i>cantParaPedir ;i++){
						if (i==cantParaPedir){
							this.generarOC(cantFaltante);
							cantFaltante = 0;
						}
						this.generarOC(this.cantidadOrdenDeCompra);
						cantFaltante = cantFaltante - this.cantidadOrdenDeCompra;
					}
				}
				this.cantidadReservada = this.cantidadReservada + cantidadSolicitada;
				resultado = false;
			}						
		}
		ArticuloDAO.getInstancia().updateValores(this);
		return resultado;
	}

	private void generarOC(int cantReservada) throws OrdenDeCompraException {
	
		OrdenDeCompra oC = new OrdenDeCompra(this, cantReservada);
		OrdenDeCompraDAO.getInstancia().save(oC);
		this.ordenes.add(oC);
		
	}
	
	public String toString(){
		return "Art ID: " + this.getCodigoBarra() + " - Desc: " + this.getDescripcion() + " - Precio V: " + 
	       this.getPrecioVenta() + " - Cant. OC: " + this.getCantidadOrdenDeCompra();
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
			for (Lote lote : lotes) {
				auxLOTEDTO.add(lote.toDTO());
			}
		
		ArDTO.setLotesDTO(auxLOTEDTO);
		
		
		List<MovimientoDTO> auxMOVDTO = new ArrayList<MovimientoDTO>();
		for (Movimiento movimiento : movimientos) { 
			auxMOVDTO.add(movimiento.toDTO()); 
		}
	
	ArDTO.setMovimientosDTO(auxMOVDTO);
		
		return ArDTO;
			
		
		}

	

}
