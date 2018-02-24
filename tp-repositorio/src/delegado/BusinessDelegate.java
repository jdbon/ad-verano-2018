package delegado;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import excepcion.ComunicacionException;
import interfaz.IPedido;

public class BusinessDelegate {

	private IPedido referenciaRemota;
	private static BusinessDelegate instancia;
	
	private BusinessDelegate() throws ComunicacionException {
		try {
			referenciaRemota = (IPedido) Naming.lookup("//127.0.0.1/AdmPedidos");
		} catch (MalformedURLException e2) {
			throw new ComunicacionException("La ubicacion del servidor es incorrecta.");
		} catch (RemoteException e2) {
			throw new ComunicacionException("Se produjo un error en la comunicacion.");
		} catch (NotBoundException e2) {
			throw new ComunicacionException("No encontre a nadie que me responda.");
		}
	}
	
	public static BusinessDelegate getInstancia() throws ComunicacionException {
		if(instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}
	
	public int crearCuenta() throws ComunicacionException {
		try {
			return referenciaRemota.crearPedido();
		} catch (RemoteException e) {
			throw new ComunicacionException("Se produjo un error en la comunicacion.");
		}
	}
	
	
	
	
	
}
