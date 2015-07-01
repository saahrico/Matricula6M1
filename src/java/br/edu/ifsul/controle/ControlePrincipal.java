package br.edu.ifsul.controle;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Samantha
 */
@ManagedBean(name = "controlePrincipal")
@RequestScoped
public class ControlePrincipal implements Serializable {

    public ControlePrincipal() {
    }
        
    public String home(){
        return "/index?faces-redirect=true";
    }
}