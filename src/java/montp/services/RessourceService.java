package montp.services;

import montp.data.dao.RessourceDAO;
import montp.data.model.ressource.Ressource;
import montp.data.model.ressource.RessourceType;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class RessourceService extends GenericService<Ressource, RessourceDAO>{

    @Transactional
    public void insert(Ressource ressource) {
        ressource.setLabel(ressource.getLabel());
        super.insert(ressource);
    }

}
