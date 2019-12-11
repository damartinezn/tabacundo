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
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m"),
    @NamedQuery(name = "Menu.findByMenuNombre", query = "SELECT m FROM Menu m WHERE m.menuNombre = :menuNombre"),
    @NamedQuery(name = "Menu.findByMenuDescripcion", query = "SELECT m FROM Menu m WHERE m.menuDescripcion = :menuDescripcion"),
    @NamedQuery(name = "Menu.findByMenuId", query = "SELECT m FROM Menu m WHERE m.menuId = :menuId")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "menu_nombre")
    private String menuNombre;
    @Size(max = 100)
    @Column(name = "menu_descripcion")
    private String menuDescripcion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "menu_id")
    private Integer menuId;
    @OneToMany(mappedBy = "menuId")
    private Collection<Privilegios> privilegiosCollection;

    public Menu() {
    }

    public Menu(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuNombre() {
        return menuNombre;
    }

    public void setMenuNombre(String menuNombre) {
        this.menuNombre = menuNombre;
    }

    public String getMenuDescripcion() {
        return menuDescripcion;
    }

    public void setMenuDescripcion(String menuDescripcion) {
        this.menuDescripcion = menuDescripcion;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @XmlTransient
    public Collection<Privilegios> getPrivilegiosCollection() {
        return privilegiosCollection;
    }

    public void setPrivilegiosCollection(Collection<Privilegios> privilegiosCollection) {
        this.privilegiosCollection = privilegiosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Menu[ menuId=" + menuId + " ]";
    }
    
}
