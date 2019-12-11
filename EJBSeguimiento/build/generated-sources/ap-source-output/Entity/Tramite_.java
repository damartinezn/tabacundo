package Entity;

import Entity.Remitente;
import Entity.Ruta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-11T08:00:54")
@StaticMetamodel(Tramite.class)
public class Tramite_ { 

    public static volatile SingularAttribute<Tramite, Date> tramiteFechaDoc;
    public static volatile SingularAttribute<Tramite, String> tramiteAnexo;
    public static volatile SingularAttribute<Tramite, Date> tramiteFechaIngreso;
    public static volatile SingularAttribute<Tramite, Integer> tramiteId;
    public static volatile SingularAttribute<Tramite, String> tramiteEstado;
    public static volatile SingularAttribute<Tramite, String> tramiteContacto;
    public static volatile SingularAttribute<Tramite, String> tramiteDirigido;
    public static volatile SingularAttribute<Tramite, Integer> tramiteDias;
    public static volatile SingularAttribute<Tramite, Date> tramiteFechaFin;
    public static volatile SingularAttribute<Tramite, String> tramiteNumDoc;
    public static volatile SingularAttribute<Tramite, String> tramiteUbicionFin;
    public static volatile SingularAttribute<Tramite, Boolean> tramiteCompletado;
    public static volatile SingularAttribute<Tramite, Remitente> remitenteId;
    public static volatile SingularAttribute<Tramite, String> tramiteAsunto;
    public static volatile CollectionAttribute<Tramite, Ruta> rutaCollection;

}