package br.edu.ifsul.controle;

import br.edu.ifsul.dao.TurmaDAO;
import br.edu.ifsul.dao.DisciplinaDAO;
import br.edu.ifsul.modelo.Turma;
import br.edu.ifsul.modelo.Disciplina;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Samantha
 */
@ManagedBean(name = "controleTurma")
@ViewScoped
public class ControleTurma implements Serializable {

    @EJB
    private TurmaDAO dao;
    private Turma objeto;
    private Disciplina disciplina;
    private DisciplinaDAO daoDisciplina;

    public ControleTurma() {

    }

    public String listar() {
        return "/privado/turma/listar?faces-redirect=true";
    }

    public void novo() {
        objeto = new Turma();
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
    
    public void adicionarDisciplina(){
        objeto.adicionarDisciplinas(disciplina);
        Util.mensagemInformacao("Disciplina adicionada com sucesso");
    }
    
    public void removerDisciplina(Disciplina obj){
        objeto.removerDisciplinas(obj);
        Util.mensagemInformacao("Disciplina removida com sucesso");
    }

    public TurmaDAO getDao() {
        return dao;
    }

    public void setDao(TurmaDAO dao) {
        this.dao = dao;
    }

    public Turma getObjeto() {
        return objeto;
    }

    public void setObjeto(Turma objeto) {
        this.objeto = objeto;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public DisciplinaDAO getDaoDisciplina() {
        return daoDisciplina;
    }

    public void setDaoDisciplina(DisciplinaDAO daoDisciplina) {
        this.daoDisciplina = daoDisciplina;
    }
}