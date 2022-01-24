<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<script type="text/javascript">
	function nova() {
		location.href = "CadastroVacina.jsp";
	}
	function voltar() {
		location.href = "VacinaMenu.jsp";
	}
</script>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/lista.css">
<title>Listar Nome Vacina</title>
</head>
<body>

	<form method="POST">
		<div id="cadastro">
			<fieldset>
				<legend>Vacinas Cadastradas</legend>
				<table border="1">
					<tr>
						<td>Cod. Vacina</td>
						<td>Nome Vacina</td>
						<td>Marca Vacina</td>
						<td>Alterar</td>
					</tr>
					<c:forEach var="vacina" items="${vacinaEncontrada}">
						<tr>
							<td><c:out value="${vacina.getId_vacina()}" /></td>
							<td><c:out value="${vacina.getNome_vacina()}" /></td>
							<td><c:out value="${vacina.getMarca()}" /></td>

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