package teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.modelo.Professor;
import br.edu.ifsul.modelo.Turma;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Samantha
 */
public class TesteInserirDisciplina {
    
    EntityManagerFactory emf;
    EntityManager em ;
    
    public TesteInserirDisciplina() {
    }
    
    @Before
    public void setUp() {
        
        emf = Persistence.createEntityManagerFactory("Matricula6M1PULocal");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testar(){
        boolean exception = false ;
        try{

            Disciplina dis = new Disciplina();
            dis.setCarga_horaria(10.0);
            dis.setDescricao("tal");
            dis.setNome("Geografia");
            dis.setProfessor(em.find(Professor.class, 19));
                       
            em.getTransaction().begin();
            em.persist(dis);
            em.getTransaction().commit();
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
}