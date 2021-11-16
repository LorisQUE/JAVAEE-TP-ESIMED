package montp.web.converters;

import montp.data.dao.RessourceDAO;
import montp.data.model.ressource.Ressource;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Ressource.class)
public class RessourceConverter extends GenericConverter<Ressource>{
    public RessourceConverter() {
        super(Tools.lookupBean(RessourceDAO.class));
    }
}
