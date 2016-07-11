package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import criptografia.Criptografia;
import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioDAO userDAO;
	
	@Autowired
	private PapelDAO pdao;
	
	@Autowired
	private ClassificadoDAO cdao;
	
	@RequestMapping("loginFormulario")
	public String loginFormulario( Model model){
		
		List<Papel> papeis = pdao.listar();
//		System.out.println(papeis.get(1).getPapel());
		model.addAttribute("papeis", papeis);
		return "login/loginFormulario";
	}
	
	@RequestMapping(value = "login", method= RequestMethod.POST)
	public String login(HttpSession session, Usuario user, @RequestParam int papel, Model model){
//		System.out.println(papel);
//		System.out.println(user.getLogin());
		
		boolean flag = false;
		
		Usuario aux = this.userDAO.recuperar(user.getLogin());
		Criptografia crip = new Criptografia();
		
		
		if (aux != null){
			
			for (Papel i : aux.getPapeis()) {
				if(i.getPapel().equals(pdao.buscar(papel).getPapel())){
					flag = true;
					break;
				}
			}
			
			if(aux.getSenha().equals(crip.codifica(user.getSenha())) && flag){
				
				session.setAttribute("user_logado", aux);
				
				if (papel == 1){
					model.addAttribute("classificados", cdao.listar());
					return "menuLeitor";
				}
				else if (papel == 2){
					return "menuJornalista";
				}
				else if (papel == 3){
					return "menuEditor";
				}				
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
