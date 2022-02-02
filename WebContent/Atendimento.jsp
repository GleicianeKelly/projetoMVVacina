<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%

	if(session.getAttribute("usuario") == null){
		response.sendRedirect("index.jsp");
	}
	
%>
    
    
<script type="text/javascript">
	function voltar() {
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
    <link rel="stylesheet" href="css/atendimento.css">
    <title>Atendimento</title>
</head>
<body>
    <form action="CadastroAtendimentoServlet" method="POST">
		<div id="cadastro">
			<fieldset>
				<legend>Atendimento</legend>
				<table>
					
                        <td><label for="idPaciente">CPF do paciente: </label></td>
						<td><input type="text" name="CPFPaciente" id="idPaciente"
							required="true" style="text-transform: uppercase;" /></td>
					</tr>
                    <tr>
						<td><label for="idVacina">Nome da vacina: </label></td>
						<td><input type="text" name="NomeVacina" id="idVacina"true"
							 style="text-transform: uppercase;" /></td>
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