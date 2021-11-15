package montp.web.controllers;

import montp.data.model.ressource.RessourceType;
import montp.services.RessourceTypeService;
import montp.tools.Logger;
import montp.web.FacesTools;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ViewScoped
@Named("ressourcetype")
public class RessourceTypeView implements Serializable {

    @Inject private RessourceTypeService ressourceTypeService;
    @Inject private RessourceTypeDialog ressourceTypeDialog;
    private List<RessourceType> datas;

    @PostConstruct
    public void init() {
        datas = ressourceTypeService.getRessourceTypes();
        Logger.log(Logger.LogLevel.INFO, RessourceTypeView.class.getSimpleName(), "initializing view controller");
    }

    public List<RessourceType> getRessourceTypes() {
        //return ressourceTypeService.getRessourceTypes();
        return datas;
    }

    public boolean canDelete(RessourceType ressourceType) {
        return ressourceTypeService.canDelete(ressourceType);
    }

    public void deleteRessourceType(RessourceType ressourceType) {
        if(ressourceType != null)
            ressourceTypeService.delete(ressourceType);
    }

    public void edit(RessourceType ressourceType) {
        ressourceTypeDialog.setInstance(ressourceType);
    }

}