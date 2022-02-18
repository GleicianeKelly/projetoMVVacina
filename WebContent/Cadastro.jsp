<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

	if(session.getAttribute("usuario") == null){
		response.sendRedirect("index.jsp");
	}
	
%>
    
    
    
<script type="text/javascript">
	function voltar(){
		location.href = "MenuCadastro.jsp";
	}
</script>
    
    
    
    
    
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/favicon.ico.jpg">
    <link rel="stylesheet" href="css/cadastroPaciente.css">
    <title>Cadastro de Usuários</title>
</head>
<body>
    <form action ="CadastroAdminServlet" method="POST">
		<div id="cadastro">
			<fieldset>
				<legend>Cadastro de Usuários</legend>
				<table>
					<tr>
						<td><label for="nomeAdmin">Nome : </label></td>
						<td><input type="text" name="nomeAdmin" id="nomeAdmin"
							required="true" style="text-transform: uppercase;" /></td>
					<tr>
                        <td><label for="senha">Senha: </label></td>
						<td><input type="password" name="senha" id="senha"
							required="true" style="text-transform: uppercase;" /></td>
					</tr>
				</table>
				<hr>
				<input type="submit" value="Salvar" name="salvar"> <input
					type="reset" value="Limpar"> <input type="button"
					value="Voltar" onClick="voltar()">
			</fieldset>
		</div>
	</form>
</body>
</html>