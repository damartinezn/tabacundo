/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Entity.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Full Limpio
 */

@ManagedBean (name = "ControladorSesion")
@ViewScoped
public class ControladorSesion implements Serializable{
    

    
    public void verificarSesion()
    {
        try
        {
            FacesContext context = FacesContext.getCurrentInstance();
            Usuario usua = (Usuario)context.getExternalContext().getSessionMap().get("verifica");
             if (usua == null)
             {
                 context.getExternalContext().redirect("peu.xhtml");
             }
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void cerrarSesion()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
