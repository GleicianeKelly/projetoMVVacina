<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="pacienteService"
	class="service.PacienteService" scope="session" />
	

<%

	if(session.getAttribute("usuario") == null){
		response.sendRedirect("index.jsp");
	}
	
%>



<script type="text/javascript">
	function nova() {
		location.href = "CadastroPaciente.jsp";
	}
	function voltar() {
		location.href = "PacienteMenu.jsp";
	}
</script>

	

    
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/favicon.ico.jpg">
    <link rel="stylesheet" href="css/lista.css">
    <title>Listar Pacientes</title>
</head>
<body>
    
	<form method="POST">
		<div id="cadastro">
			<fieldset>
				<legend>Pacientes Cadastrados</legend>
				<table border="1">
					<tr>
						<td>Cod. Paciente</td>
						<td>CPF</td>
						<td>Nome Paciente</td>
						<td>Endereço</td>
						<td>Alterar</td>
					</tr>
					<c:forEach var="paciente" items="${pacienteService.list()}">
						<tr>
							<td><c:out value="${paciente.id_paciente}" /></td>
							<td><c:out value="${paciente.cpf}" /></td>
							<td><c:out value="${paciente.nome_paciente}" /></td>
							<td><c:out value="${paciente.endereco}" /></td>
								
							<td><a href="EditarPaciente.jsp?codigo=${paciente.id_paciente}&&cpf=${paciente.cpf}&&nome_paciente=${paciente.nome_paciente}&&endereco=${paciente.endereco}">Editar</a></td>
							
						</tr>
					</c:forEach>

				</table>
			</fieldset>
		</div>
		<hr />
		<input type="button" value="Novo" onclick="nova()"> <input
			type="button" value="Voltar" onclick="voltar()">
	</form>
</body>
</html>