package controller;


import model.Paciente;
import service.PacienteService;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditarPaciente
 */
@WebServlet("/EditarPaciente")
public class EditarPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPacienteServlet() {
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
		
		Paciente paciente = new Paciente();
		//PacienteService pacienteBean = new PacienteService();
		PacienteService pacienteBean = null;
		try {
			pacienteBean = new PacienteService();
			
			
			paciente.setId_paciente(Integer.parseInt(request.getParameter("id_codigo")));
			paciente.setCpf(request.getParameter("cpf"));
			paciente.setNome_paciente(request.getParameter("nome_paciente"));
			paciente.setEndereco(request.getParameter("endereco"));
			pacienteBean.update(paciente);
			response.sendRedirect("listarPaciente.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
