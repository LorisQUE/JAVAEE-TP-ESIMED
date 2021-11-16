package montp.web.converters;

import montp.data.dao.RessourceTypeDAO;
import montp.data.model.ressource.RessourceType;
import montp.tools.Tools;

import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = RessourceType.class)
public class RessourceTypeConverter extends GenericConverter<RessourceType>{
    public RessourceTypeConverter() {
        super(Tools.lookupBean(RessourceTypeDAO.class));
    }
}