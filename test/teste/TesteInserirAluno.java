package teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Samantha
 */
public class TesteInserirAluno {
    
    EntityManagerFactory emf;
    EntityManager em ;
    
    public TesteInserirAluno() {
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
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
}
