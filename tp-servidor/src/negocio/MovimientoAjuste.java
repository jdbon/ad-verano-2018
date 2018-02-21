package negocio;

public class MovimientoAjuste extends Movimiento{

	private String encargado;
	private String autorizadoPor;
	private String destinoArticulos;
	
	public MovimientoAjuste() {
		super();
		
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
