package Entity;

import Entity.Destino;
import Entity.Tramite;
import Entity.Unidad;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-11T08:00:54")
@StaticMetamodel(Ruta.class)
public class Ruta_ { 

    public static volatile SingularAttribute<Ruta, Date> rutaFechaInicio;
    public static volatile SingularAttribute<Ruta, String> rutaObservacion;
    public static volatile SingularAttribute<Ruta, Unidad> rutaUnidadInicial;
    public static volatile SingularAttribute<Ruta, Integer> rutaId;
    public static volatile SingularAttribute<Ruta, Tramite> tramiteId;
    public static volatile SingularAttribute<Ruta, Integer> documentoId;
    public static volatile CollectionAttribute<Ruta, Destino> destinoCollection;

}