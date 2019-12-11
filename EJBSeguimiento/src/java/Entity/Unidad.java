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
@Table(name = "unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u"),
    @NamedQuery(name = "Unidad.findByUnidadNombre", query = "SELECT u FROM Unidad u WHERE u.unidadNombre = :unidadNombre"),
    @NamedQuery(name = "Unidad.findByUnidadInicial", query = "SELECT u FROM Unidad u WHERE u.unidadInicial = :unidadInicial"),
    @NamedQuery(name = "Unidad.findByUnidadPadre", query = "SELECT u FROM Unidad u WHERE u.unidadPadre = :unidadPadre"),
    @NamedQuery(name = "Unidad.findByUnidadId", query = "SELECT u FROM Unidad u WHERE u.unidadId = :unidadId")})
public class Unidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "unidad_nombre")
    private String unidadNombre;
    @Size(max = 20)
    @Column(name = "unidad_inicial")
    private String unidadInicial;
    @Column(name = "unidad_padre")
    private Integer unidadPadre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "unidad_id")
    private Integer unidadId;
    @OneToMany(mappedBy = "rutaUnidadInicial")
    private Collection<Ruta> rutaCollection;
    @OneToMany(mappedBy = "unidadId")
    private Collection<Usuario> usuarioCollection;
    @OneToMany(mappedBy = "unidadId")
    private Collection<Destino> destinoCollection;

    public Unidad() {
    }

    public Unidad(Integer unidadId) {
        this.unidadId = unidadId;
    }

    public String getUnidadNombre() {
        return unidadNombre;
    }

    public void setUnidadNombre(String unidadNombre) {
        this.unidadNombre = unidadNombre;
    }

    public String getUnidadInicial() {
        return unidadInicial;
    }

    public void setUnidadInicial(String unidadInicial) {
        this.unidadInicial = unidadInicial;
    }

    public Integer getUnidadPadre() {
        return unidadPadre;
    }

    public void setUnidadPadre(Integer unidadPadre) {
        this.unidadPadre = unidadPadre;
    }

    public Integer getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(Integer unidadId) {
        this.unidadId = unidadId;
    }

    @XmlTransient
    public Collection<Ruta> getRutaCollection() {
        return rutaCollection;
    }

    public void setRutaCollection(Collection<Ruta> rutaCollection) {
        this.rutaCollection = rutaCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
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
        hash += (unidadId != null ? unidadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.unidadId == null && other.unidadId != null) || (this.unidadId != null && !this.unidadId.equals(other.unidadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Unidad[ unidadId=" + unidadId + " ]";
    }
    
}
