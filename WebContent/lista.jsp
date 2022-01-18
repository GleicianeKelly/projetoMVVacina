<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    
    
    
<!DOCTYPE html>
<html lang="en">
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
						<td>Cod. Atendimento</td>
						<td>Cod. Paciente</td>
						<td>Cod. Vacina</td>
						<td>Data de atendimento</td>
						<td>Alterar</td>
					</tr>
					<c:forEach var="musica" items="${musicaBean.listarTodos()}">
						<tr>
							<td><c:out value="${musica.codigo}" /></td>
							<td><c:out value="${musica.nome_musica}" /></td>
							<td><c:out value="${musica.cantor}" /></td>
							<td><c:out value="${musica.cantor}" /></td>
							<td><a href="MusicaList.jsp?idExcluir=${musica.codigo}">Excluir</a>
								<a
								href="MusicaEdit.jsp?codigo=${musica.codigo}&&nome_musica=${musica.nome_musica}&&cantor=${musica.cantor}">Editar</a>
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