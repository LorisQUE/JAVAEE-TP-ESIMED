package montp.data.dao;

import javax.enterprise.context.ApplicationScoped;
import montp.data.model.ressource.Ressource;

@ApplicationScoped
public class RessourceDAO extends GenericDAO<Ressource> {

    public RessourceDAO() {
        super(Ressource.class);
    }



}
