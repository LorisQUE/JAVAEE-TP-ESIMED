package montp.services;

import montp.data.dao.RessourceDAO;
import montp.data.model.ressource.Ressource;
import montp.data.model.ressource.RessourceType;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class RessourceService extends GenericService<Ressource, RessourceDAO>{

    @Transactional
    public void insert(Ressource ressource) {
        ressource.setLabel(ressource.getLabel().trim());
        //ressource.setCapacity(ressource.getCapacity());
        //ressource.setManager(ressource.getManager());
        //ressource.setType(ressource.getType());
        super.insert(ressource);
    }

    public List<Ressource> getAll(){
        return dao.getAll();
    }
    public List<Ressource> getAllFromType(RessourceType type){ return dao.getAllFromType(type); }
}
