package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IPedido extends Remote {

	public abstract int crearPedido() throws RemoteException;
	
	
}
