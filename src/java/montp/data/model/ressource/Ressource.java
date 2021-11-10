package montp.data.model.ressource;

import montp.data.model.GenericEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RESSOURCE")
public class Ressource extends GenericEntity {

    public Ressource () { }

    public Ressource (String label, RessourceType type) {
        this.label = label;
        this.type = type;
    }

    private String label;

    @ManyToOne
    private RessourceType type;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public RessourceType getType() { return this.type; }

    public void setType(RessourceType type) {
        this.type = type;
    }
}
