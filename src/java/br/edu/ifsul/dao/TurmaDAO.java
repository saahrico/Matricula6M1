package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Turma;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Samantha
 */
@Stateful
public class TurmaDAO<T> extends GenericDAO<Turma> implements Serializable {

    public TurmaDAO(){
        super();
        // definindo a classe persistence
        super.setPersistentClass(Turma.class);
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
}