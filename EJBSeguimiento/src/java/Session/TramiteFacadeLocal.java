/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Tramite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cristian
 */
@Local
public interface TramiteFacadeLocal {

    void create(Tramite tramite);

    void edit(Tramite tramite);

    void remove(Tramite tramite);

    Tramite find(Object id);

    List<Tramite> findAll();

    List<Tramite> findRange(int[] range);

    int count();
    
    public List<Tramite> tramitesImcompletos();
    
}
