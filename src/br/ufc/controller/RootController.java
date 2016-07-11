package br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.NoticiaDAO;
import br.ufc.dao.SecaoDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;


@Controller
public class RootController {
	
	@Autowired
	private NoticiaDAO ndao;
	@Autowired
	private SecaoDAO sdao;
	@Autowired
	private ClassificadoDAO cdao;
	
	@RequestMapping("/")
	public String home(Model model){
		System.out.println("aqui :)");
		
		List<Secao> secoes = sdao.listar();
		List<Noticia> noticias = ndao.listar();
		List<Classificado> classificados = cdao.listar();
		
		model.addAttribute("secoes",secoes);
		model.addAttribute("noticias", noticias);
		model.addAttribute("classificados", classificados);
		
		return "index";
	}
	
}
