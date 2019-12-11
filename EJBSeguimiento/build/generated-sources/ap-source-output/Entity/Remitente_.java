package Entity;

import Entity.Tramite;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-11T08:00:54")
@StaticMetamodel(Remitente.class)
public class Remitente_ { 

    public static volatile CollectionAttribute<Remitente, Tramite> tramiteCollection;
    public static volatile SingularAttribute<Remitente, String> remitenteCi;
    public static volatile SingularAttribute<Remitente, String> remitenteRazon;
    public static volatile SingularAttribute<Remitente, Integer> remitenteId;
    public static volatile SingularAttribute<Remitente, String> remitenteNombre;

}