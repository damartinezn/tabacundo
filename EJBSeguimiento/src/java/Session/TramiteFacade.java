/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Tramite;
import Entity.Usuario;
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
public class TramiteFacade extends AbstractFacade<Tramite> implements TramiteFacadeLocal {
    @PersistenceContext(unitName = "EJBSeguimientoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TramiteFacade() {
        super(Tramite.class);
    }
    
    @Override
    public List<Tramite> tramitesImcompletos(){
        boolean estado = false;
        List<Tramite> listaTramite = new ArrayList();
        try {
            Query sql = em.createQuery("SELECT t FROM Tramite t WHERE t.tramiteCompletado = :estado");
            sql.setParameter("estado", estado);

            listaTramite = sql.getResultList();

        } catch (Exception e) {
            throw e;
        }
        return listaTramite;
    }
    
}
