/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "tramite")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tramite.findAll", query = "SELECT t FROM Tramite t"),
    @NamedQuery(name = "Tramite.findByTramiteId", query = "SELECT t FROM Tramite t WHERE t.tramiteId = :tramiteId"),
    @NamedQuery(name = "Tramite.findByTramiteNumDoc", query = "SELECT t FROM Tramite t WHERE t.tramiteNumDoc = :tramiteNumDoc"),
    @NamedQuery(name = "Tramite.findByTramiteAsunto", query = "SELECT t FROM Tramite t WHERE t.tramiteAsunto = :tramiteAsunto"),
    @NamedQuery(name = "Tramite.findByTramiteFechaIngreso", query = "SELECT t FROM Tramite t WHERE t.tramiteFechaIngreso = :tramiteFechaIngreso"),
    @NamedQuery(name = "Tramite.findByTramiteFechaDoc", query = "SELECT t FROM Tramite t WHERE t.tramiteFechaDoc = :tramiteFechaDoc"),
    @NamedQuery(name = "Tramite.findByTramiteContacto", query = "SELECT t FROM Tramite t WHERE t.tramiteContacto = :tramiteContacto"),
    @NamedQuery(name = "Tramite.findByTramiteDias", query = "SELECT t FROM Tramite t WHERE t.tramiteDias = :tramiteDias"),
    @NamedQuery(name = "Tramite.findByTramiteFechaFin", query = "SELECT t FROM Tramite t WHERE t.tramiteFechaFin = :tramiteFechaFin"),
    @NamedQuery(name = "Tramite.findByTramiteDirigido", query = "SELECT t FROM Tramite t WHERE t.tramiteDirigido = :tramiteDirigido"),
    @NamedQuery(name = "Tramite.findByTramiteAnexo", query = "SELECT t FROM Tramite t WHERE t.tramiteAnexo = :tramiteAnexo"),
    @NamedQuery(name = "Tramite.findByTramiteUbicionFin", query = "SELECT t FROM Tramite t WHERE t.tramiteUbicionFin = :tramiteUbicionFin"),
    @NamedQuery(name = "Tramite.findByTramiteEstado", query = "SELECT t FROM Tramite t WHERE t.tramiteEstado = :tramiteEstado"),
    @NamedQuery(name = "Tramite.findByTramiteCompletado", query = "SELECT t FROM Tramite t WHERE t.tramiteCompletado = :tramiteCompletado")})
public class Tramite implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tramite_id")
    private Integer tramiteId;
    @Size(max = 50)
    @Column(name = "tramite_num_doc")
    private String tramiteNumDoc;
    @Size(max = 100)
    @Column(name = "tramite_asunto")
    private String tramiteAsunto;
    @Column(name = "tramite_fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private Date tramiteFechaIngreso;
    @Column(name = "tramite_fecha_doc")
    @Temporal(TemporalType.DATE)
    private Date tramiteFechaDoc;
    @Size(max = 100)
    @Column(name = "tramite_contacto")
    private String tramiteContacto;
    @Column(name = "tramite_dias")
    private Integer tramiteDias;
    @Column(name = "tramite_fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date tramiteFechaFin;
    @Size(max = 100)
    @Column(name = "tramite_dirigido")
    private String tramiteDirigido;
    @Size(max = 100)
    @Column(name = "tramite_anexo")
    private String tramiteAnexo;
    @Size(max = 100)
    @Column(name = "tramite_ubicion_fin")
    private String tramiteUbicionFin;
    @Size(max = 10)
    @Column(name = "tramite_estado")
    private String tramiteEstado;
    @Column(name = "tramite_completado")
    private Boolean tramiteCompletado;
    @OneToMany(mappedBy = "tramiteId")
    private Collection<Ruta> rutaCollection;
    @JoinColumn(name = "remitente_id", referencedColumnName = "remitente_id")
    @ManyToOne
    private Remitente remitenteId;

    public Tramite() {
    }

    public Tramite(Integer tramiteId) {
        this.tramiteId = tramiteId;
    }

    public Integer getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(Integer tramiteId) {
        this.tramiteId = tramiteId;
    }

    public String getTramiteNumDoc() {
        return tramiteNumDoc;
    }

    public void setTramiteNumDoc(String tramiteNumDoc) {
        this.tramiteNumDoc = tramiteNumDoc;
    }

    public String getTramiteAsunto() {
        return tramiteAsunto;
    }

    public void setTramiteAsunto(String tramiteAsunto) {
        this.tramiteAsunto = tramiteAsunto;
    }

    public Date getTramiteFechaIngreso() {
        return tramiteFechaIngreso;
    }

    public void setTramiteFechaIngreso(Date tramiteFechaIngreso) {
        this.tramiteFechaIngreso = tramiteFechaIngreso;
    }

    public Date getTramiteFechaDoc() {
        return tramiteFechaDoc;
    }

    public void setTramiteFechaDoc(Date tramiteFechaDoc) {
        this.tramiteFechaDoc = tramiteFechaDoc;
    }

    public String getTramiteContacto() {
        return tramiteContacto;
    }

    public void setTramiteContacto(String tramiteContacto) {
        this.tramiteContacto = tramiteContacto;
    }

    public Integer getTramiteDias() {
        return tramiteDias;
    }

    public void setTramiteDias(Integer tramiteDias) {
        this.tramiteDias = tramiteDias;
    }

    public Date getTramiteFechaFin() {
        return tramiteFechaFin;
    }

    public void setTramiteFechaFin(Date tramiteFechaFin) {
        this.tramiteFechaFin = tramiteFechaFin;
    }

    public String getTramiteDirigido() {
        return tramiteDirigido;
    }

    public void setTramiteDirigido(String tramiteDirigido) {
        this.tramiteDirigido = tramiteDirigido;
    }

    public String getTramiteAnexo() {
        return tramiteAnexo;
    }

    public void setTramiteAnexo(String tramiteAnexo) {
        this.tramiteAnexo = tramiteAnexo;
    }

    public String getTramiteUbicionFin() {
        return tramiteUbicionFin;
    }

    public void setTramiteUbicionFin(String tramiteUbicionFin) {
        this.tramiteUbicionFin = tramiteUbicionFin;
    }

    public String getTramiteEstado() {
        return tramiteEstado;
    }

    public void setTramiteEstado(String tramiteEstado) {
        this.tramiteEstado = tramiteEstado;
    }

    public Boolean getTramiteCompletado() {
        return tramiteCompletado;
    }

    public void setTramiteCompletado(Boolean tramiteCompletado) {
        this.tramiteCompletado = tramiteCompletado;
    }

    @XmlTransient
    public Collection<Ruta> getRutaCollection() {
        return rutaCollection;
    }

    public void setRutaCollection(Collection<Ruta> rutaCollection) {
        this.rutaCollection = rutaCollection;
    }

    public Remitente getRemitenteId() {
        return remitenteId;
    }

    public void setRemitenteId(Remitente remitenteId) {
        this.remitenteId = remitenteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tramiteId != null ? tramiteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.tramiteId == null && other.tramiteId != null) || (this.tramiteId != null && !this.tramiteId.equals(other.tramiteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Tramite[ tramiteId=" + tramiteId + " ]";
    }
    
}
