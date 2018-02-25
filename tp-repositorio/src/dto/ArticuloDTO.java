package dto;

import java.util.List;

import enumerator.Presentacion;

public class ArticuloDTO {

	private int codigoBarra;
	private String descripcion;
	private Presentacion presentacion;
	private int tama�o;
	private int unidad;
	private Float precioVenta;
	private int cantidadOrdenDeCompra;
	private List<LoteDTO> lotesDTO;
	private int cantidadReservada;
	private List<MovimientoDTO> movimientosDTO;
	
	public ArticuloDTO() {}
	
	public int getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(int codigoBarra) {
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
	public int getTama�o() {
		return tama�o;
	}
	public void setTama�o(int tama�o) {
		this.tama�o = tama�o;
	}
	public int getUnidad() {
		return unidad;
	}
	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}
	public Float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(Float precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getCantidadOrdenDeCompra() {
		return cantidadOrdenDeCompra;
	}
	public void setCantidadOrdenDeCompra(int cantidadOrdenDeCompra) {
		this.cantidadOrdenDeCompra = cantidadOrdenDeCompra;
	}
	public List<LoteDTO> getLotesDTO() {
		return lotesDTO;
	}
	public void setLotesDTO(List<LoteDTO> lotesDTO) {
		this.lotesDTO = lotesDTO;
	}
	public int getCantidadReservada() {
		return cantidadReservada;
	}
	public void setCantidadReservada(int cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	public List<MovimientoDTO> getMovimientosDTO() {
		return movimientosDTO;
	}
	public void setMovimientosDTO(List<MovimientoDTO> movimientosDTO) {
		this.movimientosDTO = movimientosDTO;
	}
	
}
