package entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="remitos")
public class RemitoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rem_id")
	private int nroRemito;
	@Column(name="rem_fec")
	private Date fecha;
	@OneToOne
	@JoinColumn(name="rem_ped")
	private PedidoEntity pedido;
	@OneToMany
	@JoinColumn(name="")
	private List<ItemRemitoEntity> items;

	public RemitoEntity() {
		
	}

	public int getNroRemito() {
		return nroRemito;
	}

	public void setNroRemito(int nroRemito) {
		this.nroRemito = nroRemito;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public PedidoEntity getPedido() {
		return pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public List<ItemRemitoEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemRemitoEntity> items) {
		this.items = items;
	}
	
	

}
