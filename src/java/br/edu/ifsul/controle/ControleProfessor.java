package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ProfessorDAO;
import br.edu.ifsul.modelo.Professor;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Samantha
 */
@ManagedBean(name = "controleProfessor")
@ViewScoped
public class ControleProfessor implements Serializable {

    @EJB
    private ProfessorDAO<Professor> dao;
    private Professor objeto;

    public ControleProfessor() {

    }

    public String listar() {
        return "/privado/professor/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Professor();
    }

    public void salvar() {
        try {
            if (objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir: " + e.getMessage());
        }
    }

    public void editar(Integer id) {
        try {
            objeto = dao.getObjectById(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + e.getMessage());
        }
    }

    public void remover(Integer id) {
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: "+e.getMessage());
        }
    }


    public Professor getObjeto() {
        return objeto;
    }

    public void setObjeto(Professor objeto) {
        this.objeto = objeto;
    }

    public ProfessorDAO<Professor> getDao() {
        return dao;
    }

    public void setDao(ProfessorDAO<Professor> dao) {
        this.dao = dao;
    }
}