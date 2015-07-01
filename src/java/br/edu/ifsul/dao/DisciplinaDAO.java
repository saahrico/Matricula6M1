package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Disciplina;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Samantha
 */
@Stateful
public class DisciplinaDAO<T> extends GenericDAO<Disciplina> implements Serializable {

    public DisciplinaDAO(){
        super();
        // definindo a classe persistence
        super.setPersistentClass(Disciplina.class);
        // definindo as ordenaçõe possiveis
        super.getListOrder().add(
            new Order("id", "ID", "="));
        super.getListOrder().add(
            new Order("nome", "Nome", "like"));    
                super.getListOrder().add(
            new Order("descricao", "Descrição", "like")); 
        // definir qual a ordenação padrão
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));                
           
    }    
}