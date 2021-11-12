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

    public RessourceType(String label, Integer capacity) {
        this.label = label;
        this.capacity = capacity;
    }

    private String label;
    @OneToMany(mappedBy = "type")
    private List<Ressource> ressources;
    private Integer capacity;

    public String getLabel() { return label; }

    public void setLabel(String label) { this.label = label; }

    public List<Ressource> getRessources() { return ressources; }

    public Integer getCapacity() { return capacity; }

    public void setCapacity(Integer capacity) { this.capacity = capacity; }
}
