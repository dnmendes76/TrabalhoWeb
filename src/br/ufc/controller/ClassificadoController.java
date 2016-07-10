package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Usuario;

@Controller
@Transactional
public class ClassificadoController {
	
	@Autowired
	private ClassificadoDAO cdao;
	@Autowired
	private UsuarioDAO udao;

	@RequestMapping("formularioInserirClassificado")
	public String formularioInserirClassificado(){
		return "classificado/formularioInserirClassificado";
	}
	
	@RequestMapping("inserirClassificado")
	public String inserirNoticia(HttpSession session, Classificado classificado){

		Usuario user = (Usuario) session.getAttribute("user_logado");
//		
		if(user == null){
			return "redirect:formularioInserirClassificado";
		}
//		
		classificado.setAutor(udao.buscar(user.getId_usuario()));
//		
		this.cdao.inserir(classificado);
		
		return "classificado/classificadoInseridoOK";
	}
	

}
