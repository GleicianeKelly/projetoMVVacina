package controller;


import java.io.IOException;
import java.sql.SQLException;

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
	
		String nome = request.getParameter("nomeVacina");
		
		System.out.println(nome);
	
		try {
		VacinaService vacinaService = new VacinaService();
		Vacina vacina = vacinaService.findByName(nome);
		request.setAttribute("vacinaEncontrada", vacina);
		System.out.println(request.getContextPath());
		request.getRequestDispatcher(request.getContextPath() + "/../pages/listarNomeVacina.jsp").forward(request, response);
		
		response.sendRedirect("listarNomeVacina.jsp");
		System.out.println(vacina);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	}

}
