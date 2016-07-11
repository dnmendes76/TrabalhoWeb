package br.ufc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.SecaoDAO;
import br.ufc.model.Noticia;
import br.ufc.model.Secao;

@Transactional
@Controller
public class SecaoController {
	
	@Autowired
	private SecaoDAO sdao;
	
	@RequestMapping("formularioInserirSecao")
	public String formularioInserirSecao(){
		return "secao/formularioInserirSecao";
	}
	
	@RequestMapping("inserirSecao")
	public String inserirSecao(Secao secao){
		this.sdao.inserir(secao);
		return "secao/secaoInseridaOK";
	}
	
	@RequestMapping("mostrarNoticiaSecao")
	public String noticiaDetalhes(Secao secao, Model model){
		
		Secao aux = sdao.buscar(secao.getId_secao());
		
		List<Noticia> noticias = aux.getNoticias();
		
		System.out.println(noticias.size() + "aqui");
		
		model.addAttribute("noticias", noticias);
		model.addAttribute("secao", aux);
		
		System.out.println(aux.getTitulo());
		
		return "secao/listarNoticiasSecao";
	}
	

}
