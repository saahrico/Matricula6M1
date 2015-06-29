package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Matricula;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Samantha
 */
@Stateful
public class MatriculaDAO<T> extends GenericDAO<Matricula> implements Serializable {

    public MatriculaDAO(){
        super();
        // definindo a classe persistence
        super.setPersistentClass(Matricula.class);
        // definindo as ordenaçõe possiveis
        super.getListOrder().add(
            new Order("id", "ID", "="));
        super.getListOrder().add(
            new Order("num_matricula", "Numero de Matricula", "like"));        
        // definir qual a ordenação padrão
        super.setCurrentOrder((Order) super.getListOrder().get(1));
        super.setFilter("");
        super.setConverterOrder(new ConverterOrder(super.getListOrder()));                
    }
}