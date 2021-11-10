package montp.data.dao;

import javax.enterprise.context.ApplicationScoped;

import montp.data.model.ressource.RessourceType;

import java.util.List;

@ApplicationScoped
public class RessourceTypeDAO extends GenericDAO<RessourceType> {
    public RessourceTypeDAO() {
        super(RessourceType.class);
    }

    @SuppressWarnings("unchecked")
    public List<RessourceType> getRessourceTypes() {
        return em.createQuery("SELECT r FROM RessourceType r ORDER BY r.label")
                .getResultList();
    }

    public RessourceType getFromLabel(String label) {
        return (RessourceType) em.createQuery("SELECT r FROM RessourceType r WHERE r.label=:label")
                .setParameter("label", label)
                .getSingleResult();
    }

}
