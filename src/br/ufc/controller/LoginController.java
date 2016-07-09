package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDAO userDAO;
	
	@RequestMapping("loginFormulario")
	public String loginFormulario(){
		return "login/loginFormulario";
	}
	
	@RequestMapping("login")
	public String login(HttpSession session, Usuario user){
		
//		System.out.println(user.getNome());
//		System.out.println(user.getLogin());
		
		Usuario aux = this.userDAO.recuperar(user.getLogin());
			
		if (aux != null){
			if(aux.getSenha().equals(user.getSenha())){
				
				session.setAttribute("user_logado", aux);
				return "menu";
			}
		}
		
		return "redirect:loginFormulario";
		
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
}
