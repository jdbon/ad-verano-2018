package negocio;

import dao.ArticuloDAO;
import dto.ItemPedidoDTO;
import excepcion.ArticuloException;

public class ItemPedido {
	
	private Articulo articulo;
	private int cantidadSolicitada;
	private int cantidadReservada;
	private float subTotal; 
	
	public ItemPedido(int art, int cant) throws ArticuloException {
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
	public int getCantidadSolicitada() {
		return cantidadSolicitada;
	}
	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}
	public int getCantidadReservada() {
		return cantidadReservada;
	}
	public void setCantidadReservada(int cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public boolean verificarStock() {
		
		return false; 
				//this.articulo.calcularStock(this.cantidadSolicitada));
	}
	
	

}
