<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir Noticia</title>
</head>
<body>

	<h1>Inserir Notícia</h1>
	
	<form  action="inserirNoticia" method="POST">
		
		Título: <br/> <input type="text" name="titulo" /> 	<br/>
		Subtítulo: <br /><input type="text" name="subtitulo" /> <br/>	
		
		<select name="id_secao" >
			<c:forEach var="secao" items = "${categoria}">
				<option value=" ${secao.id_secao} ">${secao.titulo}</option>
			</c:forEach>
		</select> <br />		
		
		Texto: <br /><textarea name="texto" id="mensagem"></textarea><br/>
		Data da Notícia:<br /> <input type="date" name="data_noticia"/> <br/>
		
		<input type="submit" value="Inserir" /> <br />
	</form>

</body>
</html>