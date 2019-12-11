/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Remitente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cristian
 */
@Local
public interface RemitenteFacadeLocal {

    void create(Remitente remitente);

    void edit(Remitente remitente);

    void remove(Remitente remitente);

    Remitente find(Object id);

    List<Remitente> findAll();

    List<Remitente> findRange(int[] range);

    int count();
    
    public Remitente buscarRemitente(String nombre);
    
}
