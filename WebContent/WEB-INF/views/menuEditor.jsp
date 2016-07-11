<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu Editor</title>
</head>
<body>

	<h1>Bem vindo, ${user_logado.nome}</h1>
	
	<h2>
	<a href="formularioInserirJornalista"> Cadastrar Jornalista</a> <br>
	<a href="formularioInserirClassificado"> Cadastrar Classificado</a> <br>
	<a href="formularioInserirSecao"> Cadastrar Seção</a> <br>
	<a href="listarNoticias"> Apagar Notícia</a> <br>
	<a href="logout"> SAIR </a>
	</h2>
	
</body>
</html>