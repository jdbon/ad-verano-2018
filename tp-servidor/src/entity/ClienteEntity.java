package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import enumerator.TipoFactura;

@Entity
@Table(name="clientes")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cli_id")
	private Integer idCliente;
	@Column(name="cli_apellido")
	private String apellido;
	@Column(name="cli_nombre")
	private String nombre;


	@Column(name="cli_limite_credito")
	private float limiteCredito;
	@Column(name="cli_saldo_actual")
	private float saldoActual;
	@Column(name="cli_tfa")
	@Enumerated(EnumType.STRING)
	private TipoFactura tipoFactura;
	
	//private List<FacturaEntity> facturasEntity;
	
	public ClienteEntity() {
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
/*
	public List<FacturaEntity> getFacturasEntity() {
		return facturasEntity;
	}

	public void setFacturasEntity(List<FacturaEntity> facturasEntity) {
		this.facturasEntity = facturasEntity;
	}
*/

}
