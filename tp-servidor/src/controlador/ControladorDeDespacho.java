package controlador;

public class ControladorDeDespacho {

	private static ControladorDeDespacho instancia;
	
	private ControladorDeDespacho(){}
	
	public static ControladorDeDespacho getInstancia(){
		if(instancia == null)
			instancia = new ControladorDeDespacho();
		return instancia;
	}
}
