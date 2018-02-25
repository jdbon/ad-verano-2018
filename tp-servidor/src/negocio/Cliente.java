package negocio;

import dao.ClienteDAO;
import dto.ClienteDTO;
import enumerator.TipoFactura;
import excepcion.ClienteException;

public class Cliente {
	
	private int idCliente;
	private String apellido;
	private String nombre;
	private float limiteCredito;
	private float saldoActual;
	private TipoFactura tipoFactura;
	
	public Cliente() {
		super();
		
	}
	
	

	public Integer getidCliente() {
		return idCliente;
	}

	public void setidCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public float getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(float saldoActual) {
		this.saldoActual = saldoActual;
	}

	public TipoFactura getTipoFactura() {
		return tipoFactura;
	}

	public void setTipoFactura(TipoFactura tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public void save() throws ClienteException {
		ClienteDAO.getInstancia().save(this);
		
	}
	
	
	public ClienteDTO toDTO() {
		
		ClienteDTO cliDTO = new ClienteDTO();
		
		cliDTO.setApellido(this.apellido);
		cliDTO.setIdCliente(this.idCliente);
		cliDTO.setLimiteCredito(this.limiteCredito);
		cliDTO.setNombre(this.nombre);
		cliDTO.setSaldoActual(this.saldoActual);
		cliDTO.setTipoFactura(this.tipoFactura);
				
		return cliDTO;
		
	}
	
	
	

}
