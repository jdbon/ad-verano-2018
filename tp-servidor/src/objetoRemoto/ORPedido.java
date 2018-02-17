package objetoRemoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaz.IPedido;

public class ORPedido extends UnicastRemoteObject implements IPedido{

	private static final long serialVersionUID = -495314985530835474L;

	public ORPedido() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

}
