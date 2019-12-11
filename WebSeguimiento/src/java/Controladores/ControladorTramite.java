/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entity.Destino;
import Entity.Remitente;
import Entity.Ruta;
import Entity.Tramite;
import Entity.Unidad;
import Entity.Usuario;
import Session.DestinoFacadeLocal;
import Session.RemitenteFacadeLocal;
import Session.RutaFacadeLocal;
import Session.TramiteFacadeLocal;
import Session.UnidadFacadeLocal;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Full Limpio
 */
@ManagedBean(name = "controladorTramite")
@SessionScoped
public class ControladorTramite implements Serializable {

    private static final long serialVersionUID = 1L;

    private Tramite tramite;
    private List<Tramite> listaTramite;
    @EJB
    private TramiteFacadeLocal ejbTramite;

    private Remitente remitente;
    private List<Remitente> listaRemitentes;
    @EJB
    private RemitenteFacadeLocal ejbRemitente;

    private Unidad unidad;
    private Unidad unidadVerifica;
    private List<Unidad> listaUnidad;
    @EJB
    private UnidadFacadeLocal ejbUbidad;

    private Destino destino;
    private Destino auxDestinoRespondido;
    private List<Destino> listaDestino;
    private List<Destino> listaDestinoRespondido;
    @EJB
    private DestinoFacadeLocal ejbDestino;

    private Ruta ruta;
    private List<Ruta> listaRuta;
    @EJB
    private RutaFacadeLocal ejbRuta;

    private Date dateDe;
    private Date dateDoc;
    private String auxNombre;

    private List<String> auxListaUnidad;
    private List<String> auxListaUnidadCopia;

    public Tramite getTramite() {
        return tramite;
    }

    public void setTramite(Tramite tramite) {
        this.tramite = tramite;
    }

    public List<Tramite> getListaTramite() {
        return listaTramite;
    }

    public void setListaTramite(List<Tramite> listaTramite) {
        this.listaTramite = listaTramite;
    }

    public Date getDateDe() {
        return dateDe;
    }

    public void setDateDe(Date dateDe) {
        this.dateDe = dateDe;
    }

    public Date getDateDoc() {
        return dateDoc;
    }

    public void setDateDoc(Date dateDoc) {
        this.dateDoc = dateDoc;
    }

    public Remitente getRemitente() {
        return remitente;
    }

    public void setRemitente(Remitente remitente) {
        this.remitente = remitente;
    }

    public List<Remitente> getListaRemitentes() {
        return listaRemitentes;
    }

    public void setListaRemitentes(List<Remitente> listaRemitentes) {
        this.listaRemitentes = listaRemitentes;
    }

    public RemitenteFacadeLocal getEjbRemitente() {
        return ejbRemitente;
    }

    public void setEjbRemitente(RemitenteFacadeLocal ejbRemitente) {
        this.ejbRemitente = ejbRemitente;
    }

    public String getAuxNombre() {
        return auxNombre;
    }

    public void setAuxNombre(String auxNombre) {
        this.auxNombre = auxNombre;
    }

    public TramiteFacadeLocal getEjbTramite() {
        return ejbTramite;
    }

    public void setEjbTramite(TramiteFacadeLocal ejbTramite) {
        this.ejbTramite = ejbTramite;
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

    public UnidadFacadeLocal getEjbUbidad() {
        return ejbUbidad;
    }

    public void setEjbUbidad(UnidadFacadeLocal ejbUbidad) {
        this.ejbUbidad = ejbUbidad;
    }

    public List<String> getAuxListaUnidad() {
        return auxListaUnidad;
    }

    public void setAuxListaUnidad(List<String> auxListaUnidad) {
        this.auxListaUnidad = auxListaUnidad;
    }

    public List<String> getAuxListaUnidadCopia() {
        return auxListaUnidadCopia;
    }

    public void setAuxListaUnidadCopia(List<String> auxListaUnidadCopia) {
        this.auxListaUnidadCopia = auxListaUnidadCopia;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public List<Destino> getListaDestino() {
        return listaDestino;
    }

    public void setListaDestino(List<Destino> listaDestino) {
        this.listaDestino = listaDestino;
    }

    public DestinoFacadeLocal getEjbDestino() {
        return ejbDestino;
    }

    public void setEjbDestino(DestinoFacadeLocal ejbDestino) {
        this.ejbDestino = ejbDestino;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public List<Ruta> getListaRuta() {
        return listaRuta;
    }

    public void setListaRuta(List<Ruta> listaRuta) {
        this.listaRuta = listaRuta;
    }

    public RutaFacadeLocal getEjbRuta() {
        return ejbRuta;
    }

    public void setEjbRuta(RutaFacadeLocal ejbRuta) {
        this.ejbRuta = ejbRuta;
    }

    public Unidad getUnidadVerifica() {
        return unidadVerifica;
    }

    public void setUnidadVerifica(Unidad unidadVerifica) {
        this.unidadVerifica = unidadVerifica;
    }

    public List<Destino> getListaDestinoRespondido() {
        return listaDestinoRespondido;
    }

    public void setListaDestinoRespondido(List<Destino> listaDestinoRespondido) {
        this.listaDestinoRespondido = listaDestinoRespondido;
    }

    public Destino getAuxDestinoRespondido() {
        return auxDestinoRespondido;
    }

    public void setAuxDestinoRespondido(Destino auxDestinoRespondido) {
        this.auxDestinoRespondido = auxDestinoRespondido;
    }
    
    

    @PostConstruct
    public void init() {
        tramite = new Tramite();
        listaTramite = new ArrayList();

        remitente = new Remitente();
        listaRemitentes = new ArrayList();

        unidad = new Unidad();
        listaUnidad = ejbUbidad.findAll();
        auxListaUnidad = new ArrayList();
        auxListaUnidadCopia = new ArrayList();

        destino = new Destino();

        ruta = new Ruta();
        listaRuta = new ArrayList();

        dateDe = new Date();
        listaTramite = ejbTramite.tramitesImcompletos();
        auxNombre = "";

        FacesContext context = FacesContext.getCurrentInstance();
        Usuario usua = (Usuario) context.getExternalContext().getSessionMap().get("verifica");
        unidadVerifica = usua.getUnidadId();

        listaDestino = ejbDestino.listarDestinos(unidadVerifica);
        listaDestinoRespondido = ejbDestino.listarDestinosRespondiendo(unidadVerifica);
    }

    public void crearRemitente() {
        ejbRemitente.create(remitente);
        remitente = new Remitente();
    }

    public List<String> completeText(String nombre) {
        List<String> results = new ArrayList();
        listaRemitentes = ejbRemitente.findAll();
        for (Remitente r : listaRemitentes) {
            if (r.getRemitenteNombre().toUpperCase().startsWith(nombre.toUpperCase())) {
                results.add(r.getRemitenteNombre());
            }

        }

        return results;
    }

    public String crearTramite() {
        tramite.setRemitenteId(ejbRemitente.buscarRemitente(auxNombre));
        tramite.setTramiteFechaIngreso(dateDe);
        tramite.setTramiteCompletado(Boolean.FALSE);
        ejbTramite.create(tramite);
        tramite = new Tramite();
        listaTramite = ejbTramite.tramitesImcompletos();
        auxNombre = "";
        dateDe = new Date();
        remitente = new Remitente();
        return "verTramites.xhtml?faces-redirect=true";
    }

    public String verTramite(Tramite auxTramite) {
        tramite = auxTramite;
        return "cambiarTramite.xhtml?faces-redirect=true";
    }

    public String completarTramite() {
        listaUnidad = ejbUbidad.findAll();
        listaDestino = ejbDestino.listarDestinos(unidadVerifica);
        tramite.setTramiteFechaFin(this.sumarRestarDiasFecha(tramite.getTramiteFechaIngreso(), tramite.getTramiteDias()));
        tramite.setTramiteCompletado(Boolean.TRUE);
        tramite.setTramiteEstado("ABIERTO");
        ejbTramite.edit(tramite);
        listaDestino = ejbDestino.listarDestinos(unidadVerifica);
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario usua = (Usuario) context.getExternalContext().getSessionMap().get("verifica");
        ruta.setRutaFechaInicio(new Date());
        ruta.setRutaUnidadInicial(usua.getUnidadId());
        ruta.setTramiteId(tramite);
        ejbRuta.create(ruta);

        for (String u : auxListaUnidad) {
            destino.setRutaId(ruta);
            destino.setUnidadId(ejbUbidad.find(Integer.parseInt(u)));
            destino.setDestinoCopia(Boolean.TRUE);
            destino.setDestinoEstado("ABIERTO");
            ejbDestino.create(destino);
        }

        for (String u : auxListaUnidadCopia) {
            destino.setRutaId(ruta);
            destino.setUnidadId(ejbUbidad.find(Integer.parseInt(u)));
            destino.setDestinoCopia(Boolean.FALSE);
            destino.setDestinoEstado("ABIERTO");
            ejbDestino.create(destino);
        }

        listaTramite = ejbTramite.tramitesImcompletos();
        tramite = new Tramite();
        auxListaUnidad = new ArrayList();
        auxListaUnidadCopia = new ArrayList();
        ruta = new Ruta();
        destino = new Destino();
        return "verTramites.xhtml?faces-redirect=true";
    }

    public Date sumarRestarDiasFecha(Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe	
        calendar.add(Calendar.DAY_OF_YEAR, dias); // numero de días a añadir, o restar en caso de días<0	
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }

    public String responderTramite(Destino auxDestino) {
        tramite = auxDestino.getRutaId().getTramiteId();
        listaRuta = ejbRuta.listaRutas(tramite);
        auxDestinoRespondido = auxDestino;
        return "responderTramite.xhtml?faces-redirect=true";
    }

    public String nuevaRuta() {
        listaDestino = ejbDestino.listarDestinos(unidadVerifica);
        FacesContext context = FacesContext.getCurrentInstance();
        Usuario usua = (Usuario) context.getExternalContext().getSessionMap().get("verifica");
        ruta.setRutaFechaInicio(new Date());
        ruta.setRutaUnidadInicial(usua.getUnidadId());
        ruta.setTramiteId(tramite);
        ejbRuta.create(ruta);
        listaDestinoRespondido = ejbDestino.listarDestinosRespondiendo(unidadVerifica);
        auxDestinoRespondido.setDestinoEstado("RESPONDIDO");
        for (String u : auxListaUnidad) {
            destino.setRutaId(ruta);
            destino.setUnidadId(ejbUbidad.find(Integer.parseInt(u)));
            destino.setDestinoCopia(Boolean.TRUE);
            destino.setDestinoEstado("ABIERTO");
            ejbDestino.create(destino);
        }

        for (String u : auxListaUnidadCopia) {
            destino.setRutaId(ruta);
            destino.setUnidadId(ejbUbidad.find(Integer.parseInt(u)));
            destino.setDestinoCopia(Boolean.FALSE);
            destino.setDestinoEstado("ABIERTO");
            ejbDestino.create(destino);
        }

        listaTramite = ejbTramite.tramitesImcompletos();
        tramite = new Tramite();
        auxListaUnidad = new ArrayList();
        auxListaUnidadCopia = new ArrayList();
        ruta = new Ruta();
        destino = new Destino();
        return "tramiteAtendido.xhtml?faces-redirect=true";
    }
}
