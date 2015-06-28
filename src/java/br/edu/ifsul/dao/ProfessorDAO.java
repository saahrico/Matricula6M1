package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Professor;
import java.io.Serializable;
import javax.ejb.Stateful;
import javax.persistence.Query;

/**
 *
 * @author Jorge Luis Boeira Bavaresco jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Stateful
public class ProfessorDAO<T> extends GenericDAO<Professor> implements Serializable {

    public ProfessorDAO(){
        super();
        // definindo a classe persistence
        super.setPersistentClass(Professor.class);
        // definindo as ordenaçõe possiveis
        super.getListOrder().add(
            new Order("id", "ID", "="));
        super.getListOrder().add(
            new Order("nome", "Nome", "like"));        
        // definir qual a ordenação padrão
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));                
    }
    
     @Override
    public Professor getObjectById(Integer id) throws Exception{
        Professor obj = super.getEm().find(Professor.class, id);
        return obj;
    }
    
    public Boolean login(String usuario, String senha){
        Query query = super.getEm().createQuery("from Professor where upper(login) = :usuario "+
                " and upper(senha) = :senha and status = true");
        query.setParameter("usuario", usuario.toUpperCase());
        query.setParameter("senha", senha.toUpperCase());
        if(!query.getResultList().isEmpty()){
            return true;
        } else {
            return false;
        }
    }
    
    public Professor localizarProfessorPorNome(String usuario) {
        Professor obj = (Professor) super.getEm().createQuery("from Professor where upper(login) = :usuario")
                .setParameter("usuario", usuario.toUpperCase()).getSingleResult();
        return obj;            
    }
}