package Entity;

import Entity.Privilegios;
import Entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-11T08:00:54")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, Integer> rolId;
    public static volatile SingularAttribute<Rol, String> rolDescripcion;
    public static volatile CollectionAttribute<Rol, Usuario> usuarioCollection;
    public static volatile SingularAttribute<Rol, String> rolNombre;
    public static volatile CollectionAttribute<Rol, Privilegios> privilegiosCollection;

}