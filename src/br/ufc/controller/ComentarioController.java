package br.ufc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.ComentarioDAO;
import br.ufc.dao.NoticiaDAO;
import br.ufc.model.Comentario;
import br.ufc.model.Noticia;
import br.ufc.model.Usuario;

@Controller
@Transactional
public class ComentarioController {
	
	@Autowired
	private NoticiaDAO ndao;
	@Autowired
	private ComentarioDAO cdao;
	@Autowired
	private ClassificadoDAO clasdao;
	
	@RequestMapping("inserirComentario")
	public String inserirComentario(HttpSession session, Comentario comentario, 
			Model model, Noticia noticia){
		
		Usuario user = (Usuario) session.getAttribute("user_logado");
		Noticia news = ndao.buscar(noticia.getId_noticia());
		
		
		
		Comentario c = new Comentario();
		c.setAutor(user);
		c.setNoticia(news);
		c.setTexto(comentario.getTexto());
		
		List<Comentario>coments = news.getComentarios();
		coments.add(c);
		news.setComentarios(coments);
		
		cdao.inserir(c);
		ndao.atualizar(news);
		
		model.addAttribute("classificados", clasdao.listar());
		model.addAttribute("noticias", ndao.listar());
		
		return "menuLeitor";
	}
	
}
