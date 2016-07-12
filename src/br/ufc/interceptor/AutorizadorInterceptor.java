package br.ufc.interceptor;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	private UsuarioDAO udao;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
		
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		
		if (uri.endsWith("/") || uri.endsWith("loginFormulario") || uri.endsWith("login") ||
			uri.endsWith("formularioInserirLeitor") || uri.endsWith("lerNoticia") ||
			uri.endsWith("mostrarNoticiaSecao") || uri.endsWith("inserirUsuario")){
			return true;
		}
		
		if (request.getSession().getAttribute("user_logado") != null){
			Usuario dum = (Usuario) session.getAttribute("user_logado");
			Usuario user = udao.recuperar(dum.getLogin());
			List<Papel> papeis = user.getPapeis();
			if(papeis != null){
				for(Papel p : papeis){
					if(p.getPapel().equals("Leitor") && ( uri.endsWith("lerNoticia") || uri.endsWith("/") || uri.endsWith("logout") ||
					   uri.endsWith("inserirOferta") || uri.endsWith("formularioInserirOferta") ||
					   uri.endsWith("inserirComentario") )){
						return true;
					}
					if(p.getPapel().equals("Jornalista") && ( uri.endsWith("formularioInserirNoticia")|| uri.endsWith("logout") ||
					   uri.endsWith("inserirNoticia") || uri.endsWith("listarNoticias") )){
						return true;
					}
					if(p.getPapel().equals("Editor") && ( uri.endsWith("formularioInserirJornalista") || uri.endsWith("logout") ||
					   uri.endsWith("formularioInserirClassificado") || uri.endsWith("formularioInserirSecao") || 
					   uri.endsWith("inserirClassificado") || uri.endsWith("listarNoticias") ||
					   uri.endsWith("inserirSecao")) ){
						return true;
					}
				}
			}		
		}
		
		response.sendRedirect("loginFormulario");
		return false;
	}

}
