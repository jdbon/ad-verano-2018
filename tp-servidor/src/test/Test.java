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
		
		CargaDeDatos.cargarClientes();
		CargaDeDatos.cargarPedidos();
		
		//Buscar cliente 1
		Cliente c1 = null;
		try {
			c1 = ClienteDAO.getInstancia().findByID(1);
		} catch (ClienteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("antes del Try del test");
		//Buscar pedido 1
		Pedido p1 = null;
		try {
				//System.out.println("******hasta aca el pedido es null --> " +p1.getIdPedido());
			p1 = PedidoDAO.getInstancia().findById(1);
				System.out.println("******luego se recupera el pedido con idPedido de valor: " + p1.getIdPedido() + "para setearlo en la factura");
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
				
				System.out.println("");
				System.out.println("******************* PEDIDOS PENDIENTES ******************");
		
				System.out.println("Cliente: "+ pendientes.get(0).getNombreCliente());
				System.out.println("Estado: "+ pendientes.get(0).getEstado());
				System.out.println("Fecha de Creacion: "+ pendientes.get(0).getFechaCreacion());
				System.out.println("");
				System.out.println("********************************************************");
				
				System.out.println("Cliente: "+ pendientes.get(1).getNombreCliente());
				System.out.println("Estado: "+ pendientes.get(1).getEstado());
				System.out.println("Fecha de Creacion: "+ pendientes.get(1).getFechaCreacion());
				
							
			
			} catch (PedidoException e) {
				e.printStackTrace();
			}
		

		
	}

}

