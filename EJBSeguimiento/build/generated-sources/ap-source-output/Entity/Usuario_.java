package Entity;

import Entity.Rol;
import Entity.Unidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-11T08:00:54")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> usuarioCi;
    public static volatile SingularAttribute<Usuario, Rol> rolId;
    public static volatile SingularAttribute<Usuario, Unidad> unidadId;
    public static volatile SingularAttribute<Usuario, String> usuarioCorreo;
    public static volatile SingularAttribute<Usuario, String> usuarioUsuario;
    public static volatile SingularAttribute<Usuario, String> usuarioPassword;
    public static volatile SingularAttribute<Usuario, Boolean> usuarioActivo;
    public static volatile SingularAttribute<Usuario, String> usuarioNombre;
    public static volatile SingularAttribute<Usuario, Integer> usuarioId;

}