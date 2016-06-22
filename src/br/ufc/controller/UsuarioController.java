package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;

@Controller
@Transactional
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO userDAO;
	@Autowired
	private PapelDAO paperDAO;
	
	@RequestMapping("formularioInserirLeitor")
	public String formularioInserirLeitor(){
		return "usuario/formularioInserirLeitor";
	}
	
	@RequestMapping("inserirUsuario")
	public String InserirUsuario(Usuario user, Papel paper){
		Papel p = paperDAO.buscar(paper.getId());
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(p);
		user.setPapeis(papeis);

		this.userDAO.inserir(user);
		
		return "usuario/usuarioInseridoOK";
	}

}
