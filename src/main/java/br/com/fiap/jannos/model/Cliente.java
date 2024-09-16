package br.com.fiap.jannos.model;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "t_goandgetit_cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Não é possível cadastrar um cliente sem nome")
	@Size(min = 3, max = 255, message = "Não é possível cadastrar um cliente com menos de 3 letras")
	private String nome;
	
    @Email(message = "Email inválido")
    @NotNull(message = "Não é possível cadastrar um cliente sem email")
    private String email;
    
    @CPF(message = "CPF invávlido")
    @NotNull(message = "Não é possível cadastrar um cliente sem CPF")
    private String cpf;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    @Valid
    @NotNull(message = "Endereço é obrigatorio")
    private Endereco endereco;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_nota")
	@Valid
	@NotNull(message = "Nota é obrigatoria")
	private Nota nota;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
	
	
	
}
