/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "remitente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Remitente.findAll", query = "SELECT r FROM Remitente r"),
    @NamedQuery(name = "Remitente.findByRemitenteId", query = "SELECT r FROM Remitente r WHERE r.remitenteId = :remitenteId"),
    @NamedQuery(name = "Remitente.findByRemitenteNombre", query = "SELECT r FROM Remitente r WHERE r.remitenteNombre = :remitenteNombre"),
    @NamedQuery(name = "Remitente.findByRemitenteCi", query = "SELECT r FROM Remitente r WHERE r.remitenteCi = :remitenteCi"),
    @NamedQuery(name = "Remitente.findByRemitenteRazon", query = "SELECT r FROM Remitente r WHERE r.remitenteRazon = :remitenteRazon")})
public class Remitente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "remitente_id")
    private Integer remitenteId;
    @Size(max = 100)
    @Column(name = "remitente_nombre")
    private String remitenteNombre;
    @Size(max = 15)
    @Column(name = "remitente_ci")
    private String remitenteCi;
    @Size(max = 50)
    @Column(name = "remitente_razon")
    private String remitenteRazon;
    @OneToMany(mappedBy = "remitenteId")
    private Collection<Tramite> tramiteCollection;

    public Remitente() {
    }

    public Remitente(Integer remitenteId) {
        this.remitenteId = remitenteId;
    }

    public Integer getRemitenteId() {
        return remitenteId;
    }

    public void setRemitenteId(Integer remitenteId) {
        this.remitenteId = remitenteId;
    }

    public String getRemitenteNombre() {
        return remitenteNombre;
    }

    public void setRemitenteNombre(String remitenteNombre) {
        this.remitenteNombre = remitenteNombre;
    }

    public String getRemitenteCi() {
        return remitenteCi;
    }

    public void setRemitenteCi(String remitenteCi) {
        this.remitenteCi = remitenteCi;
    }

    public String getRemitenteRazon() {
        return remitenteRazon;
    }

    public void setRemitenteRazon(String remitenteRazon) {
        this.remitenteRazon = remitenteRazon;
    }

    @XmlTransient
    public Collection<Tramite> getTramiteCollection() {
        return tramiteCollection;
    }

    public void setTramiteCollection(Collection<Tramite> tramiteCollection) {
        this.tramiteCollection = tramiteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (remitenteId != null ? remitenteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remitente)) {
            return false;
        }
        Remitente other = (Remitente) object;
        if ((this.remitenteId == null && other.remitenteId != null) || (this.remitenteId != null && !this.remitenteId.equals(other.remitenteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Remitente[ remitenteId=" + remitenteId + " ]";
    }
    
}
