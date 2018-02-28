package negocio;

import dao.MovimientoDAO;

public class MovimientoAB extends Movimiento{

	public MovimientoAB() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		
		return "MovAB: " + this.getNroMovimiento() + " - Tipo: " + this.getTipo() + " - Cant: " + 
				this.getCantidad();
	}

	public void save() {
		MovimientoDAO.getInstancia().save(this);
		
	}
	
	
	
	

}

	


