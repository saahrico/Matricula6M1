package br.edu.ifsul.controle;

import br.edu.ifsul.dao.ProfessorDAO;
import br.edu.ifsul.modelo.Professor;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest; 

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * jorge.bavaresco@passofundo.ifsul.edu.br
 */
@ManagedBean(name = "controleLogin")
@SessionScoped
public class ControleLogin implements Serializable {
    
    @EJB
    private ProfessorDAO<Professor> dao;
    private Professor usuarioLogado;
    private String usuario;
    private String senha;
    
    public ControleLogin(){
        
    }
    
    public String paginaLogin(){
        return "/login?faces-redirect=true";
    }
    
    public String efetuarLogin(){
        if (dao.login(usuario, senha)){
            usuarioLogado = dao.localizarProfessorPorNome(usuario);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) 
                    context.getExternalContext().getRequest();
            Util.mensagemInformacao("Usuário logado com sucesso!");
            return "/index";
        } else {
            Util.mensagemErro("Usuário ou senha inválidos!");
            return "/login";
        }
    }
    
    public String efetuarLogOut(){
        usuarioLogado = null;
        Util.mensagemInformacao("Logout efetuado com sucesso!");
        return "/index";
    }
    

    public ProfessorDAO<Professor> getDao() {
        return dao;
    }

    public void setDao(ProfessorDAO<Professor> dao) {
        this.dao = dao;
    }

    public Professor getProfessorLogado() {
        return usuarioLogado;
    }

    public void setProfessorLogado(Professor usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public String getProfessor() {
        return usuario;
    }

    public void setProfessor(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}