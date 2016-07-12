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
   	<br> Data da Notícia: ${noticia.dataNoticia} <br>
   	<h4><b>Autor da Noticia:</b> ${noticia.autor.nome }</h4> <img alt="${noticia.autor.nome}" src="<c:url value="/resources/images/users/${noticia.autor.id_usuario}.png"  />" />
	${noticia.texto} <br>
	
	<h3>Comentários:</h3>
	
	<c:forEach var="comentario" items="${comentarios}" >
		<b>${comentario.autor.nome}: </b> ${comentario.texto}  
	</c:forEach>
	
	<c:if test="${user_logado != null }">
		<form action="inserirComentario" method="post">
			Comentário: <input type="text" name="texto"/>
			<input type="hidden" name="id_noticia" value="${noticia.id_noticia}" />
			<input type="submit" value="Comentar" />
		</form>
	</c:if>

</body>
</html>