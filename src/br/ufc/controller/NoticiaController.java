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
	
	@RequestMapping("lerNoticia")
	public String noticiaDetalhes(Noticia noticia, Model model){
		
		Noticia aux = ndao.buscar(noticia.getId_noticia());
		model.addAttribute("noticia", aux);
		model.addAttribute("comentarios", aux.getComentarios());
		
		System.out.println(aux.getTitulo() +" coments "+ aux.getComentarios().size());
		
		return "noticia/noticiaDetalhes";
	}	
	
	@RequestMapping("listarNoticias")
	public String listarNoticias(HttpSession session, Model model){
		
		Usuario user = (Usuario) session.getAttribute("user_logado");

		List<Noticia> lista = ndao.listar();
		model.addAttribute("noticias", lista);
		
		return "noticia/listarNoticias";
	}
	
	@RequestMapping("apagarNoticia")
	public String apagarNoticia(Noticia noticia){
		
		ndao.deletar(noticia.getId_noticia());
		
		return"redirect:listarNoticias";
	}
	
}
