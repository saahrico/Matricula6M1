package br.edu.ifsul.controle;

import br.edu.ifsul.dao.MatriculaDAO;
import br.edu.ifsul.modelo.Matricula;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Samantha
 */

@ManagedBean(name = "controleMatricula")
@ViewScoped
public class ControleMatricula implements Serializable {

    @EJB
    private MatriculaDAO<Matricula> dao;
    private Matricula objeto;

    public ControleMatricula() {

    }

    public String listar() {
        return "/privado/matricula/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Matricula();
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


    public Matricula getObjeto() {
        return objeto;
    }

    public void setObjeto(Matricula objeto) {
        this.objeto = objeto;
    }

    public MatriculaDAO<Matricula> getDao() {
        return dao;
    }

    public void setDao(MatriculaDAO<Matricula> dao) {
        this.dao = dao;
    }
}