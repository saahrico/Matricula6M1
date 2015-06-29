package teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Matricula;
import br.edu.ifsul.modelo.Professor;
import br.edu.ifsul.modelo.Turma;
import java.util.Calendar;
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
public class TesteInserirMatricula {
    
    EntityManagerFactory emf;
    EntityManager em ;
    
    public TesteInserirMatricula() {
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

            Matricula mat = new Matricula();
            mat.setNum_matricula(1111);
            mat.setData(Calendar.getInstance());
            mat.setAluno(em.find(Aluno.class, 8));
            mat.setTurma(em.find(Turma.class, 1));
            mat.setComplemento("Matricula de tal aluno");
            mat.setStatus(true);
                       
            em.getTransaction().begin();
            em.persist(mat);
            em.getTransaction().commit();
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
}