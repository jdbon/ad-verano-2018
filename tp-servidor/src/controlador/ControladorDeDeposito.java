package controlador;

public class ControladorDeDeposito {

	private static ControladorDeDeposito instancia;
	
	private ControladorDeDeposito(){}
	
	public static ControladorDeDeposito getInstancia(){
		if(instancia == null)
			instancia = new ControladorDeDeposito();
		return instancia;
	}
}
