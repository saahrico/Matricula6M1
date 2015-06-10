package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Samantha
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "pessoa")
public abstract class Pessoa implements Serializable {
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_pessoa")
    private Integer id;
    
    @NotEmpty(message = "O nome deve ser informado")
    @Length(max = 50, message = "O  nome não deve ultrapassar {max} caracteres")
    @Column(name = "nome",length = 50, nullable = false)
    private String nome;
       
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O nascimento deve ser informado")
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
       
    @Email(message = "Email inválido")
    @NotEmpty(message = "O email deve ser informado")
    @Length(max = 50, message = "O  email não deve ultrapassar {max} caracteres")
    @Column(name = "email",length = 50, nullable = false)        
    private String email;
    
    @NotEmpty(message = "O endereço deve ser informado")
    @Length(max = 50, message = "O  endereço não deve ultrapassar {max} caracteres")
    @Column(name = "endereco",length = 50, nullable = false)
    private String endereco;
      
    @NotEmpty(message = "O bairro deve ser informado")
    @Length(max = 20, message = "O  bairro não deve ultrapassar {max} caracteres")
    @Column(name = "bairro",length = 20, nullable = false)      
    private String bairro;
    
    @NotEmpty(message = "O cep deve ser informado")
    @Length(max = 9, message = "O  cep não deve ultrapassar {max} caracteres")
    @Column(name = "cep",length = 9, nullable = false)    
    private String cep;
    
    @NotEmpty(message = "O login deve ser informado")
    @Length(max = 20, message = "O login não pode ter mais de {max} caracteres")
    @Column(name = "login", length = 20, nullable = false, unique = true)
    private String login;
    
    @NotEmpty(message = "A senha deve ser informada")
    @Length(max = 20, message = "A senha não pode ter mais de {max} caracteres")
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;
    
    public Pessoa() {
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

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
}