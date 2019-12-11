package Entity;

import Entity.Destino;
import Entity.Ruta;
import Entity.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-11T08:00:54")
@StaticMetamodel(Unidad.class)
public class Unidad_ { 

    public static volatile SingularAttribute<Unidad, Integer> unidadId;
    public static volatile SingularAttribute<Unidad, String> unidadInicial;
    public static volatile SingularAttribute<Unidad, String> unidadNombre;
    public static volatile CollectionAttribute<Unidad, Usuario> usuarioCollection;
    public static volatile CollectionAttribute<Unidad, Ruta> rutaCollection;
    public static volatile CollectionAttribute<Unidad, Destino> destinoCollection;
    public static volatile SingularAttribute<Unidad, Integer> unidadPadre;

}