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
 * Servlet implementation class EditarVacinaServlet
 */
@WebServlet("/EditarVacinaServlet")
public class EditarVacinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarVacinaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Vacina vacina = new Vacina();
		
		VacinaService vacinaBean = null;
		try {
			vacinaBean = new VacinaService();
			
			vacina.setId_vacina(Integer.parseInt(request.getParameter("id_codigo")));
			vacina.setNome_vacina(request.getParameter("nome_vacina"));
			vacina.setMarca(request.getParameter("marca"));
			
			vacinaBean.update(vacina);
			response.sendRedirect("listarVacina.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
