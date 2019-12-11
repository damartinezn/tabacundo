/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entity.Menu;
import Entity.Privilegios;
import Entity.Rol;
import Entity.Unidad;
import Entity.Usuario;
import Session.MenuFacadeLocal;
import Session.PrivilegiosFacadeLocal;
import Session.RolFacadeLocal;
import Session.UnidadFacadeLocal;
import Session.UsuarioFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Full Limpio
 */
@ManagedBean(name = "ControladorUsuarios")
@SessionScoped
public class ControladorUsuarios implements Serializable {

    private Usuario usuario;
    private Usuario auxUsua;
    private List<Usuario> listaUsuarios;
    private List<Usuario> filtrarUsuarios;
    @EJB
    private UsuarioFacadeLocal ejbUsuarios;
    
    private Rol rol;
    private List<Rol> listaRol;
    @EJB
    private RolFacadeLocal ejbRol;
    
    private Unidad unidad;
    private List<Unidad> listaUnidad;
    @EJB
    private UnidadFacadeLocal ejbUnidad;
    
    private String mensaje;
    private String nuevoPassword;
    private String confirmePassword;
    
    private int auxRol = -1;
    private int auxUnidad = -1;

    private boolean isAdmin;
    private boolean isTramite;
    private boolean isIngresoTramite;
    private boolean isCompletar;
    private boolean isReporte;
    
    private Menu menu;
    private List<Menu> listaMenu;
    @EJB
    private MenuFacadeLocal ejbMenu;
    
    private Privilegios privilegio;
    private List<Privilegios> listPrivilegio;
    @EJB
    private PrivilegiosFacadeLocal ejbPrivilegio;
    
    public ControladorUsuarios() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public UsuarioFacadeLocal getEjbUsuarios() {
        return ejbUsuarios;
    }

    public void setEjbUsuarios(UsuarioFacadeLocal ejbUsuarios) {
        this.ejbUsuarios = ejbUsuarios;
    }

    public List<Usuario> getFiltrarUsuarios() {
        return filtrarUsuarios;
    }

    public void setFiltrarUsuarios(List<Usuario> filtrarUsuarios) {
        this.filtrarUsuarios = filtrarUsuarios;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNuevoPassword() {
        return nuevoPassword;
    }

    public void setNuevoPassword(String nuevoPassword) {
        this.nuevoPassword = nuevoPassword;
    }

    public String getConfirmePassword() {
        return confirmePassword;
    }

    public void setConfirmePassword(String confirmePassword) {
        this.confirmePassword = confirmePassword;
    }

    public Usuario getAuxUsua() {
        return auxUsua;
    }

    public void setAuxUsua(Usuario auxUsua) {
        this.auxUsua = auxUsua;
    }

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

    public int getAuxRol() {
        return auxRol;
    }

    public void setAuxRol(int auxRol) {
        this.auxRol = auxRol;
    }

    public int getAuxUnidad() {
        return auxUnidad;
    }

    public void setAuxUnidad(int auxUnidad) {
        this.auxUnidad = auxUnidad;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean isIsTramite() {
        return isTramite;
    }

    public void setIsTramite(boolean isTramite) {
        this.isTramite = isTramite;
    }

    public boolean isIsIngresoTramite() {
        return isIngresoTramite;
    }

    public void setIsIngresoTramite(boolean isIngresoTramite) {
        this.isIngresoTramite = isIngresoTramite;
    }

    public boolean isIsCompletar() {
        return isCompletar;
    }

    public void setIsCompletar(boolean isCompletar) {
        this.isCompletar = isCompletar;
    }

    public boolean isIsReporte() {
        return isReporte;
    }

    public void setIsReporte(boolean isReporte) {
        this.isReporte = isReporte;
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
    
    
    

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        listaUsuarios = ejbUsuarios.findAll();
        rol = new Rol();
        unidad = new Unidad();
        nuevoPassword = "";
        confirmePassword = "";
        auxRol = -1;
        auxUnidad = -1;
        this.resetar();
        menu = new Menu();
        listaMenu = ejbMenu.findAll();
        privilegio = new Privilegios();
        listPrivilegio = new ArrayList();
    }

    public String grabarUsuario() {
        usuario.setUsuarioPassword(this.encriptar(usuario.getUsuarioCi()));
        usuario.setUsuarioActivo(Boolean.FALSE);
        usuario.setRolId(ejbRol.find(auxRol));
        usuario.setUnidadId(ejbUnidad.find(auxUnidad));
        ejbUsuarios.create(usuario);
        listaUsuarios = ejbUsuarios.findAll();
        usuario = new Usuario();
        auxRol = -1;
        auxUnidad = -1;
        
        return "verUsuarios.xhtml?faces-redirect=true";
    }

    public String loguin() {
        Usuario us = null;
        String redirreccion = null;
        usuario.setUsuarioPassword(this.encriptar(usuario.getUsuarioPassword()));
        this.resetar();

        try {
            us = ejbUsuarios.loguin(usuario);
            auxUsua = ejbUsuarios.loguin(usuario);
            if (us != null) {
                if (us.getUsuarioActivo().equals(Boolean.FALSE)) {                    
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("verifica", us);
                    cargarRolUsuario(us);
                    redirreccion = "cambiarPassword?faces-redirect=true";
                } else {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("verifica", us);
                    cargarRolUsuario(us);
                    redirreccion = "menu?faces-redirect=true";
                }
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "AVISO", "CREDENCIALES INCORRECTAS"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "AVISO", "ERROR"));
        }
        usuario = new Usuario();
        
        return redirreccion;
    }
    
    public void cargarRolUsuario(Usuario usuario){
        listPrivilegio = ejbPrivilegio.listaMenu(usuario.getRolId());
        
        for(Privilegios p :listPrivilegio)
        {
            if(listaMenu.get(0).getMenuId() == p.getMenuId().getMenuId())
            {
                isTramite = true;
            }
            if(listaMenu.get(1).getMenuId() == p.getMenuId().getMenuId())
            {
                isIngresoTramite = true;
            }
            if(listaMenu.get(2).getMenuId() == p.getMenuId().getMenuId())
            {
                isCompletar = true;
            }
            if(listaMenu.get(3).getMenuId() == p.getMenuId().getMenuId())
            {
                isReporte = true;
            }
            if(listaMenu.get(4).getMenuId() == p.getMenuId().getMenuId())
            {
                isAdmin = true;
            }
        }
        
    }

    public void eliminarUsuarios(Usuario usua) {
        ejbUsuarios.remove(usua);
        listaUsuarios = ejbUsuarios.findAll();
    }

    public void editarUsuarios(Usuario usua) {
        ejbUsuarios.edit(usua);

    }

    public String recuperarPassword(Usuario usua) {
        boolean controlPassword = false;
        usua.setUsuarioPassword(this.encriptar(usua.getUsuarioCi()));
        mensaje = ejbUsuarios.recuperarPassword(usua, controlPassword);
        FacesContext context = FacesContext.getCurrentInstance();
        listaUsuarios = ejbUsuarios.findAll();
        context.addMessage(null, new FacesMessage("Successful", mensaje));

        return "recuperarPassword.xhtml?faces-redirect=true";
    }

    public String cambiarPassword() {
        boolean controlPassword = true;
        FacesContext context = FacesContext.getCurrentInstance();
        if (this.encriptar(nuevoPassword).equals(this.encriptar( confirmePassword))) {
            mensaje = ejbUsuarios.cambiarPassword(auxUsua, this.encriptar(nuevoPassword), controlPassword);

            context.addMessage(null, new FacesMessage("Successful", mensaje));
            //listaUsuarios = ejbUsuarios.findAll();
            //auxUsua= new Usuarios();
            return "menu.xhtml?faces-redirect=true";
        } else {
            mensaje = "LAS CONTRASEÑAS NO SON LAS MISMAS FAVOR, VUELVA A INGRESAR";
            context.addMessage(null, new FacesMessage("Successful", mensaje));

            return "cambiarPassword?faces-redirect=true";
        }
    }

    public String encriptar(String texto) {
        
        String textoEncriptadoConMD5 = DigestUtils.md5Hex(texto);
        return textoEncriptadoConMD5;
    }

    public void resetar()
    {
        isAdmin = false;
        isTramite = false;
        isCompletar = false;
        isIngresoTramite = false;
        isReporte = false;
    }
}
