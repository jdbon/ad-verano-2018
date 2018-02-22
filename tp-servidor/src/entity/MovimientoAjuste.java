package entity;

public class MovimientoAjuste extends MovimientoEntity {
	
	private String encargado;
	private String autorizadoPor;
	private String destinoArticulos;

	public MovimientoAjuste() {
		
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
