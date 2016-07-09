package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;
import br.ufc.model.Usuario;

@Transactional
@Controller
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
		return "noticia/inserirNoticia";
	}
	
	@RequestMapping("inserirNoticia")
	public String inserirNoticia(Noticia noticia, HttpSession session, Secao secao){
		Usuario user = (Usuario) session.getAttribute("user_logado");
		
		if(user == null){
			return "redirect:formularioNoticia";
		}
		
		noticia.setAutor(udao.buscar(user.getId_usuario()));
		noticia.setSecao(sdao.buscar(noticia.getSecao().getId()));
		
		this.ndao.inserir(noticia);
		
		return "noticia/noticiaInseridaOK";
	}
	
}
