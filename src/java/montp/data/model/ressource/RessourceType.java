package montp.data.model.ressource;

import montp.data.model.GenericEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "RESSOURCE_TYPE")
public class RessourceType extends GenericEntity {

    public RessourceType() {
    }

    public RessourceType(String label) {
        this.label = label;
    }

    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
