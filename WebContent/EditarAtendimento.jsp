<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Atendimento"%>
<jsp:useBean id="atendimentoService"
	class="service.AtendimentoService" scope="session" />



<%
String acaoSalvar = request.getParameter("salvar");
String mensagem = "";
Musica musica;

//armazenando em variáveis, parâmetros recebidos do formuláro
//cidadeList.jsp
Integer codigo = Integer.parseInt(request.getParameter("codigo"));
String nome_musica = (String) request.getParameter("nome_musica");
String cantor = (String) request.getParameter("cantor");

if (acaoSalvar != null) {
	//montando a musica a partir dos valores do formulário
	atendimento = new Musica();
	musica.setCodigo(codigo);
	musica.setCantor(request.getParameter("cantor"));
	musica.setNome_musica(request.getParameter("nome_musica"));

	//executa o método e retorna a mensagem do servidor...
	mensagem = musicaBean.atualizar(musica);
	//exibe a mensagem recebida do servidor...
	out.println("<br><font color 'FF0000'>" + mensagem + "</font>");

	//verifica se houve atualização dos dados e exibe da mesma forma...
	if (!nome_musica.equals(request.getParameter("nome_musica"))) {
		nome_musica = request.getParameter("nome_musica");

	}
	if (!cantor.equals(request.getParameter("cantor"))) {
		cantor = request.getParameter("cantor");
	}

}
%>

<script type="text/javascript">
	function voltar() {
		location.href = "MusicaList.jsp";
	}
</script>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar Musica</title>
</head>
<body>

	<form method="POST">
		<div id="Form">
			<fieldset>
				<legend>Atualizar Musica</legend>
				<table>
					<tr>
						<td><label for="codigo">Cod: </label></td>
						<td><input type="text" name="txtCodigo" id="codigo" size="6"
							disabled="true" value="<%=codigo%>" /></td>
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
