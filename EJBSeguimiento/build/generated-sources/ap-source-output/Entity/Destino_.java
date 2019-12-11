package Entity;

import Entity.Ruta;
import Entity.Unidad;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-11T08:00:54")
@StaticMetamodel(Destino.class)
public class Destino_ { 

    public static volatile SingularAttribute<Destino, Unidad> unidadId;
    public static volatile SingularAttribute<Destino, Boolean> destinoCopia;
    public static volatile SingularAttribute<Destino, Ruta> rutaId;
    public static volatile SingularAttribute<Destino, String> destinoEstado;
    public static volatile SingularAttribute<Destino, Integer> destinoId;

}