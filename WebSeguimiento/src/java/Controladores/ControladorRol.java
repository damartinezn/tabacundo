/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entity.Menu;
import Entity.Privilegios;
import Entity.Rol;
import Session.MenuFacadeLocal;
import Session.PrivilegiosFacadeLocal;
import Session.RolFacadeLocal;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Full Limpio
 */
@ManagedBean(name = "ControladorRol")
@SessionScoped
public class ControladorRol implements Serializable {

    private Rol rol;
    private List<Rol> listaRol = new ArrayList();
    @EJB
    private RolFacadeLocal ejbRol;

    private Menu menu;
    private List<Menu> listaMenu = new ArrayList();
    private List<Menu> auxListaMenu = new ArrayList();
    @EJB
    private MenuFacadeLocal ejbMenu;

    private Privilegios privilegio;
    private List<Privilegios> listPrivilegio;
    @EJB
    private PrivilegiosFacadeLocal ejbPrivilegio;

    private List<String> auxLista;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Rol> getListaRol() {
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
    }

    public RolFacadeLocal getEjbRol() {
        return ejbRol;
    }

    public void setEjbRol(RolFacadeLocal ejbRol) {
        this.ejbRol = ejbRol;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Menu> getListaMenu() {
        return listaMenu;
    }

    public void setListaMenu(List<Menu> listaMenu) {
        this.listaMenu = listaMenu;
    }

    public MenuFacadeLocal getEjbMenu() {
        return ejbMenu;
    }

    public void setEjbMenu(MenuFacadeLocal ejbMenu) {
        this.ejbMenu = ejbMenu;
    }

    public List<Menu> getAuxListaMenu() {
        return auxListaMenu;
    }

    public void setAuxListaMenu(List<Menu> auxListaMenu) {
        this.auxListaMenu = auxListaMenu;
    }

    public Privilegios getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(Privilegios privilegio) {
        this.privilegio = privilegio;
    }

    public List<Privilegios> getListPrivilegio() {
        return listPrivilegio;
    }

    public void setListPrivilegio(List<Privilegios> listPrivilegio) {
        this.listPrivilegio = listPrivilegio;
    }

    public PrivilegiosFacadeLocal getEjbPrivilegio() {
        return ejbPrivilegio;
    }

    public void setEjbPrivilegio(PrivilegiosFacadeLocal ejbPrivilegio) {
        this.ejbPrivilegio = ejbPrivilegio;
    }

    public List<String> getAuxLista() {
        return auxLista;
    }

    public void setAuxLista(List<String> auxLista) {
        this.auxLista = auxLista;
    }

    @PostConstruct
    public void init() {
        rol = new Rol();
        listaRol = ejbRol.findAll();
        listaMenu = ejbMenu.findAll();
        auxListaMenu = new ArrayList();
        privilegio = new Privilegios();
        menu = new Menu();
        listPrivilegio = new ArrayList();
    }

    public String crearRol() {
        ejbRol.create(rol);
        privilegio.setRolId(rol);
        for (String m : auxLista) {
            privilegio.setMenuId(ejbMenu.find(Integer.parseInt(m)));
            ejbPrivilegio.create(privilegio);
        }

        rol = new Rol();
        privilegio = new Privilegios();
        auxListaMenu = new ArrayList();
        listaRol = ejbRol.findAll();
        auxLista = new ArrayList();
        return "verRoles.xhtml?faces-redirect=true";
    }

    public void editarRol(Rol auxRol) {
        ejbRol.edit(auxRol);
    }

    public void eliminarRol(Rol auxRol) {
        ejbRol.remove(auxRol);
        listaRol = ejbRol.findAll();
    }
    
    public void listaMenus(Rol auxRol)
    {
        listPrivilegio = ejbPrivilegio.listaMenu(auxRol);
    }
}
