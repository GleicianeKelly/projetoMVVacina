<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%

	if(session.getAttribute("usuario") == null){
		response.sendRedirect("index.jsp");
	}
	
%>

    
    
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="img/favicon.ico.jpg">
    <link rel="stylesheet" href="css/cadastro.css">
    <title>Cadastro</title>
</head>
<body>
    <div class="controle">
        <div class="botao">
            <a href= "PacienteMenu.jsp"><button>Paciente</button></a>
        </div> 
        <div class="botao">
            <a href= "VacinaMenu.jsp"><button>Vacina</button></a>
        </div> 
        <div class="botao">
            <a href ="AtendimentoMenu.jsp"><button>Atendimento</button></a>
        </div> 
        <div class="botao">
            <a href ="deslogar.jsp"><button>Sair</button></a>
        </div> 
        
    </div>
</body>
</html>