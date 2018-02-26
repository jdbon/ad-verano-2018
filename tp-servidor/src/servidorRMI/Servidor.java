package servidorRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import interfaz.IPedido;
import objetoRemoto.ORPedido;

public class Servidor {

	public Servidor() {}
	
	public void publicar() {
		String url = "//127.0.0.1/AdmPedidos";
		IPedido objetoRemoto;
		try {
			LocateRegistry.createRegistry(1099);
			objetoRemoto = new ORPedido();
			Naming.rebind(url, objetoRemoto);
		} catch (RemoteException e) {
		
			e.printStackTrace();
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		System.out.println("Se arranco");
		
	}
}
