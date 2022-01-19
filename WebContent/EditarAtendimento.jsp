<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Atendimento"%>
<jsp:useBean id="AtendimentoService"
class="service.AtendimentoService" scope="session" />

   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar Atendimento</title>
</head>
<body>

	<form method="POST">
		<div id="Form">
			<fieldset>
				<legend>Atualizar Atendimento</legend>
				<table>
					<tr>
						<td><label for="codigo">Cod: </label></td>
						<td><input type="text" name="txtCodigo" id="codigo" size="6"
							disabled="true" value="<%=id_atendime%>" /></td>
					<tr>
					<tr>
						<td><label for="nome_musica">Nome Musica: </label></td>
						<td><input type="text" name="txtDescricao" id="nome_musica"
							required="true" style="text-transform: uppercase;"
							value="<%=nome_musica%>" /></td>
					<tr>
						<td><label for="cantor">Cantor: </label></td>
						<td><input type="text" name="txtCantor" id="cantor" required="true"
							size="2" maxlength="2" style="text-transform: uppercase;"
							value="<%=cantor%>" /></td>
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
