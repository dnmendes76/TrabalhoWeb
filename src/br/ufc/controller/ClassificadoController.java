package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.ufc.dao.ClassificadoDAO;
import br.ufc.dao.OfertaDAO;
import br.ufc.dao.UsuarioDAO;
import br.ufc.model.Classificado;
import br.ufc.model.Oferta;
import br.ufc.model.Usuario;

@Controller
@Transactional
public class ClassificadoController {
	
	@Autowired
	private ClassificadoDAO cdao;
	@Autowired
	private UsuarioDAO udao;
	@Autowired
	private OfertaDAO odao;

	@RequestMapping("formularioInserirClassificado")
	public String formularioInserirClassificado(){
		return "classificado/formularioInserirClassificado";
	}
	
	@RequestMapping("inserirClassificado")
	public String inserirClassificado(HttpSession session, Classificado classificado){

		Usuario user = (Usuario) session.getAttribute("user_logado");
		if(user == null){
			return "redirect:formularioInserirClassificado";
		}	
		classificado.setAutor(udao.buscar(user.getId_usuario()));
		this.cdao.inserir(classificado);
		
		return "classificado/classificadoInseridoOK";
	}
	
	@RequestMapping("formularioInserirOferta")
	public String formularioInserirOferta(Classificado classificado, Model model){
		model.addAttribute("classificado", cdao.buscar(classificado.getId_classificado()));
		return "classificado/formularioInserirOferta";
	}
	
	@RequestMapping("inserirOferta")
	public String inserirOferta(HttpSession session, Oferta oferta, Classificado classificado, Model model){
		
		System.out.println("aqui");
		Usuario user = (Usuario) session.getAttribute("user_logado");
		System.out.println(user.getNome());
		
		Classificado c = cdao.buscar(classificado.getId_classificado());
		
		System.out.println(oferta.getPreco() + "  " + c.getTitulo());

		Oferta o = new Oferta();
		o.setAutorOferta(user);
		o.setClassificado(c);
		o.setDataOferta();
		
		if(c.getMelhorOferta() == null){
			o.setPreco(oferta.getPreco());
			odao.inserir(o);			
		}
		else{
			o.setPreco(c.getMelhorOferta().getPreco());
			o.setId_oferta(c.getMelhorOferta().getId_oferta());
			if(o.getPreco() < oferta.getPreco()){
				o.setPreco(oferta.getPreco());
				System.out.println("now aqui");
				odao.atualizar(o);
			}
		}
		c.setMelhorOferta(o);
		this.cdao.atualizar(c);	
		model.addAttribute("classificados", cdao.listar());
		return "menuLeitor";
	}

}
