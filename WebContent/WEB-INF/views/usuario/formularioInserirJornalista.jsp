<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Jornalista</title>
</head>
<body>

	<h1>Inserir Jornalista</h1>
	
	<form action="inserirUsuario" method="post">
	
		Nome: <input type="text" name="nome"/> <br>
		Email: <input type="text" name="email"/> <br>
		Login: <input type="text" name="login"/> <br>
		Senha: <input type="text" name="senha"/> <br>
		
		<input type="hidden" name="id_papel" value="2">
		
		<input type="submit" value="ENVIAR"/>
		
	
	</form>

</body>
</html>