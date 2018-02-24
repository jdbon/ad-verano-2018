package entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("MovimientoAjuste")
public class MovimientoAjusteEntity extends MovimientoEntity {
	@Column(name="mov_encargado")
	private String encargado;
	@Column(name="mov_autorizado")
	private String autorizadoPor;
	@Column(name="mov_destino")
	private String destinoArticulos;

	public MovimientoAjusteEntity() {
		
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getAutorizadoPor() {
		return autorizadoPor;
	}

	public void setAutorizadoPor(String autorizadoPor) {
		this.autorizadoPor = autorizadoPor;
	}

	public String getDestinoArticulos() {
		return destinoArticulos;
	}

	public void setDestinoArticulos(String destinoArticulos) {
		this.destinoArticulos = destinoArticulos;
	}
	
	

}
