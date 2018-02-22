package dao;

import entity.ClienteEntity;
import negocio.Cliente;

public class ClienteDAO {
	
	private static ClienteDAO instancia;
	
	private ClienteDAO(){
		
	}
	
	public ClienteDAO getInstancia(){
		if(instancia == null)
			instancia = new ClienteDAO();
		return instancia;
	}
	
	public ClienteEntity toEntity(Cliente cli){
		ClienteEntity ce = new ClienteEntity();
		ce.setidCliente(cli.getidCliente());
		ce.setApellido(cli.getApellido());
		ce.setNombre(cli.getNombre());
		ce.setLimiteCredito(cli.getLimiteCredito());
		ce.setSaldoActual(cli.getSaldoActual());
		return ce;
	}
	
	public Cliente toNegocio(ClienteEntity ce){
		Cliente cli = new Cliente();
		cli.setidCliente(ce.getidCliente());
		cli.setApellido(ce.getApellido());
		cli.setNombre(ce.getNombre());
		cli.setLimiteCredito(ce.getLimiteCredito());
		cli.setSaldoActual(ce.getSaldoActual());
		return cli;
	}
}
