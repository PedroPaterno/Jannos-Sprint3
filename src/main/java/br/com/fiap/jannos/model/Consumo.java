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
@Table(name = "t_goandgetit_consumo")
public class Consumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Não é possível cadastrar consumo sem sua quantidade")
	@Size(min = 3, max = 255, message = "A quatidade deve ser de no máximo 255 caracteres")
	private String quantidade;
	
	@Size(max = 255, message = "A descrição deve ser de no máximo 255 caracteres.")
    private String descricao;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cliente")
	@Valid
	@NotNull(message = "Cliente é obrigatorio")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_anuncio")
	@Valid
	@NotNull(message = "Anuncio é obrigatorio")
	private Anuncio anuncio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}
	
	
	
}
