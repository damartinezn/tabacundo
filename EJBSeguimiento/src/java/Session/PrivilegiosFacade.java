/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Privilegios;
import Entity.Rol;
import java.util.ArrayList;
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
public class PrivilegiosFacade extends AbstractFacade<Privilegios> implements PrivilegiosFacadeLocal {
    @PersistenceContext(unitName = "EJBSeguimientoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrivilegiosFacade() {
        super(Privilegios.class);
    }
    
    @Override
    public List<Privilegios> listaMenu(Rol rol){
        
        List<Privilegios> listaRol = new ArrayList();
        try {
            Query sql = em.createQuery("SELECT r FROM Privilegios r WHERE r.rolId = :rol");
            sql.setParameter("rol", rol);

            listaRol = sql.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return listaRol;
    }
    
}
