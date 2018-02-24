package entity;

import javax.persistence.*;

import enumerator.Bloque;
import enumerator.Calle;
import enumerator.Estanteria;
import enumerator.Posicion;

@Entity
@Table(name="ubicaciones")
public class UbicacionEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ubi_id")
	private Integer idUbicacion;
	
	@Column(name="ubi_tca")
	private int cantidadActual;
	
	@OneToOne
	@JoinColumn(name="ubi_art")
	private ArticuloEntity articulo;
	
	@Column(name="ubi_cod")
	private String codigo;
	
	private Calle calle;
	private Bloque bloque;
	private Estanteria estanteria;
	private Posicion posicion;

	public UbicacionEntity() {
		
	}

	public Integer getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(Integer idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
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
