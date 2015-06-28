package teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifsul.modelo.Professor;
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
public class TesteInserirProfessor {
    
    EntityManagerFactory emf;
    EntityManager em ;
    
    public TesteInserirProfessor() {
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
            Professor pro = new Professor();
            pro.setNome("Larissa");
            pro.setNascimento(Calendar.getInstance());
            pro.setEmail("larissa@gmail.com");
            pro.setBairro("Sao Jose");
            pro.setEndereco("Rua Serjipe");
            pro.setCep("99050-030");
            pro.setCpf("037.368.340-55");    
            pro.setCarga_horaria(8.0);
            pro.setLogin("larissa");
            pro.setSenha("123");
            pro.setStatus(true);
                       
            em.getTransaction().begin();
            em.persist(pro);
            em.getTransaction().commit();
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
}