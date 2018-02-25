package entity;

import javax.persistence.*;

import enumerator.Bloque;
import enumerator.Calle;
import enumerator.Estanteria;
import enumerator.Posicion;
import negocio.Lote;

@Entity
@Table(name="ubicaciones")
public class UbicacionEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ubi_id")//ok
	private Integer idUbicacion;
	
	@Column(name="ubi_tca")//ok
	private int cantidadActual;
	
	@OneToOne
	@JoinColumn(name="ubi_art")//ok
	private ArticuloEntity articulo;
	
	@Column(name="ubi_cod")//cod
	private String codigo;
	
	@Column(name="ubi_cal")//ok
	@Enumerated(EnumType.STRING)
	private Calle calle;
	
	@Column(name="ubi_blo")//ok
	@Enumerated(EnumType.STRING)
	private Bloque bloque;
	
	@Column(name="ubi_est")
	@Enumerated(EnumType.STRING)
	private Estanteria estanteria;
	
	@Column(name="ubi_pos")
	@Enumerated(EnumType.STRING)
	private Posicion posicion;
	
	@OneToOne
	@JoinColumn(name="ubi_lot")
	//@Column(name="ubi_lot")
	private Lote lote;

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
