/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Samantha
 */

@Entity
@Table(name = "matricula")
public class Matricula implements Serializable{
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_produto", sequenceName = "gen_produto_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id_produto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "num_matricula", nullable = false)
    private Integer num_matricula;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data deve ser informada")
    @Column(name = "data", nullable = false)
    private Calendar data;
    
    @NotNull(message = "O status deve ser informado")
    @Column(name = "status", nullable = false)
    private Boolean status;
    
    @Length(max = 30, message = "O complemento não deve ultrapassar {max} caracteres")
    @Column(name = "complemento",length = 30)        
    private String complemento;
    
    @ManyToOne
    @JoinColumn(name = "aluno", referencedColumnName = "id", nullable = false)
    @NotNull(message = "O aluno deve ser informado")
    private Aluno aluno;
    
    @ManyToOne
    @JoinColumn(name = "turma", referencedColumnName = "id", nullable = false)
    @NotNull(message = "A turma deve ser informada")
    private Turma turma;

    public Matricula() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum_matricula() {
        return num_matricula;
    }

    public void setNum_matricula(Integer num_matricula) {
        this.num_matricula = num_matricula;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Matricula other = (Matricula) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Matricula{" + "num_matricula=" + num_matricula + '}';
    }
    
}
