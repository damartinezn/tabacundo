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
@Table(name = "ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r"),
    @NamedQuery(name = "Ruta.findByRutaId", query = "SELECT r FROM Ruta r WHERE r.rutaId = :rutaId"),
    @NamedQuery(name = "Ruta.findByRutaFechaInicio", query = "SELECT r FROM Ruta r WHERE r.rutaFechaInicio = :rutaFechaInicio"),
    @NamedQuery(name = "Ruta.findByRutaObservacion", query = "SELECT r FROM Ruta r WHERE r.rutaObservacion = :rutaObservacion"),
    @NamedQuery(name = "Ruta.findByDocumentoId", query = "SELECT r FROM Ruta r WHERE r.documentoId = :documentoId")})
public class Ruta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ruta_id")
    private Integer rutaId;
    @Column(name = "ruta_fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date rutaFechaInicio;
    @Size(max = 200)
    @Column(name = "ruta_observacion")
    private String rutaObservacion;
    @Column(name = "documento_id")
    private Integer documentoId;
    @JoinColumn(name = "tramite_id", referencedColumnName = "tramite_id")
    @ManyToOne
    private Tramite tramiteId;
    @JoinColumn(name = "ruta_unidad_inicial", referencedColumnName = "unidad_id")
    @ManyToOne
    private Unidad rutaUnidadInicial;
    @OneToMany(mappedBy = "rutaId")
    private Collection<Destino> destinoCollection;

    public Ruta() {
    }

    public Ruta(Integer rutaId) {
        this.rutaId = rutaId;
    }

    public Integer getRutaId() {
        return rutaId;
    }

    public void setRutaId(Integer rutaId) {
        this.rutaId = rutaId;
    }

    public Date getRutaFechaInicio() {
        return rutaFechaInicio;
    }

    public void setRutaFechaInicio(Date rutaFechaInicio) {
        this.rutaFechaInicio = rutaFechaInicio;
    }

    public String getRutaObservacion() {
        return rutaObservacion;
    }

    public void setRutaObservacion(String rutaObservacion) {
        this.rutaObservacion = rutaObservacion;
    }

    public Integer getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(Integer documentoId) {
        this.documentoId = documentoId;
    }

    public Tramite getTramiteId() {
        return tramiteId;
    }

    public void setTramiteId(Tramite tramiteId) {
        this.tramiteId = tramiteId;
    }

    public Unidad getRutaUnidadInicial() {
        return rutaUnidadInicial;
    }

    public void setRutaUnidadInicial(Unidad rutaUnidadInicial) {
        this.rutaUnidadInicial = rutaUnidadInicial;
    }

    @XmlTransient
    public Collection<Destino> getDestinoCollection() {
        return destinoCollection;
    }

    public void setDestinoCollection(Collection<Destino> destinoCollection) {
        this.destinoCollection = destinoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutaId != null ? rutaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.rutaId == null && other.rutaId != null) || (this.rutaId != null && !this.rutaId.equals(other.rutaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Ruta[ rutaId=" + rutaId + " ]";
    }
    
}
