package test;

import java.sql.Date;
import java.time.LocalDate;

import excepcion.ClienteException;
import excepcion.PedidoException;
import negocio.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// prueba enzo
		
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
		
		Pedido ped1 = new Pedido();
		Pedido ped2 = new Pedido();
		
		ped1.setDireccion("lima 1");
		ped1.setEstado(EstadoPedido.Pendiente);
		ped1.setFechaCreacion(Date.valueOf(LocalDate.now()));
		
		
		ped2.setDireccion("lima 2");
		ped2.setEstado(EstadoPedido.Pendiente);
		ped2.setFechaCreacion(Date.valueOf(LocalDate.now()));
		

		
		try {
			ped1.save();
			System.out.println("Grabo el primer pedido");
		} catch (PedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ped2.save();
			System.out.println("Grabo el segundo pedido");
		} catch (PedidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
	}

}
