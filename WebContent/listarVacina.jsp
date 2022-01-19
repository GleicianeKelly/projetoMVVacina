<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="vacinaService"
	class="service.PacienteService" scope="session" />
	
	

    
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/favicon.ico.jpg">
    <link rel="stylesheet" href="css/lista.css">
    <title>Listar Vacinas</title>
</head>
<body>
    
	<form method="POST">
		<div id="cadastro">
			<fieldset>
				<legend>Vacinas Cadastrados</legend>
				<table border="1">
					<tr>
						<td>Cod. Vacina</td>
						<td>Nome Vacina</td>
						<td>Marca Vacina</td>
						<td>Alterar</td>
					</tr>
					<c:forEach var="vacina" items="${vacinaService.findAll()}">
						<tr>
							<td><c:out value="${vacina.getId_vacina()}" /></td>
							<td><c:out value="${vacina.getNome_vacina()}" /></td>
							<td><c:out value="${vacina.getMarca()}" /></td>
							<td><a href="ExcluirVacina?id=${vacina.getId_vacina}">Excluir</a>
								
								<!--<a href="MusicaEdit.jsp?codigo=${musica.codigo}&&nome_musica=${musica.nome_musica}&&cantor=${musica.cantor}">Editar</a>  -->
							</td>
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