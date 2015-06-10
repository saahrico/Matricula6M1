package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Samantha
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "aluno")
public class Aluno extends Pessoa implements Serializable {
    
    @Length(max = 10, min = 10,message = "O RG deve ter {max} caracteres")
    @NotEmpty(message = "O RG deve ser informado")
    @Column(name = "rg",length = 10,nullable = false)
    private String rg;
    
    @Column(name = "sexo",length = 1,nullable = false)
    private Character sexo;
    
    @NotNull(message = "O status deve ser informado")
    @Column(name = "status", nullable = false)
    private Boolean status;
        
    public Aluno() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }   
}