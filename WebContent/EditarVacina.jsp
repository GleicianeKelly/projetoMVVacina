<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Vacina"%>
<jsp:useBean id="vacinaService" class="service.VacinaService"
	scope="session" />



<%
String acaoSalvar = request.getParameter("salvar");

Vacina vacina;


Integer codigo = Integer.parseInt(request.getParameter("codigo"));
String nome_vacina = (request.getParameter("nome_vacina"));
String marca = request.getParameter("marca");



%>

<script type="text/javascript">
	function voltar() {
		location.href = "listarVacina.jsp";
	}
</script>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="icon" href="img/favicon.ico.jpg">
<link rel="stylesheet" href="css/lista.css">
<title>Atualizar Vacina</title>
</head>
<body>

	<form action="EditarVacinaServlet" method="POST">
		<div id="Form">
			<fieldset>
				<legend>Atualizar Vacina</legend>
				<table>
					<tr>
						<td><label for="codigo"></label></td>
						<td><input type="hidden" name="id_codigo" 
						id="codigo" size="6" value="<%=codigo%>" /></td>
					<tr>
					<tr>
						<td><label for="codigo">Id vacina: </label></td>
						<td><input type="text" disabled="true"
						id="codigo" size="6" value="<%=codigo%>" /></td>
					<tr>
					<tr>
						<td><label for="nome_vacina">Nome vacina: </label></td>
						<td><input type="text" name="nome_vacina"
							id="nome_vacina" required="true"
							style="text-transform: uppercase;" 
							value="<%=nome_vacina%>" /></td>
					<tr>
					<tr>
						<td><label for="marca">Marca: </label></td>
						<td><input type="text" name="marca"
							id="marca" required="true"
							style="text-transform: uppercase;" 
							value="<%=marca%>" /></td>
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
