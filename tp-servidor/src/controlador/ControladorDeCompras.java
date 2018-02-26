package controlador;

import java.util.ArrayList;
import java.util.List;
import dao.OrdenDeCompraDAO;
import dao.PedidoDAO;
import dto.LoteDTO;
import dto.OrdenDeCompraDTO;
import dto.PedidoDTO;
import enumerator.EstadoOC;
import enumerator.EstadoPedido;
import excepcion.OrdenDeCompraException;
import excepcion.PedidoException;
import negocio.OrdenDeCompra;
import negocio.Pedido;


public class ControladorDeCompras {

	private static ControladorDeCompras instancia;
	
	private ControladorDeCompras(){}
	
	public static ControladorDeCompras getInstancia(){
		if(instancia == null)
			instancia = new ControladorDeCompras();
		return instancia;
	}
	
	
	//Devuelve todas las OC que estan en estado PENDIENTE
public List<OrdenDeCompraDTO> buscarOCPendientes() throws OrdenDeCompraException{
		
		List<OrdenDeCompra> OC_pen = OrdenDeCompraDAO.getInstancia().getPendientes(); 			
		List<OrdenDeCompraDTO> OC_pen_DTO = new ArrayList<OrdenDeCompraDTO>();
		for (OrdenDeCompra OC : OC_pen) {
			OC_pen_DTO.add(OC.toDTO());  
		}
		
		return OC_pen_DTO;
	}


public void recibirOCPendiente (OrdenDeCompraDTO odc, LoteDTO lote) throws OrdenDeCompraException {
	
		OrdenDeCompra OC;
		OC = OrdenDeCompraDAO.getInstancia().findById(odc.getNroOrdenDeCompra());
		if (OC.getEstado() == EstadoOC.Cumplida){
			
			throw new OrdenDeCompraException("La OC ya fue recibida anteriormente.");
		
		}else{
			
			OC.setEstado(EstadoOC.Cumplida);
			OrdenDeCompraDAO.getInstancia().update(OC);
		}
		
		ControladorDeDeposito.getInstancia();  //FALTA COMPLETAR CON EL METODO DE DEPOSITO
		
		
	}
}
