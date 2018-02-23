package entity;

import negocio.Bloque;
import negocio.Calle;
import negocio.Estanteria;
import negocio.Posicion;

public class UbicacionEntity {
	
	private static int cantidadActual;
	private ArticuloEntity articulo;
	private String codigo;
	private Calle calle;
	private Bloque bloque;
	private Estanteria estanteria;
	private Posicion posicion;

	public UbicacionEntity() {
		
	}

	public static int getCantidadActual() {
		return cantidadActual;
	}

	public static void setCantidadActual(int cantidadActual) {
		UbicacionEntity.cantidadActual = cantidadActual;
	}

	public ArticuloEntity getArticulo() {
		return articulo;
	}

	public void setArticulo(ArticuloEntity articulo) {
		this.articulo = articulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Calle getCalle() {
		return calle;
	}

	public void setCalle(Calle calle) {
		this.calle = calle;
	}

	public Bloque getBloque() {
		return bloque;
	}

	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}

	public Estanteria getEstanteria() {
		return estanteria;
	}

	public void setEstanteria(Estanteria estanteria) {
		this.estanteria = estanteria;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	

}
