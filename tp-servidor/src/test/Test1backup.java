package test;

import java.sql.Date;
import java.time.LocalDate;

import dao.ClienteDAO;
import dao.PedidoDAO;
import enumerator.TipoFactura;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import excepcion.FacturaException;
import excepcion.PedidoException;
import negocio.*;

public class Test1backup {

	public static void main(String[] args) throws ArticuloException {
		
		CargaDeDatos.cargarClientes();
		//CargaDeDatos.cargarPedidos();
		
		//Buscar cliente 1
		Cliente c1 = null;
		try {
			c1 = ClienteDAO.getInstancia().findByID(1);
		} catch (ClienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Buscar pedido 1
		Pedido p1 = null;
		try {
			p1 = PedidoDAO.getInstancia().findById(1);
		} catch (PedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Factura f = new Factura();
		f.setCliente(c1);
		f.setFecha(Date.valueOf(LocalDate.now()));
		f.setTipo(TipoFactura.B);
		f.setTotal(20000f);
		f.setPedido(p1);
		
		try {
			f.save();
			System.out.println("Se grabó la factura.");
		} catch (FacturaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		
		
	}

}

