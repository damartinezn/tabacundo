/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Cristian
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {
    @PersistenceContext(unitName = "EJBSeguimientoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    @Override
    public Usuario loguin(Usuario us) {
        Usuario user = null;

        try {
            Query sql = em.createQuery("SELECT u FROM Usuario u WHERE u.usuarioUsuario = :usua AND u.usuarioPassword = :pass");
            sql.setParameter("usua", us.getUsuarioUsuario());
            sql.setParameter("pass", us.getUsuarioPassword());

            List<Usuario> listaUsuarios = sql.getResultList();

            if (!listaUsuarios.isEmpty()) {
                user = listaUsuarios.get(0);
            }

        } catch (Exception e) {
            throw e;
        }
        return user;
    }
    
    @Override
    public String cambiarPassword(Usuario usua,String nuevoPassword, boolean control)
    {
        String mensaje = "";

        Query sql = em.createQuery("UPDATE Usuario u SET u.usuarioPassword = :pass , u.usuarioActivo = :control WHERE u.usuarioId = :idUsua");
        sql.setParameter("pass", nuevoPassword);
        sql.setParameter("control", control);
        sql.setParameter("idUsua", usua.getUsuarioId());

        if (sql.executeUpdate() != 0) 
        {
            mensaje += "EL PASSWROD HA SIDO CAMBIADO EXITOSAMENTE";
        } 
        else 
        {
            mensaje += "NO SE PUDO CAMBIAR EL PASSWORD";
        }
        return mensaje;
    }
    
    @Override
    public String recuperarPassword(Usuario usua, boolean control) {
        String mensaje = "";

        Query sql = em.createQuery("UPDATE Usuario u SET u.usuarioPassword = :pass , u.usuarioActivo = :control WHERE u.usuarioId = :idUsua");
        sql.setParameter("pass", usua.getUsuarioPassword());
        sql.setParameter("control", control);
        sql.setParameter("idUsua", usua.getUsuarioId());

        if (sql.executeUpdate() != 0) 
        {
            mensaje += "EL PASSWROD HA SIDO RESTAURADO";
        } else {
            mensaje += "NO SE PUDO RESTAURAR EL PASSWORD";
        }
        return mensaje;
    }
    
}
