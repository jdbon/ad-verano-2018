package test;

import excepcion.ClienteException;
import negocio.Cliente;
import negocio.TipoFactura;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// prueba enzo
		
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
		
	}

}
