package br.com.fiap.jannos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "t_goandgetit_nota")
public class Nota {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Não é possível cadastrar uma nota sem seu valor")
	@Min(value = 1, message = "A nota deve ser maior que 0")
	@Max(value = 10, message = "A nota deve ser menor que 10")
	private Integer valor;
	
	@Size(max = 255, message = "A media deve conter no maximo 255 caracteres")
	private String media;
	
	@Size(max = 255, message = "A descrição deve ser de no máximo 255 caracteres.")
    private String descricao;
	
	public class NotaBuilder {
		private Long id;
		private Integer valor;
		private String media;
	    private String descricao;
	    
		public NotaBuilder setId(Long id) {
			this.id = id;
			return this;
		}
		public NotaBuilder setValor(Integer valor) {
			this.valor = valor;
			return this;
		}
		public NotaBuilder setMedia(String media) {
			this.media = media;
			return this;
		}
		public NotaBuilder setDescricao(String descricao) {
			this.descricao = descricao;
			return this;
		}
		
		public Nota build() {
			return new Nota(this);
		}
	    
	}
	
	public Nota(NotaBuilder nb) {
		this.id = nb.id;
		this.valor = nb.valor;
		this.media = nb.media;
		this.descricao = nb.descricao;
	}
	
	public NotaBuilder toBuilder() {
		return new NotaBuilder().
		setValor(this.valor).
		setMedia(this.media).
		setDescricao(this.descricao);
	}
	

	public Nota(Long id, Integer valor, String media, String descricao) {
		super();
		this.id = id;
		this.valor = valor;
		this.media = media;
		this.descricao = descricao;
	}
	
	public Nota() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
