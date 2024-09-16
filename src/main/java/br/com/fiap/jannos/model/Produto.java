package br.com.fiap.jannos.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "t_goandgetit_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Não é possível cadastrar um produto sem nome")
	@Size(min = 3, max = 255, message = "Não é possível cadastrar um produto com menos de 3 letras")
	private String nome;
	
	@NotNull(message = "Não é possível cadastrar um produto sem descricao")
	@Size(max = 255, message = "A descrição deve ser de no máximo 255 caracteres.")
    private String descricao;
	
	@NotNull(message = "Não é possível cadastrar um produto sem seu tipo")
	@Size(max = 255, message = "A tipo deve ser de no máximo 255 caracteres.")
    private String tipo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_anuncio")
	@Valid
	@NotNull(message = "Anuncio é obrigatorio")
	private Anuncio anuncio;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_loja")
	@Valid
	@NotNull(message = "Loja é obrigatoria")
	private Loja loja;
	
	public class ProdutoBuilder {
		private Long id;
		private String nome;
	    private String descricao;
	    private String tipo;
		private Anuncio anuncio;
		private Loja loja;
		
		public ProdutoBuilder setId(Long id) {
			this.id = id;
			return this;
		}
		public ProdutoBuilder setNome(String nome) {
			this.nome = nome;
			return this;
		}
		public ProdutoBuilder setDescricao(String descricao) {
			this.descricao = descricao;
			return this;
		}
		public ProdutoBuilder setTipo(String tipo) {
			this.tipo = tipo;
			return this;
		}
		public ProdutoBuilder setAnuncio(Anuncio anuncio) {
			this.anuncio = anuncio;
			return this;
		}
		public ProdutoBuilder setLoja(Loja loja) {
			this.loja = loja;
			return this;			
		}
		
		public ProdutoBuilder setIdAnuncio(Long anuncio_id) {
			this.anuncio.setId(anuncio_id);
			return this;
		}
		public ProdutoBuilder setIdLoja(Long loja_id) {
			this.loja.setId(loja_id);
			return this;
		}
		
		public Produto build() {
			return new Produto(this);
		}
		
	}
	
	public Produto(ProdutoBuilder pb) {
		this.id = pb.id;
		this.nome = pb.nome;
		this.descricao = pb.descricao;
		this.tipo = pb.tipo;
		this.anuncio = pb.anuncio;
		this.loja = pb.loja;
	}
	
	public ProdutoBuilder toBuilder() {
		return new ProdutoBuilder()
		.setId(this.id)
		.setNome(this.nome)
		.setDescricao(this.descricao)
		.setTipo(this.tipo)
		.setAnuncio(this.anuncio)
		.setLoja(this.loja);
	}
	
	

	public Produto(Long id, String nome, String descricao, String tipo, Anuncio anuncio, Loja loja) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
		this.anuncio = anuncio;
		this.loja = loja;
	}
	
	public Produto(Long id, String nome, String descricao, String tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
	}
	
	public Produto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	
	
}
