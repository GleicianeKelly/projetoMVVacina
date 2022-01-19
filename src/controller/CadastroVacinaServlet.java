package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vacina;
import service.PacienteService;
import service.VacinaService;

/**
 * Servlet implementation class CadastroVacinaServlet
 */
@WebServlet("/CadastroVacinaServlet")
public class CadastroVacinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroVacinaServlet() {
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
			vacina.setNome_vacina(request.getParameter("nomeVacina"));
			vacina.setMarca(request.getParameter("marcaVacina"));		
			vacinaBean.save(vacina);
			response.sendRedirect("listarVacina.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
