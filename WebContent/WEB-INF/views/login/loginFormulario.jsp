<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LOGIN</title>
</head>
<body>

	<h2>Efetuar Login</h2>
	
	<form action="login" method="post">
		Login: <input type="text" name="login"/> <br/>
		Senha: <input type="text" name="senha"/> <br/>
		
		<select name="papel" >
			<c:forEach var="papel" items = "${papeis}">
				<option value=" ${papel.id_papel} ">${papel.papel}</option>
			</c:forEach>
		</select> <br />
		
		<input type="submit" value="ENVIAR"/>
	
	</form>

</body>
</html>