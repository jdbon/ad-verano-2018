package vista;

import java.util.List;

import delegado.BusinessDelegate;
import dto.PedidoDTO;
import excepcion.PedidoException;
import excepcion.SistemaException;

public class Test1Despacho {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			List<PedidoDTO> pedPend = BusinessDelegate.getInstancia().buscarPedidosPendiente();
			System.out.println("pedPendd: " + pedPend.size());
			for(PedidoDTO pdto : pedPend){
				System.out.println(pdto.getClienteDTO().getApellido());
			}
		} catch (PedidoException | SistemaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		}

	}

}
