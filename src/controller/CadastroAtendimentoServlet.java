package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AtendimentoRequest;
import service.AtendimentoService;

/**
 * Servlet implementation class CadastroAtendimentoServlet
 */
@WebServlet("/CadastroAtendimentoServlet")
public class CadastroAtendimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroAtendimentoServlet() {
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
		
		System.out.println("Olá mundo");
		
		SimpleDateFormat format = new SimpleDateFormat();
		
		AtendimentoRequest atendimentoRequest = new AtendimentoRequest();
		
		AtendimentoService atendimentoBean = null;
		try {
			atendimentoBean = new AtendimentoService();
			atendimentoRequest.setCpf_paciente(request.getParameter("CPFPaciente"));
			atendimentoRequest.setNm_vacina(request.getParameter("NomeVacina"));	
			
			atendimentoBean.save(atendimentoRequest);
			response.sendRedirect("listarAtendimento.jsp");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
		
		
		
		
		
		
		
	}


