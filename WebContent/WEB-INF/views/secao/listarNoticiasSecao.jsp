<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Noticias</title>
</head>
<body>

	<table border ="1" >
		<c:forEach var="noticia" items="${noticias}" >
		<tr>
			<a href="lerNoticia?id_noticia=${noticia.id_noticia}" > <h3>${ noticia.titulo }</h3> </a>
			${noticia.subtitulo}
			 <br> 
		</tr>
		</c:forEach>
	</table>

</body>
</html>