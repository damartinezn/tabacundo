/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Ruta;
import Entity.Tramite;
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
public class RutaFacade extends AbstractFacade<Ruta> implements RutaFacadeLocal {
    @PersistenceContext(unitName = "EJBSeguimientoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RutaFacade() {
        super(Ruta.class);
    }

    @Override
    public List<Ruta> listaRutas(Tramite tramite) {
        List<Ruta> listaRuta = new ArrayList();
        try {
            Query sql = em.createQuery("SELECT r FROM Ruta r WHERE r.tramiteId = :tramite");
            sql.setParameter("tramite", tramite);

            listaRuta = sql.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return listaRuta;
    }
    
}
