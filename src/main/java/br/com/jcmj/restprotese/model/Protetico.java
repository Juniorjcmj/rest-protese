package br.com.jcmj.restprotese.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
public class Protetico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
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


    public Protetico(Integer id, @NotBlank(message = "Nome é obrigatório") String nome,
                     @NotBlank(message = "CPF ou CNPJ é obrigatório") String cpfCnpj,
                     @NotBlank(message = "Endereço é obrigatório") String endereco, String telFixo, String telCel, String email,
                     Double credito) {
        super();
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.telFixo = telFixo;
        this.telCel = telCel;
        this.email = email;
        this.credito = credito;
    }

    public Protetico() {
        super();
    }
    @Override
    public String toString() {
        return "Protetico [nome=" + nome + ", cpfCnpj=" + cpfCnpj + ", endereco=" + endereco + ", telFixo=" + telFixo
                + ", telCel=" + telCel + ", email=" + email + ", credito=" + credito + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
        result = prime * result + ((credito == null) ? 0 : credito.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((telCel == null) ? 0 : telCel.hashCode());
        result = prime * result + ((telFixo == null) ? 0 : telFixo.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Protetico other = (Protetico) obj;
        if (cpfCnpj == null) {
            if (other.cpfCnpj != null)
                return false;
        } else if (!cpfCnpj.equals(other.cpfCnpj))
            return false;
        if (credito == null) {
            if (other.credito != null)
                return false;
        } else if (!credito.equals(other.credito))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (endereco == null) {
            if (other.endereco != null)
                return false;
        } else if (!endereco.equals(other.endereco))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (telCel == null) {
            if (other.telCel != null)
                return false;
        } else if (!telCel.equals(other.telCel))
            return false;
        if (telFixo == null) {
            if (other.telFixo != null)
                return false;
        } else if (!telFixo.equals(other.telFixo))
            return false;
        return true;
    }



}
