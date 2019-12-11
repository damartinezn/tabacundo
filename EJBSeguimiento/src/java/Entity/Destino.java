/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "destino")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Destino.findAll", query = "SELECT d FROM Destino d"),
    @NamedQuery(name = "Destino.findByDestinoId", query = "SELECT d FROM Destino d WHERE d.destinoId = :destinoId"),
    @NamedQuery(name = "Destino.findByDestinoCopia", query = "SELECT d FROM Destino d WHERE d.destinoCopia = :destinoCopia"),
    @NamedQuery(name = "Destino.findByDestinoEstado", query = "SELECT d FROM Destino d WHERE d.destinoEstado = :destinoEstado")})
public class Destino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "destino_id")
    private Integer destinoId;
    @Column(name = "destino_copia")
    private Boolean destinoCopia;
    @Size(max = 20)
    @Column(name = "destino_estado")
    private String destinoEstado;
    @JoinColumn(name = "ruta_id", referencedColumnName = "ruta_id")
    @ManyToOne
    private Ruta rutaId;
    @JoinColumn(name = "unidad_id", referencedColumnName = "unidad_id")
    @ManyToOne
    private Unidad unidadId;

    public Destino() {
    }

    public Destino(Integer destinoId) {
        this.destinoId = destinoId;
    }

    public Integer getDestinoId() {
        return destinoId;
    }

    public void setDestinoId(Integer destinoId) {
        this.destinoId = destinoId;
    }

    public Boolean getDestinoCopia() {
        return destinoCopia;
    }

    public void setDestinoCopia(Boolean destinoCopia) {
        this.destinoCopia = destinoCopia;
    }

    public String getDestinoEstado() {
        return destinoEstado;
    }

    public void setDestinoEstado(String destinoEstado) {
        this.destinoEstado = destinoEstado;
    }

    public Ruta getRutaId() {
        return rutaId;
    }

    public void setRutaId(Ruta rutaId) {
        this.rutaId = rutaId;
    }

    public Unidad getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(Unidad unidadId) {
        this.unidadId = unidadId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (destinoId != null ? destinoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Destino)) {
            return false;
        }
        Destino other = (Destino) object;
        if ((this.destinoId == null && other.destinoId != null) || (this.destinoId != null && !this.destinoId.equals(other.destinoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Destino[ destinoId=" + destinoId + " ]";
    }
    
}
