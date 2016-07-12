package br.ufc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.ufc.dao.PapelDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Papel;
import br.ufc.model.Usuario;
import br.ufc.util.FileUtil;

@Controller
@Transactional
public class UsuarioController {
	
	@Autowired
//	@Qualifier(value="usuarioDAO")
	private UsuarioDAO userDAO;
	
	@Autowired
	private ServletContext servletContext;
	
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
	public String InserirUsuario(Usuario user, Papel paper, Model model,
			@RequestParam(value="imagem", required=false) MultipartFile imagem){
		
		Papel p = paperDAO.buscar(paper.getId_papel());
		List<Papel> papeis = new ArrayList<Papel>();
		papeis.add(p);
		user.setPapeis(papeis);
//		System.out.println(user.getNome());
//		System.out.println(p.getPapel());
		
		this.userDAO.inserir(user);
		
		String path = servletContext.getRealPath("/")+"resources/images/users/"+user.getId_usuario()+".png";
		
		System.out.println(path);
		
		if(!path.equals("")){
			FileUtil.salvarImagem(path, imagem);
		}
		
		List<Papel> ps = paperDAO.listar();
//		System.out.println(papeis.get(1).getPapel());
		model.addAttribute("papeis", ps);
		
		return "login/loginFormulario";
	}
	
	

}
