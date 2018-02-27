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
