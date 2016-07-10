package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Controller
@Transactional
public class NoticiaController {
	
	@Autowired
	private NoticiaDAO ndao;
	@Autowired
	private UsuarioDAO udao;
	@Autowired
	private SecaoDAO sdao;
	
	@RequestMapping("formularioInserirNoticia")
	public String formularioInserirNoticia( Model model){
		List<Secao> categoria = sdao.listar();
		model.addAttribute("categoria", categoria);
		return "noticia/formularioInserirNoticia";
	}
	
	@RequestMapping(value = "inserirNoticia", method= RequestMethod.POST)
	public String inserirNoticia(HttpSession session, Noticia noticia, @RequestParam long id_secao){

		Usuario user = (Usuario) session.getAttribute("user_logado");
//		
		if(user == null){
			return "redirect:formularioInserirNoticia";
		}
//		
		noticia.setAutor(udao.buscar(user.getId_usuario()));
		noticia.setSecao(sdao.buscar(id_secao));
//		
		this.ndao.inserir(noticia);
		
		return "noticia/noticiaInseridaOK";
	}
	
}
