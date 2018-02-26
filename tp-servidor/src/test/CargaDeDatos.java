package test;

import java.sql.Date;
import java.time.LocalDate;

import enumerator.EstadoPedido;
import enumerator.Presentacion;
import enumerator.TipoFactura;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import excepcion.ItemPedidoException;
import excepcion.PedidoException;
import negocio.Articulo;
import negocio.Cliente;
import negocio.Pedido;

public class CargaDeDatos {
	
	public static void cargarClientes(){
						
				// prueba para insertar 2 clientes en la BD
				
				Cliente cli = new Cliente();
				Cliente cli2 = new Cliente();
				
				cli.setApellido("PEREZ");
				cli.setNombre("CARLOS");
				cli.setLimiteCredito(4000f);
				cli.setSaldoActual(3000f);
				cli.setTipoFactura(TipoFactura.A);
				
				
				cli2.setApellido("GOMEZ");
				cli2.setNombre("HECTOR");
				cli2.setLimiteCredito(4000f);
				cli2.setSaldoActual(3000f);
				cli2.setTipoFactura(TipoFactura.B);
				
				try {
					cli.save();
					cli2.save();
					
				} catch (ClienteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// prueba para insertar un pedido asociado a cliente en la BD
	}
	
	public static void cargarArticulos(){
		Articulo art1 = new Articulo();
		art1.setCantidadOrdenDeCompra(15);
		art1.setCantidadReservada(0);
		art1.setDescripcion("Atún");
		art1.setPrecioVenta((float) 10.7);
		art1.setPresentacion(Presentacion.LATAS);
		art1.setTamaño(2);
		art1.setUnidad(1);
		
		Articulo art2 = new Articulo();
		art2.setCantidadOrdenDeCompra(22);
		art2.setCantidadReservada(0);
		art2.setDescripcion("Polenta");
		art2.setPrecioVenta((float) 5.25);
		art2.setPresentacion(Presentacion.PAQUETE);
		art2.setTamaño(3);
		art2.setUnidad(1);
		
		try {
			art1.save();
			art2.save();
			
		} catch (ArticuloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
