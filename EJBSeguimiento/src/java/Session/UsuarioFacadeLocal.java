/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Entity.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cristian
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();
    
    public Usuario loguin(Usuario us);
    
    public String cambiarPassword(Usuario usua,String nuevoPassword, boolean control);
    
    public String recuperarPassword(Usuario usua, boolean control);
    
}
