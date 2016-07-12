package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;

@Controller
@Transactional
public class UsuarioController {
	
	@Autowired
//	@Qualifier(value="usuarioDAO")
	private UsuarioDAO userDAO;
	
	@Autowired
	private PapelDAO paperDAO;
	
	@RequestMapping("formularioInserirJornalista")
	public String formularioInserirJornalista(){
		return "usuario/formularioInserirJornalista";
	}
	
	@RequestMapping("formularioInserirLeitor")
	public String formularioInserirLeitor(){
		return "usuario/formularioInserirLeitor";
	}
	
	@RequestMapping("inserirUsuario")
	public String InserirUsuario(Usuario user, Papel paper, Model model){
		
		Papel p = paperDAO.buscar(paper.getId_papel());
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(p);
		user.setPapeis(papeis);
//		System.out.println(user.getNome());
//		System.out.println(p.getPapel());
		this.userDAO.inserir(user);
		
		List<Papel> ps = paperDAO.listar();
//		System.out.println(papeis.get(1).getPapel());
		model.addAttribute("papeis", ps);
		
		return "login/loginFormulario";
	}
	
	

}
