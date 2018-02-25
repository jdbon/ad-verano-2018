package controlador;

import java.util.ArrayList;
import java.util.List;
import dao.OrdenDeCompraDAO;
import dto.OrdenDeCompraDTO;
import excepcion.OrdenDeCompraException;
import negocio.OrdenDeCompra;


public class ControladorDeCompras {

	private static ControladorDeCompras instancia;
	
	private ControladorDeCompras(){}
	
	public static ControladorDeCompras getInstancia(){
		if(instancia == null)
			instancia = new ControladorDeCompras();
		return instancia;
	}
	
	
public List<OrdenDeCompraDTO> buscarOCPendientes() throws OrdenDeCompraException{
		
		List<OrdenDeCompra> OC_pen = OrdenDeCompraDAO.getInstancia().getPendientes();  
		List<OrdenDeCompraDTO> OC_pen_DTO = new ArrayList<OrdenDeCompraDTO>();
		for (OrdenDeCompra OC : OC_pen) {
			OC_pen_DTO.add(OC.toDTO()); 
		}
		
		return OC_pen_DTO;
	}
	
}
