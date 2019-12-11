/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Privilegios;
import Entity.Rol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cristian
 */
@Local
public interface PrivilegiosFacadeLocal {

    void create(Privilegios privilegios);

    void edit(Privilegios privilegios);

    void remove(Privilegios privilegios);

    Privilegios find(Object id);

    List<Privilegios> findAll();

    List<Privilegios> findRange(int[] range);

    int count();
    
    public List<Privilegios> listaMenu(Rol rol);
}
