package br.com.jcmj.restprotese.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message="Nome é obrigatório")
	private String nome;
	@NotBlank(message="CPF ou CNPJ é obrigatório")
	private String cpfCnpj;
	@NotBlank(message="Endereço é obrigatório")
	private String endereco;
	private String telFixo;
	private String telCel;
	private String email;
		
	private Double credito;
        private String avatar;
	
	public Cliente(Integer id, String nome, String cpfCnpj, String endereco, String telFixo, String telCel,Double credito,
			String email, String avatar) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpfCnpj = cpfCnpj;
		this.endereco = endereco;
		this.telFixo = telFixo;
		this.telCel = telCel;
		this.email = email;
		this.credito=credito;
                this.avatar = avatar;
	}
        
        
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
        
        
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelFixo() {
		return telFixo;
	}
	public void setTelFixo(String telFixo) {
		this.telFixo = telFixo;
	}
	public String getTelCel() {
		return telCel;
	}
	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getCredito() {
		return credito;
	}
	public void setCredito(Double credito) {
		this.credito = credito;
	}
	
	public String  contato (){
		
		return "Tel Fixo : "+ telFixo  +  "  Tel Cel:" + telCel + "  Email :"+ email;
	}
	
	
}
