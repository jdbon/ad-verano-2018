package entity;

import java.util.List;

import javax.persistence.*;

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
	private Integer tipoFactura;
	
	//private List<FacturaEntity> facturasEntity;
	
	public ClienteEntity() {
		super();
		
	}

	public Integer getidCliente() {
		return idCliente;
	}

	public void setidCliente(Integer dni) {
		this.idCliente = dni;
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
/*
	public List<FacturaEntity> getFacturasEntity() {
		return facturasEntity;
	}

	public void setFacturasEntity(List<FacturaEntity> facturasEntity) {
		this.facturasEntity = facturasEntity;
	}
*/

}
