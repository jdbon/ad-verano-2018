package controlador;

public class ControladorDeFacturacion {

	private static ControladorDeFacturacion instancia;
	
	private ControladorDeFacturacion(){}
	
	public static ControladorDeFacturacion getInstancia(){
		if(instancia == null)
			instancia = new ControladorDeFacturacion();
		return instancia;
	}
}
