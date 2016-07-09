package br.ufc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.SecaoDAO;
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
	

}
