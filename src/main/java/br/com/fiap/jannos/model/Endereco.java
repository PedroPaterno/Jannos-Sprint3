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
@Table(name = "t_goandgetit_endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Não é possível cadastrar um endereço sem cep")
	@Size(max = 8, message = "O cep deve conter 8 digitos sem utilizar '.' e '-'")
	private String cep;
	
	@NotNull(message = "Não é possível cadastrar um endereço sem número")
	@Min(value = 1, message = "O número deve ser maior que 0")
	@Max(value = 9999, message = "O número deve ser menor que 9999")
	private Integer numero;

	@Size(max = 255, message = "O complemento deve comter no máximo 255 caracteres.")
	private String complemento;
	
	private String latitude;
	
	private String longitude;
	
	public class EnderecoBuilder{
		
		private Long id;
		private String cep;
		private Integer numero;
		private String complemento;
		private String latitude;
		private String longitude;
		
		public EnderecoBuilder setId(Long id) {
			this.id = id;
			return this;
		}
		
		public EnderecoBuilder setCep(String cep) {
			this.cep = cep;
			return this;
		}
		
		public EnderecoBuilder setNumero(Integer numero) {
			this.numero = numero;
			return this;
		}
		
		public EnderecoBuilder setComplemento(String complemento) {
			this.complemento = complemento;
			return this;
		}
		
		public EnderecoBuilder setLatitude(String latitude) {
			this.latitude = latitude;
			return this;
		}
		
		public EnderecoBuilder setLongitude(String longitude) {
			this.longitude = longitude;
			return this;
		}
		
		public Endereco build() {
			return new Endereco(this);
		}
		
		
	}
	
	public Endereco(EnderecoBuilder eb) {
		this.id = eb.id;
		this.cep = eb.cep;
		this.numero = eb.numero;
		this.complemento = eb.complemento;
		this.latitude = eb.latitude;
		this.longitude = eb.longitude;
	}
	
	public EnderecoBuilder toBuilder() {
		return new EnderecoBuilder().
		setCep(this.cep).
		setNumero(this.numero).
		setComplemento(this.complemento).
		setLatitude(this.latitude).
		setLongitude(this.longitude);
	}
		
	
	public Endereco(Long id, String cep, Integer numero, String complemento,String latitude, String longitude) {
		super();
		this.id = id;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Endereco() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	
	
	
}
