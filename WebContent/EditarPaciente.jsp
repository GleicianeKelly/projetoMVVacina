<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Paciente"%>
<jsp:useBean id="pacienteService" class="service.PacienteService"
	scope="session" />

<%

	if(session.getAttribute("usuario") == null){
		response.sendRedirect("index.jsp");
	}
	
%>


<%
String acaoSalvar = request.getParameter("salvar");

Paciente paciente;


Integer codigo = Integer.parseInt(request.getParameter("codigo"));
String cpf = (request.getParameter("cpf"));
String nome_paciente = request.getParameter("nome_paciente");
String endereco = request.getParameter("endereco");


%>

<script type="text/javascript">
	function voltar() {
		location.href = "listarPaciente.jsp";
	}
</script>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="img/favicon.ico.jpg">
<link rel="stylesheet" href="css/lista.css">
<title>Atualizar Paciente</title>
</head>
<body>

	<form action="EditarPaciente" method="POST">
		<div id="Form">
			<fieldset>
				<legend>Atualizar Paciente</legend>
				<table>
					<tr>
						<td><label for="codigo"></label></td>
						<td><input type="hidden" name="id_codigo" 
						id="codigo" size="6" value="<%=codigo%>" /></td>
					<tr>
					<tr>
						<td><label for="codigo">Id paciente: </label></td>
						<td><input type="text" disabled="true"
						id="codigo" size="6" value="<%=codigo%>" /></td>
					<tr>
					<tr>
						<td><label for="cpf">CPF: </label></td>
						<td><input type="text" name="cpf"
							id="cpf" required="true"
							style="text-transform: uppercase;" 
							value="<%=cpf%>" /></td>
					<tr>
					<tr>
						<td><label for="nome_paciente">Nome Paciente: </label></td>
						<td><input type="text" name="nome_paciente"
							id="nome_paciente" required="true"
							style="text-transform: uppercase;" 
							value="<%=nome_paciente%>" /></td>
					<tr>
						<td><label for="endereco">Endereço: </label></td>
						<td><input type="text" name="endereco" id="endereco"
							required="true" style="text-transform: uppercase;"
							value="<%=endereco%>" /></td>
					</tr>
				</table>
				<hr>
				<input type="submit" value="Salvar" name="salvar"> <input
					type="button" value="Voltar" onClick="voltar()">

			</fieldset>
		</div>
	</form>
</body>
</html>
