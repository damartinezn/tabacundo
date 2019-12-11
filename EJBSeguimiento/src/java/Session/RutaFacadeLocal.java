/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Ruta;
import Entity.Tramite;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cristian
 */
@Local
public interface RutaFacadeLocal {

    void create(Ruta ruta);

    void edit(Ruta ruta);

    void remove(Ruta ruta);

    Ruta find(Object id);

    List<Ruta> findAll();

    List<Ruta> findRange(int[] range);

    int count();
    
    List<Ruta> listaRutas(Tramite tramite);
    
}
