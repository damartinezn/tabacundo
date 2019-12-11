/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Entity.Unidad;
import Session.UnidadFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Full Limpio
 */

@ManagedBean(name = "ControladorUnidad")
@SessionScoped
public class ControladorUnidad implements Serializable{
    
    private Unidad unidad;
    private List<Unidad> listaUnidad = new ArrayList();
    private List<Unidad> unidadPadre = new ArrayList();
    @EJB
    private UnidadFacadeLocal ejbUnidad;

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public List<Unidad> getListaUnidad() {
        return listaUnidad;
    }

    public void setListaUnidad(List<Unidad> listaUnidad) {
        this.listaUnidad = listaUnidad;
    }

    public UnidadFacadeLocal getEjbUnidad() {
        return ejbUnidad;
    }

    public void setEjbUnidad(UnidadFacadeLocal ejbUnidad) {
        this.ejbUnidad = ejbUnidad;
    }

    public List<Unidad> getUnidadPadre() {
        return unidadPadre;
    }

    public void setUnidadPadre(List<Unidad> unidadPadre) {
        this.unidadPadre = unidadPadre;
    }
    
    
    
    @PostConstruct
    public void init() {
        unidad = new Unidad();
        listaUnidad = ejbUnidad.findAll();
        unidadPadre = ejbUnidad.findAll();
    }
    
    public String crearUnidad(){
        ejbUnidad.create(unidad);
        unidad = new Unidad();
        listaUnidad = ejbUnidad.findAll();
        unidadPadre = ejbUnidad.findAll();
        return "verUnidades.xhtml?faces-redirect=true";
    }
}
