<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%

	if(session.getAttribute("usuario") == null){
		response.sendRedirect("index.jsp");
	}
	
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/cadastroVacina.css">
<title>Buscar Vacina</title>
</head>
<body>
 <form action="BuscarVacinaServlet" method="POST">
		<div id="cadastro">
			<fieldset>
				<legend>Buscar Vacina</legend>
				<table>
					<tr>
                        <td><label for="marcaVacina">Nome da vacina: </label></td>
						<td><input type="text" name="nomeVacina" id="marca"
							required="true" style="text-transform: uppercase;" /></td>
					</tr>                  
				</table>
				<hr>
				<input type="submit" value="Enviar" name="salvar"> <input
					type="reset" value="Limpar"> <input type="button"
					value="Voltar" onClick="voltar()">
			</fieldset>
		</div>
	</form>

</body>
</html>