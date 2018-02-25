package controlador;

public class ControladorDeCompras {

	private static ControladorDeCompras instancia;
	
	private ControladorDeCompras(){}
	
	public static ControladorDeCompras getInstancia(){
		if(instancia == null)
			instancia = new ControladorDeCompras();
		return instancia;
	}
}
