package teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Disciplina;
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
public class TesteInserirTurma {
    
    EntityManagerFactory emf;
    EntityManager em ;
    
    public TesteInserirTurma() {
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

           /*  Turma tur = new Turma();
            tur.setNome("3M1");
            tur.setTurno("noite");
            tur.setAno(2015);
            tur.setTotal_vagas(40);
            tur.setSala(44)*/
            
            Turma obj = em.find(Turma.class,20);
            Disciplina dis = em.find(Disciplina.class,19);
            obj.adicionarDisciplinas(dis);
                       
            em.getTransaction().begin();
            //em.persist(tur);
            em.persist(obj);
            em.getTransaction().commit();
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
}