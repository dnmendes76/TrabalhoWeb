<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Classificado</title>
</head>
<body>

	<h1>Inserir Classificado</h1>
	
	<form action="inserirClassificado" method="post">
	
		Título   :<input type="text" name="titulo"><br> 
		Texto    :<input type="text" name="texto"><br>
		Telefone :<input type="text" name="telefone"><br>
		Preço    :<input type="text" name="preco"><br>
		
		<input type="submit" value="ENVIAR"/>
		
	
	</form>	

</body>
</html>