/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Destino;
import Entity.Unidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cristian
 */
@Local
public interface DestinoFacadeLocal {

    void create(Destino destino);

    void edit(Destino destino);

    void remove(Destino destino);

    Destino find(Object id);

    List<Destino> findAll();

    List<Destino> findRange(int[] range);

    int count();
    
    public List<Destino> listarDestinos(Unidad unidad);
    
     public List<Destino> listarDestinosRespondiendo(Unidad unidad);
}
