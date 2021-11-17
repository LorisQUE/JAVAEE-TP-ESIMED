package montp.data.dao;

import javax.enterprise.context.ApplicationScoped;
import montp.data.model.ressource.Ressource;
import montp.data.model.ressource.RessourceType;

import java.util.List;

@ApplicationScoped
public class RessourceDAO extends GenericDAO<Ressource> {

    public RessourceDAO() {
        super(Ressource.class);
    }

    @SuppressWarnings("unchecked")
    public List<Ressource> getAll() {
        return em.createQuery("SELECT r FROM Ressource r ORDER BY r.label")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Ressource> getAllFromType(RessourceType type) {
        return em.createQuery("SELECT r FROM Ressource r WHERE r.type = :type ORDER BY r.label")
                .setParameter("type", type)
                .getResultList();
    }
}
