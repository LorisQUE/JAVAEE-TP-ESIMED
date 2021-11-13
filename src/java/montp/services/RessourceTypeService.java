package montp.services;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import montp.data.dao.RessourceTypeDAO;
import montp.data.model.ressource.RessourceType;

import java.util.List;

@ApplicationScoped
public class RessourceTypeService extends GenericService<RessourceType, RessourceTypeDAO> {

    public List<RessourceType> getRessourceTypes(){
        return dao.getRessourceTypes();
    }

    public boolean canDelete(RessourceType ressourceType) {
        return ressourceType.getRessources().size() == 0;
    }

    @Transactional
    public void insert(RessourceType ressourceType) {
        ressourceType.setLabel(ressourceType.getLabel().trim());
        super.insert(ressourceType);
    }
}
