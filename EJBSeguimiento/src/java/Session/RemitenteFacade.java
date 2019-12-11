/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Remitente;
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
public class RemitenteFacade extends AbstractFacade<Remitente> implements RemitenteFacadeLocal {
    @PersistenceContext(unitName = "EJBSeguimientoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RemitenteFacade() {
        super(Remitente.class);
    }
    
    @Override
    public Remitente buscarRemitente(String nombre){
        Remitente user = null;

        try {
            Query sql = em.createQuery("SELECT r FROM Remitente r WHERE r.remitenteNombre = :nom");
            sql.setParameter("nom", nombre);

            List<Remitente> listaRemitente = sql.getResultList();

            if (!listaRemitente.isEmpty()) {
                user = listaRemitente.get(0);
            }

        } catch (Exception e) {
            throw e;
        }
        return user;
    }
    
}
