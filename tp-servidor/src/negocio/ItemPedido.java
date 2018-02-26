package negocio;

import dao.ArticuloDAO;
import dao.ItemPedidoDAO;
import dto.ItemPedidoDTO;
import excepcion.ArticuloException;
import excepcion.ItemPedidoException;
import excepcion.OrdenDeCompraException;

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
	
	public ItemPedido() {}
	
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

	public boolean verificarStock() throws ArticuloException, OrdenDeCompraException, ItemPedidoException {
		
		if (this.articulo.calcularStock(this.cantidadSolicitada) == false){
			this.cantidadReservada = this.cantidadSolicitada;
			ItemPedidoDAO.getInstancia().update(this);
			return false;
		}
		return true;
	}

	public void save() throws ItemPedidoException, ArticuloException {
		ItemPedidoDAO.getInstancia().save(this);
	}
	
	

}
