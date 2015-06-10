/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Samantha
 */

@Entity
@Table(name = "turma")
public class Turma implements Serializable{
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_id_produto", sequenceName = "gen_produto_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id_produto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Length(max = 10, message = "O turno não deve ultrapassar {max} caracteres")
    @Column(name = "turno",length = 10)        
    private String turno ;
    
    @Column(name = "ano", nullable = false)
    private int ano;
    
    @Column(name = "total_vagas", nullable = false)
    private int total_vagas;
    
    @Column(name = "sala", nullable = false)
    private int sala;
    
    //FALTA COLOCAR DISCIPLINA E TAL

    public Turma() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getTotal_vagas() {
        return total_vagas;
    }

    public void setTotal_vagas(int total_vagas) {
        this.total_vagas = total_vagas;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Turma{" + "turno=" + turno + '}';
    }
   
}