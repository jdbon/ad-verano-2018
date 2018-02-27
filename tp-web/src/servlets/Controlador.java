package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import delegado.BusinessDelegate;
import dto.ArticuloDTO;
import dto.ItemPedidoDTO;
import dto.PedidoDTO;
import excepcion.ArticuloException;
import excepcion.ClienteException;
import excepcion.ItemPedidoException;
import excepcion.PedidoException;
import excepcion.SistemaException;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controlador() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("accion");
        String jspPage = "/index.jsp";
        
        if("traerArticulos".equals(action)){
        	
        	//PRIMERO: LLegan la lista de articulos
    		List<ArticuloDTO> articulosDTO = new ArrayList<ArticuloDTO>();
    		try {
    			
    			articulosDTO = BusinessDelegate.getInstancia().getAllArticulos();
    			for(ArticuloDTO aDTO : articulosDTO){
    				System.out.println(aDTO.toString());
    			}
    		} catch (PedidoException | SistemaException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
    		
    		//System.out.println("cant art: " + articulosDTO.size());
    		
    		request.setAttribute("articulosDTO", articulosDTO);
            jspPage = "/MostrarArticulos.jsp";	
        }
        else if("pedidoCliente".equals(action)){
        	
        	List<ItemPedidoDTO> itemsTemp = new ArrayList<ItemPedidoDTO>();
        	int idCliente = Integer.valueOf(request.getParameter("nroCliente"));
        	String direccion = request.getParameter("direccion");
        	int totalArticulos = 7;

        	for(int a=1; a < totalArticulos+1; a++){
	
        		int codigoArticulo = Integer.valueOf(request.getParameter("codigoBarra"+String.valueOf(a)));
        		int cantidadIngresada = Integer.valueOf(request.getParameter("cantidad"+String.valueOf(a)));
        		System.out.println("codigoArt, cant: " + codigoArticulo + ", " + cantidadIngresada); 
        		ArticuloDTO aDTO = new ArticuloDTO();
        		aDTO.setCodigoBarra(codigoArticulo);
        		
        		ItemPedidoDTO ipDTO = new ItemPedidoDTO();
        		ipDTO.setArticulo(aDTO);
        		ipDTO.setCantidadSolicitada(cantidadIngresada);
        		itemsTemp.add(ipDTO);
        	}
        	List<ItemPedidoDTO> items = new ArrayList<ItemPedidoDTO>();
        	for(ItemPedidoDTO ipDTO2 : itemsTemp){
        		if(ipDTO2.getCantidadSolicitada() > 0)
        			items.add(ipDTO2);
        	}

        	int nroPedido = 0;
			try {
				nroPedido = BusinessDelegate.getInstancia().generarNuevoPedido(idCliente, direccion, items);
			} catch (PedidoException | ClienteException | ArticuloException | ItemPedidoException
					| SistemaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//        	String codigoBarra1 = request.getParameter("codigoBarra1");
//        	String cantidad1 = request.getParameter("cantidad1");
//        	System.out.println("Servlet: idcliente, direccion, cod, cant --> " 
//        			+ idCliente + ", " + direccion + ", "+ codigoBarra1 + ", " + cantidad1);

        	
        	request.setAttribute("nroPedido", nroPedido);
            jspPage = "/darNroPedido.jsp";	
        	
        }
        else if("statusPedido".equals(action)){
        	int nroPedido = Integer.valueOf(request.getParameter("nroPed"));

        	PedidoDTO pDTO;
        	String status = null;
        	try {
        		pDTO = BusinessDelegate.getInstancia().obtenerEstadoPedido(nroPedido);
				System.out.println("Estado pedido: " + pDTO.getEstado().toString());
				status = pDTO.getEstado().toString();
				
			} catch (PedidoException | SistemaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	request.setAttribute("elEstadoEs", status);
        	jspPage = "/statusPedido.jsp";
        }
        dispatch(jspPage, request, response);
        
	}

	private void dispatch(String jspPage, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (jspPage != null)
        {
            RequestDispatcher rd = request.getRequestDispatcher(jspPage);
            rd.forward(request, response);
        }
    }
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
