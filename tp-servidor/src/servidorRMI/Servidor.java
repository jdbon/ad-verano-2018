package servidorRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import interfaz.INegocio;
import objetoRemoto.ObjetoRemoto;

public class Servidor {

	public static void main(String[] args) {

		
		//System.setProperty("java.rmi.server.hostname", "10.0.2.15");
		
		
		try {
			System.setProperty("java.security.policy", "java.policy");  
			INegocio remoto;
			remoto = new ObjetoRemoto(); 
			LocateRegistry.createRegistry(1099);	
			Naming.rebind ("//localhost/ver", remoto);
			System.out.println("Fijado en //localhost/ver");
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
