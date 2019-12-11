package Entity;

import Entity.Privilegios;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-11T08:00:54")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, String> menuNombre;
    public static volatile SingularAttribute<Menu, Integer> menuId;
    public static volatile SingularAttribute<Menu, String> menuDescripcion;
    public static volatile CollectionAttribute<Menu, Privilegios> privilegiosCollection;

}