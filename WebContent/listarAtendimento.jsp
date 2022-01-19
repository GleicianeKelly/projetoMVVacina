<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="atendimentoService" class="service.AtendimentoService"
	scope="session" />



<script type="text/javascript">
	function nova() {
		location.href = "Atendimento.jsp";
	}
	function voltar() {
		location.href = "AtendimentoMenu.jsp";
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
<title>Listar Atendimentos</title>
</head>
<body>

	<form>
		<div id="cadastro">
			<fieldset>
				<legend>Atendimentos</legend>
				<table border="1">
					<tr>
						<td>Cod. Atendimento</td>
						<td>CPF</td>
						<td>Nome paciente</td>
						<td>Endereço</td>
						<td>Nome vacina</td>
						<td>Marca vacina</td>
						<td>Data atendimento</td>
						<td>Alterar</td>
					</tr>
					<c:forEach var="atendimento"
						items="${atendimentoService.findAll()}">
						<tr>
							<td><c:out value="${atendimento.id_atendime}" /></td>
							<td><c:out value="${atendimento.paciente.cpf}" /></td>
							<td><c:out value="${atendimento.paciente.nome_paciente}" /></td>
							<td><c:out value="${atendimento.paciente.endereco}" /></td>
							<td><c:out value="${atendimento.vacina.nome_vacina}" /></td>
							<td><c:out value="${atendimento.vacina.marca}" /></td>
							<td><c:out value="${atendimento.dt_atendimento}" /></td>
							<td><a href="ExcluirAtendimento?id=${atendimento.id_atendime}">Excluir</a>
								

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