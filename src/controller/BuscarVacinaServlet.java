package controller;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vacina;
import service.VacinaService;

/**
 * Servlet implementation class BuscarVacinaServlet
 */
@WebServlet("/BuscarVacinaServlet")
public class BuscarVacinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarVacinaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		Vacina vacina = new Vacina();
		String nome = request.getParameter("nomeVacina");
		
		VacinaService vs;
		try {
			vs = new VacinaService();
			vacina = vs.findByName(nome);
			request.setAttribute("vacina", vacina);
			RequestDispatcher d = request.getRequestDispatcher("BuscarVacina.jsp");
			d.forward(request, response);
			//formard leva tudo que trouxe
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
	}

}
