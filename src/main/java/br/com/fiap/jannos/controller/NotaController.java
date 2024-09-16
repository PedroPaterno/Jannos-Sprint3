package br.com.fiap.jannos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.jannos.model.Nota;
import br.com.fiap.jannos.repository.NotaRepository;
import jakarta.validation.Valid;

@Controller
public class NotaController {
	
	@Autowired
	private NotaRepository repN;

	
	@GetMapping("/notas")
	public ModelAndView retornaListaNotas() {
		
		List<Nota> listaN = repN.findAll();

		ModelAndView mv = new ModelAndView("index_nota");
		mv.addObject("notas", listaN);

		return mv;
		
	}
	
	@GetMapping("/cadastro_nota")
	public ModelAndView retornaFormCadNota() {

		ModelAndView mv = new ModelAndView("form_cad_nota");
		mv.addObject("nota", new Nota());
		return mv;

	}
	
	@PostMapping("/inserir_nota")
	public ModelAndView cadastroNota(@Valid Nota nova_nota, BindingResult bd) {

		if (bd.hasErrors()) {
			ModelAndView mv = new ModelAndView("form_cad_nota");
			mv.addObject("nota", nova_nota);
			return mv;
		} else {
			Nota nota = new Nota();
			nota.setValor(nova_nota.getValor());
			nota.setMedia(nova_nota.getMedia());
			nota.setDescricao(nova_nota.getDescricao());

			repN.save(nota);

			return new ModelAndView("redirect:/notas");
		}

	}
	
	@GetMapping("/detalhes_nota/{id}")
	public ModelAndView retornaDetalhesNota(@PathVariable Long id) {
	
		Optional<Nota> op = repN.findById(id);
		
		if(op.isPresent()) {
			Nota nota = op.get();
			
			ModelAndView mv = new ModelAndView("detalhes_nota");
			mv.addObject("nota", nota);
			return mv;
			
		} else {
			return new ModelAndView("redirect:/notas");
		}
		
	}
	
	@GetMapping("/atualiza_nota/{id}")
	public ModelAndView retornaAtualizaNota(@PathVariable Long id) {
		
		Optional<Nota> op = repN.findById(id);
		
		if(op.isPresent()) {
			Nota nota = op.get();
			
			ModelAndView mv = new ModelAndView("form_att_nota");
			mv.addObject("nota", nota);
			return mv;
			
		} else {
			return new ModelAndView("redirect:/notas");
		}
		
	}
	
	@PostMapping("/atualiza_dados_nota/{id}")
	public ModelAndView atualizarNota(@PathVariable Long id, @Valid Nota nota, BindingResult bd) {
		
		if(bd.hasErrors()) {
			ModelAndView mv = new ModelAndView("form_att_nota");
			mv.addObject("nota",nota);
			return mv;
		} else {
			
			Optional<Nota> op = repN.findById(id);
			
			if(op.isPresent()) {
				Nota nota1 = op.get();
				nota1 = nota.toBuilder().setId(nota1.getId()).build();
				
				repN.save(nota1);
				
				return new ModelAndView("redirect:/notas");
			} else {
				return new ModelAndView("redirect:/notas");
			}
			
		}
		
	}
	
	@GetMapping("/remover_nota/{id}")
	public String removerNota(@PathVariable Long id) {
		
		Optional<Nota> op = repN.findById(id);
		
		if(op.isPresent()) {
			repN.deleteById(id);
			return "redirect:/notas";
		} else {
			return "redirect:/notas";
		}
		
	}
	
}
