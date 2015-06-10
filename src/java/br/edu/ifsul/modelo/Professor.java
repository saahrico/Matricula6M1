package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Samantha
 */
@Entity
@Table(name = "professor")
public class Professor extends Pessoa implements Serializable {

    @Column(name = "cod_professor")  
    private String cod_professor;
    
    @CPF(message = "CPF inválido")
    @Length(min = 14,max = 14,message = "CPF inválido")
    @NotEmpty(message = "O CPF deve ser informado")
    @Column(name = "cpf", length = 14,nullable = false)
    private String cpf;
    
    @Column(name = "carga_horaria", nullable = false)
    private Double carga_horaria;
    
    @NotNull(message = "O status deve ser informado")
    @Column(name = "status", nullable = false)
    private Boolean status;

    public Professor() {
    }

}