package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.ClienteEntity;
import excepcion.ClienteException;
import hibernate.HibernateUtil;
import negocio.Cliente;

public class ClienteDAO {
	
	private static ClienteDAO instancia;
	
	private ClienteDAO(){
		
	}
	
	public static ClienteDAO getInstancia(){
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
		ce.setTipoFactura(cli.getTipoFactura());
		return ce;
	}
	
	public Cliente toNegocio(ClienteEntity ce){
		Cliente cli = new Cliente();
		cli.setidCliente(ce.getidCliente());
		cli.setApellido(ce.getApellido());
		cli.setNombre(ce.getNombre());
		cli.setLimiteCredito(ce.getLimiteCredito());
		cli.setSaldoActual(ce.getSaldoActual());
		cli.setTipoFactura(ce.getTipoFactura());
		return cli;
	}

	public Cliente findByID(int idCliente) throws ClienteException {
		
		Cliente resultado;
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		ClienteEntity auxCliente = (ClienteEntity) s.createQuery("From ClienteEntity c where c.idCliente = ?").setInteger(0, idCliente).uniqueResult();
		s.close();
		if(auxCliente == null) {
			System.out.println("el idCliente es = "+ idCliente);
				throw new ClienteException("No existe un cliente con el id " + idCliente);
		}
		resultado = this.toNegocio(auxCliente);
		return resultado;
	}
	
	public void save(Cliente cli) throws  ClienteException{
		ClienteEntity ce = this.toEntity(cli);
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		try {
		s.save(ce);
		s.getTransaction().commit();
		} catch (Exception e) {
			s.getTransaction().rollback();
			throw new ClienteException("Error al grabar cliente, o cliente " + ce.getidCliente() + " ya existe.");
		}
		s.close();
		
	}
}
