package montp.data.model.ressource;

import montp.data.model.GenericEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "RESSOURCE_TYPE")
public class RessourceType extends GenericEntity {

    public RessourceType() {
    }

    public RessourceType(String label) {
        this.label = label;
    }

    private String label;
    @OneToMany(mappedBy = "type")
    private List<Ressource> ressources;

    public String getLabel() { return label; }

    public void setLabel(String label) { this.label = label; }

    public List<Ressource> getRessources() { return ressources; }

}
