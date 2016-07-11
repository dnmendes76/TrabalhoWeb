<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jornal</title>
</head>
<body>

	<h1>Jornal</h1>
	<h2>
	<a href="loginFormulario"> Login</a> <br>
	<a href="formularioInserirLeitor"> Cadastre-se</a> <br>
	</h2>
	
	<table border="1">
	
		<c:forEach var="secao" items="${ secoes }" >
			<tr> 
				<h2>Secão:<a href="mostrarNoticiaSecao?id_secao=${secao.id_secao}">${ secao.titulo } </a></h2> 
				<c:forEach var="noticia" items="${ noticias }" >
					<c:set var="temp1" value="${ noticia.secao.titulo}"/>
					<c:set var="temp2" value="${secao.titulo}"/>
					<c:if test="${ temp1 == temp2 }" >
						<a href="lerNoticia?id_noticia=${noticia.id_noticia}" > <h3>${ noticia.titulo }</h3> </a>
						${noticia.subtitulo}
						 <br> 
					</c:if>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
	
	<br><br>
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
				<c:if test="${classificado.melhorOferta == null}">
				<td> Nenhuma Oferta </td>
				<td> NULL </td>
				<td> NULL </td>
				</c:if>
			</tr>
		</c:forEach>
	
	</table>
	
	

</body>
</html>
