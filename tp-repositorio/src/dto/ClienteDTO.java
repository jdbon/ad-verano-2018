package dto;

import java.io.Serializable;

import enumerator.TipoFactura;


public class ClienteDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8655239895983395351L;
	
	private Integer idCliente;
	private String apellido;
	private String nombre;
	private float limiteCredito;
	private float saldoActual;
	private TipoFactura tipoFactura;	

	public ClienteDTO() {
	
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
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
	
	

}
