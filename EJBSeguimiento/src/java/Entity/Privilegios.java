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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "privilegios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilegios.findAll", query = "SELECT p FROM Privilegios p"),
    @NamedQuery(name = "Privilegios.findByPrivilegioId", query = "SELECT p FROM Privilegios p WHERE p.privilegioId = :privilegioId")})
public class Privilegios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "privilegio_id")
    private Integer privilegioId;
    @JoinColumn(name = "menu_id", referencedColumnName = "menu_id")
    @ManyToOne
    private Menu menuId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private Rol rolId;

    public Privilegios() {
    }

    public Privilegios(Integer privilegioId) {
        this.privilegioId = privilegioId;
    }

    public Integer getPrivilegioId() {
        return privilegioId;
    }

    public void setPrivilegioId(Integer privilegioId) {
        this.privilegioId = privilegioId;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (privilegioId != null ? privilegioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilegios)) {
            return false;
        }
        Privilegios other = (Privilegios) object;
        if ((this.privilegioId == null && other.privilegioId != null) || (this.privilegioId != null && !this.privilegioId.equals(other.privilegioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Privilegios[ privilegioId=" + privilegioId + " ]";
    }
    
}
