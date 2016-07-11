<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ler Notícia</title>
</head>
<body>
	
	<h1>Seção: ${noticia.secao.titulo} </h1>
	<h1> ${noticia.titulo } </h1>
   	<h3> ${noticia.subtitulo } </h3>
	${noticia.texto} <br>
	<h4><b>Autor da Noticia:</b> ${noticia.autor.nome }</h4>
	<br> Data da Notícia: ${noticia.dataNoticia} <br>
	
	<h3>Comentários:</h3>
	
	<c:forEach var="comentario" items="${comentarios}" >
		<b>${comentario.autor.nome}: </b> ${comentario.texto}  
	</c:forEach>	

</body>
</html>