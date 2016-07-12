<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu Leitor</title>
</head>
<body>
	<h1>Bem vindo, ${user_logado.nome}</h1>
	
	<h2> Inserir comentário nas notícias </h2> <br>
	<table border ="1" >
		<tr>
			<td> Título </td>
			<td> Subtitulo </td>
			<td> Autor </td>
		</tr>
		<c:forEach var="noticia" items="${noticias}" >
			<tr>
				<td> <a href="lerNoticia?id_noticia=${noticia.id_noticia}" > <h3>${ noticia.titulo }</h3> </a> </td>
				<td> ${noticia.subtitulo}</td>
				<td> ${noticia.autor.nome}</td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	
	<table border="1">
		<h2>Classificados</h2>
			<tr> 
				<td> Titulo </td>
				<td>Descrição:</td>
				<td>Preço: </td>
				<td>Responsável: </td>
				<td>Telefone: </td>
				<td>Melhor Oferta:  </td>
				<td>Data melhor oferta:</td>
				<td>Usuário melhor oferta: </td>
				<td> Ação </td>
			</tr>
		<c:forEach var="classificado" items="${ classificados }" >
			<tr> 
				<td><h3>${classificado.titulo}</h3></td>
				<td><h4>${classificado.texto}</h4> </td>
				<td>${classificado.preco} </td>
				<td>${classificado.autor.nome} </td>
				<td>${classificado.telefone} </td>
				<c:if test="${classificado.melhorOferta != null }">
				<td>${classificado.melhorOferta.preco} </td>
				<td>${classificado.melhorOferta.dataOferta} </td>
				<td>${classificado.melhorOferta.autorOferta.nome} </td>
				</c:if>
				<c:if test="${classificado.melhorOferta == null }">
				<td> Nenhuma Oferta </td>
				<td> NULL </td>
				<td> NULL </td>
				</c:if>
				<td> <a href="formularioInserirOferta?id_classificado=${classificado.id_classificado}" >Inserir Oferta</a>  </td>
			</tr>
		</c:forEach>
	
	</table>
	
	<h2><a href="logout"> SAIR </a></h2>
	
</body>
</html>