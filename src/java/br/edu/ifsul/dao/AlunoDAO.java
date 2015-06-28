package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Aluno;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Jorge Luis Boeira Bavaresco jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Stateful
public class AlunoDAO<T> extends GenericDAO<Aluno> implements Serializable {

    public AlunoDAO(){
        super();
        // definindo a classe persistence
        super.setPersistentClass(Aluno.class);
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