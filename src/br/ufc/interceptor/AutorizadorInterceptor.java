package br.ufc.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException{
		
		String uri = request.getRequestURI();
		
		if (uri.endsWith("/") || uri.endsWith("loginFormulario") || uri.endsWith("login") ||
			uri.endsWith("formularioInserirLeitor")){
			return true;
		}
		
		if (request.getSession().getAttribute("user_logado") != null){
			return true;			
		}
		
		response.sendRedirect("loginFormulario");
		return false;
	}

}
