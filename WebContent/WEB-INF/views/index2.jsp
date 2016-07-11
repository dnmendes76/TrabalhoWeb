<h1>Jornal</h1>
	<h2>
	<a href="loginFormulario"> Login</a> <br>
	<a href="formularioInserirLeitor"> Cadastre-se</a> <br>
	</h2>
	
	<table border="1">
		<h2>Seções</h2>
		<c:forEach var="secao" items="${ secoes }" >
			<tr> 
				<h3><a href="mostrarNoticiaSecao?id_secao=${secao.id_secao}">${ secao.titulo } </a> </h3> 
			</tr>
		</c:forEach>
	</table>
	
	<br><br>
	
	<table border ="1" >
		<h2>Notícias</h2>
		<c:forEach var="noticia" items="${ noticias }" >
			<a href="lerNoticia?id_noticia=${noticia.id_noticia}" > <h3>${ noticia.titulo }</h3> </a>
			${noticia.subtitulo}
			 <br> 
		</c:forEach>
	</table>
	
	<br><br>
	<table border="1">
		<h2>Classificados</h2>
		<c:forEach var="classificado" items="${ classificados }" >
			<tr> 
				<b>${classificado.titulo}</b> <br>
				Descrição: ${classificado.texto} <br>
				Preço: ${classificado.preco} <br>
				Responsável: ${classificado.autor.nome} <br>
				Telefone: ${classificado.telefone} <br>
				<c:if test="${classificado.melhorOferta > 0.0 }">
					Melhor Oferta: ${classificado.melhorOferta} <br>
					Data melhor oferta:${classificado.dataOferta} <br>
				</c:if>
			</tr>
		</c:forEach>
	
	</table>
