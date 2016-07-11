<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Notícias</title>
</head>
<body>

	<table border ="1" >
		<c:forEach var="noticia" items="${noticias}" >
			<tr>
				<td> <a href="lerNoticia?id_noticia=${noticia.id_noticia}" > <h3>${ noticia.titulo }</h3> </a> </td>
				<td> ${noticia.subtitulo}</td>
				<td> ${noticia.autor.nome}</td>
				<td> <a href="apagarNoticia?id_noticia=${noticia.id_noticia}" >APAGAR</a>  </td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>