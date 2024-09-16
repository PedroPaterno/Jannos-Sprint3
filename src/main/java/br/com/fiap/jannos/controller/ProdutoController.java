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

import br.com.fiap.jannos.model.Produto;
import br.com.fiap.jannos.repository.ProdutoRepository;
import jakarta.validation.Valid;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repP;	
	
	@GetMapping("/produtos")
	public ModelAndView retornaListaJogadores() {

		List<Produto> listaP = repP.findAll();

		ModelAndView mv = new ModelAndView("index_produto");
		mv.addObject("produtos", listaP);

		return mv;

	}
	
	
	@GetMapping("/cadastro_produto")
	public ModelAndView retornaFormCadTime() {

		ModelAndView mv = new ModelAndView("form_cad_produto");
		mv.addObject("produto", new Produto());
		return mv;

	}

	@PostMapping("/inserir_produto")
	public ModelAndView cadastroProduto(@Valid Produto novo_produto, BindingResult bd) {

		if (bd.hasErrors()) {
			ModelAndView mv = new ModelAndView("form_cad_produto");
			mv.addObject("produto", novo_produto);
			return mv;
		} else {
			Produto produto = new Produto();
			produto.setNome(novo_produto.getNome());
			produto.setDescricao(novo_produto.getDescricao());
			produto.setTipo(novo_produto.getTipo());
			produto.setAnuncio(novo_produto.getAnuncio());
			produto.setLoja(novo_produto.getLoja());


			repP.save(produto);

			return new ModelAndView("redirect:/produtos");
		}

	}
	
	@GetMapping("/detalhes_produto/{id}")
	public ModelAndView retornaDetalhesProduto(@PathVariable Long id) {
	
		Optional<Produto> op = repP.findById(id);
		
		if(op.isPresent()) {
			Produto produto = op.get();
			
			ModelAndView mv = new ModelAndView("detalhes_produto");
			mv.addObject("produto", produto);
			return mv;
			
		} else {
			return new ModelAndView("redirect:/produtos");
		}
		
	}
	
	@GetMapping("/atualiza_produto/{id}")
	public ModelAndView retornaAtualizaProduto(@PathVariable Long id) {
		
		Optional<Produto> op = repP.findById(id);
		
		if(op.isPresent()) {
			Produto produto = op.get();
			
			ModelAndView mv = new ModelAndView("form_att_produto");
			mv.addObject("produto",produto);
			return mv;
			
		} else {
			return new ModelAndView("redirect:/produtos");
		}
		
	}
	
	
	@PostMapping("/atualizar_dados_produto/{id}")
	public ModelAndView atualizarProduto(@PathVariable Long id, @Valid Produto produto, BindingResult bd) {
		
		if(bd.hasErrors()) {
			ModelAndView mv = new ModelAndView("form_att_produto");
			mv.addObject("produto",produto);
			return mv;
		} else {
			
			Optional<Produto> op = repP.findById(id);
			
			if(op.isPresent()) {
				Produto produto1 = op.get();
				produto1 = produto.toBuilder().setId(produto1.getId()).build();
				
				repP.save(produto1);
				
				return new ModelAndView("redirect:/produtos");
			} else {
				return new ModelAndView("redirect:/produtos");
			}
			
		}
		
	}

	
	@GetMapping("/remover_produto/{id}")
	public String removerProduto(@PathVariable Long id) {
		
		Optional<Produto> op = repP.findById(id);
		
		if(op.isPresent()) {
			repP.deleteById(id);
			return "redirect:/produtos";
		} else {
			return "redirect:/produtos";
		}
		
	}
	

}
