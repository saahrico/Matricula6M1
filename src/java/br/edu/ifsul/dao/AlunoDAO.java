/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Aluno;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Samantha
 */

@Stateless
public class AlunoDAO implements Serializable{
    
    @PersistenceContext(unitName = "Matricula6M1PU")
    private EntityManager em;
    private List<Aluno> listarTodos;

    public AlunoDAO() {
    }
    
    public void persistir(Aluno objeto) throws Exception {
        em.persist(objeto);
    }
    
    public void merge(Aluno objeto) throws Exception {
        em.merge(objeto);
    }
    
    public void remover(Aluno objeto) throws Exception {
        objeto = em.merge(objeto);
        em.remove(objeto);
    }
    
    public Aluno getObjectById(Integer id) throws Exception {
        Aluno obj = em.find(Aluno.class, id);              
        return obj ;
    }
    
    public List<Aluno> getListarTodos() {
        return em.createQuery("from Aluno order by nome").getResultList();
    }
    
    public void setListarTodos(List<Aluno> listarTodos) {
        this.listarTodos = listarTodos;
    }    
    
    public EntityManager getEm() {
        return em;
    }
    
    public void setEm(EntityManager em) {
        this.em = em;
    }
}