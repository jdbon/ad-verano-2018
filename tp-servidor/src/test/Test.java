package test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import controlador.ControladorDeDespacho;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dto.PedidoDTO;
import enumerator.TipoFactura;
import excepcion.ClienteException;
import excepcion.FacturaException;
import excepcion.PedidoException;
import negocio.*;

public class Test {

	public static void main(String[] args) {
		
		//CargaDeDatos.cargarClientes();
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
		
		
			
			try {
				List<PedidoDTO> pendientes = ControladorDeDespacho.getInstancia().buscarPedidosPendiente();
				System.out.println("Pedidos Pendientes:");
				System.out.println("Cliente: "+ pendientes.get(0).getNombreCliente());
				System.out.println("Cliente: "+ pendientes.get(0).getEstado());
				
			
			} catch (PedidoException e) {
				e.printStackTrace();
			}
		

		
		
	}

}

