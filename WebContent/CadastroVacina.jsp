<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
    <link rel="stylesheet" href="css/cadastroVacina.css">
    <title>Cadastro de Vacina</title>
</head>
<body>
    <form action="CadastroVacinaServlet" method="POST">
		<div id="cadastro">
			<fieldset>
				<legend>Cadastro de Vacinas</legend>
				<table>
					<tr>
						<td><label for="nomeVacina">Nome da Vacina: </label></td>
						<td><input type="text" name="nomeVacina" id="nomeVacina"
							required="true" style="text-transform: uppercase;" /></td>
					<tr>
                        <td><label for="marcaVacina">Marca da vacina: </label></td>
						<td><input type="text" name="marcaVacina" id="marca"
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