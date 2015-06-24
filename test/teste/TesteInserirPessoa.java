package teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifsul.modelo.Aluno;
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
public class TesteInserirPessoa {
    
    EntityManagerFactory emf;
    EntityManager em ;
    
    public TesteInserirPessoa() {
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
            Aluno alu = new Aluno();
            alu.setNome("Joao");
            alu.setNascimento(Calendar.getInstance());
            alu.setEmail("sah.rico@gmail.com");
            alu.setBairro("Centro");
            alu.setEndereco("Rua sete de Setembro");
            alu.setCep("99050-030");
            alu.setLogin("joao");
            alu.setSenha("123");          
            alu.setSexo('F');
            alu.setRg("9113411641");
            alu.setStatus(true);
                       
            em.getTransaction().begin();
            em.persist(alu);
            em.getTransaction().commit();
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
}