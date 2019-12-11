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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByUsuarioCi", query = "SELECT u FROM Usuario u WHERE u.usuarioCi = :usuarioCi"),
    @NamedQuery(name = "Usuario.findByUsuarioNombre", query = "SELECT u FROM Usuario u WHERE u.usuarioNombre = :usuarioNombre"),
    @NamedQuery(name = "Usuario.findByUsuarioUsuario", query = "SELECT u FROM Usuario u WHERE u.usuarioUsuario = :usuarioUsuario"),
    @NamedQuery(name = "Usuario.findByUsuarioPassword", query = "SELECT u FROM Usuario u WHERE u.usuarioPassword = :usuarioPassword"),
    @NamedQuery(name = "Usuario.findByUsuarioCorreo", query = "SELECT u FROM Usuario u WHERE u.usuarioCorreo = :usuarioCorreo"),
    @NamedQuery(name = "Usuario.findByUsuarioActivo", query = "SELECT u FROM Usuario u WHERE u.usuarioActivo = :usuarioActivo"),
    @NamedQuery(name = "Usuario.findByUsuarioId", query = "SELECT u FROM Usuario u WHERE u.usuarioId = :usuarioId")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 10)
    @Column(name = "usuario_ci")
    private String usuarioCi;
    @Size(max = 100)
    @Column(name = "usuario_nombre")
    private String usuarioNombre;
    @Size(max = 50)
    @Column(name = "usuario_usuario")
    private String usuarioUsuario;
    @Size(max = 100)
    @Column(name = "usuario_password")
    private String usuarioPassword;
    @Size(max = 100)
    @Column(name = "usuario_correo")
    private String usuarioCorreo;
    @Column(name = "usuario_activo")
    private Boolean usuarioActivo;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usuario_id")
    private Integer usuarioId;
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    @ManyToOne
    private Rol rolId;
    @JoinColumn(name = "unidad_id", referencedColumnName = "unidad_id")
    @ManyToOne
    private Unidad unidadId;

    public Usuario() {
    }

    public Usuario(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioCi() {
        return usuarioCi;
    }

    public void setUsuarioCi(String usuarioCi) {
        this.usuarioCi = usuarioCi;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public String getUsuarioUsuario() {
        return usuarioUsuario;
    }

    public void setUsuarioUsuario(String usuarioUsuario) {
        this.usuarioUsuario = usuarioUsuario;
    }

    public String getUsuarioPassword() {
        return usuarioPassword;
    }

    public void setUsuarioPassword(String usuarioPassword) {
        this.usuarioPassword = usuarioPassword;
    }

    public String getUsuarioCorreo() {
        return usuarioCorreo;
    }

    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public Boolean getUsuarioActivo() {
        return usuarioActivo;
    }

    public void setUsuarioActivo(Boolean usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
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
        hash += (usuarioId != null ? usuarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuarioId == null && other.usuarioId != null) || (this.usuarioId != null && !this.usuarioId.equals(other.usuarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Usuario[ usuarioId=" + usuarioId + " ]";
    }
    
}
