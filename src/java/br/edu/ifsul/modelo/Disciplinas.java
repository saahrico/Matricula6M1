/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Samantha
 */

@Entity
@Table(name = "disciplinas")
public class Disciplinas implements Serializable{
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_produto", sequenceName = "gen_produto_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id_produto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotEmpty(message = "O nome deve ser informado")
    @Length(max = 50, message = "O  nome não deve ultrapassar {max} caracteres")
    @Column(name = "nome",length = 50, nullable = false)
    private String nome;
    
    @Column(name = "carga_horaria", nullable = false)
    private Double carga_horaria;
    
    @Length(max = 50, message = "A descrição não deve ultrapassar {max} caracteres")
    @Column(name = "descrição",length = 50)        
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "professor", referencedColumnName = "id", nullable = false)
    @NotNull(message = "O professor deve ser informado")
    private Professor professor;
    
    @ManyToMany
    @JoinTable(name = "grade_curricular",
            // joinColumn se refere a coluna que armazena o id desta entidade
            joinColumns = 
            @JoinColumn(name = "disciplinas", referencedColumnName = "id"),
            // inverseJoinColumns se refere a coluna que armazena o id 
            //da entidade do outro lado da relação
            inverseJoinColumns = 
            @JoinColumn(name = "turma",referencedColumnName = "id"))    
    private List<Turma> grade_curricular = new ArrayList<>();

    public Disciplinas() {
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

    public Double getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Double carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        final Disciplinas other = (Disciplinas) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome ;
    }   

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Turma> getGrade_curricular() {
        return grade_curricular;
    }

    public void setGrade_curricular(List<Turma> grade_curricular) {
        this.grade_curricular = grade_curricular;
    }
}
