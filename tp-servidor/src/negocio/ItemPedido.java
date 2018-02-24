package negocio;

import dao.ArticuloDAO;
import dto.ItemPedidoDTO;
import excepcion.ArticuloException;

public class ItemPedido {
	
	private Articulo articulo;
	private Integer cantidadSolicitada;
	private Integer cantidadReservada;
	private float subTotal; 
	
	public ItemPedido(Integer art, int cant) throws ArticuloException {
		Articulo articulo = ArticuloDAO.getInstancia().findByID(art);
		this.articulo = articulo;
		this.cantidadSolicitada = cant;
	}
	
	public ItemPedidoDTO toDTO () { //completar
		
		return null;
	}
	
	public Articulo getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	public Integer getCantidadReservada() {
		return cantidadReservada;
	}
	public void setCantidadReservada(Integer cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	
	

}
