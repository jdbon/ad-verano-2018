package negocio;

public class ItemPedido {
	
	private Articulo articulo;
	private Integer cantidadSolicitada;
	private Integer cantidadReservada;
	private float subTotal;
	
	public ItemPedido() {
		super();
		
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
