package montp.services;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import montp.data.dao.RessourceTypeDAO;
import montp.data.model.ressource.RessourceType;

@ApplicationScoped
public class RessourceTypeService extends GenericService<RessourceType, RessourceTypeDAO> {

    @Transactional
    public void insert(RessourceType ressourceType) {
        ressourceType.setLabel(ressourceType.getLabel().trim());
        super.insert(ressourceType);
    }
}
