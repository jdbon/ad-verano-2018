package entity;



public class UbicacionEntity {
	
	private static int cantidadActual;
	private ArticuloEntity articulo;
	private String codigo;
	private CalleEntity calle;
	private BloqueEntity bloque;
	private EstanteriaEntity estanteria;
	private PosicionEntity posicion;

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

	public CalleEntity getCalle() {
		return calle;
	}

	public void setCalle(CalleEntity calle) {
		this.calle = calle;
	}

	public BloqueEntity getBloque() {
		return bloque;
	}

	public void setBloque(BloqueEntity bloque) {
		this.bloque = bloque;
	}

	public EstanteriaEntity getEstanteria() {
		return estanteria;
	}

	public void setEstanteria(EstanteriaEntity estanteria) {
		this.estanteria = estanteria;
	}

	public PosicionEntity getPosicion() {
		return posicion;
	}

	public void setPosicion(PosicionEntity posicion) {
		this.posicion = posicion;
	}
	
	

}
