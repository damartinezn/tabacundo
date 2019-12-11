package Entity;

import Entity.Menu;
import Entity.Rol;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-11T08:00:54")
@StaticMetamodel(Privilegios.class)
public class Privilegios_ { 

    public static volatile SingularAttribute<Privilegios, Rol> rolId;
    public static volatile SingularAttribute<Privilegios, Integer> privilegioId;
    public static volatile SingularAttribute<Privilegios, Menu> menuId;

}