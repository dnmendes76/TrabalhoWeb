<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Oferta</title>
</head>
<body>

	<form action="inserirOferta" method="post">
		${classificado.id_classificado} <br/>
		Titulo: ${classificado.titulo}  <br/>
		Descrição: ${classificado.texto} <br/>
		Preço: ${classificado.preco} <br/>
		Responsavel: ${classificado.autor.nome}<br/>
		Telefone: ${classificado.telefone} <br/>
		
		Nova Oferta: <input type="text" name="preco" value="${classificado.melhorOferta.preco}"/> <br/>
		
		<input type="hidden" name="id_classificado" value="${classificado.id_classificado}"/>
		
		<input type="submit" value="Adicionar Oferta"/>
	</form>

</body>
</html>

