package teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Professor;
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
            alu.setSexo('F');
            alu.setRg("9113411641");
            alu.setStatus(true);
            
            Professor pro = new Professor();
            pro.setNome("Lucas");
            pro.setNascimento(Calendar.getInstance());
            pro.setEmail("lucas@gmail.com");
            pro.setBairro("Centro");
            pro.setEndereco("Rua sete de Setembro");
            pro.setCep("99050-030");
            pro.setCpf("037.368.340-55");    
            pro.setCarga_horaria(8.0);
            pro.setLogin("login");
            pro.setSenha("senha");
            pro.setStatus(true);
                       
            em.getTransaction().begin();
            em.persist(alu);
            em.persist(pro);
            em.getTransaction().commit();
            
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception);
    }
}