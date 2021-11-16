package montp.web.controllers;

import montp.data.model.ressource.Ressource;
import montp.data.model.ressource.RessourceType;
import montp.locale.Messages;
import montp.services.RessourceService;
import montp.tools.Logger;
import montp.web.FacesTools;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@ViewScoped
@Named("ressource")
public class RessourceView implements Serializable {

    @Inject private RessourceService ressourceService;
    @Inject private Messages message;

    private RessourceType type;
    private List<Ressource> datas;

    @PostConstruct
    public void init() {
        // TODO : Récupération des ressources par types
        //datas = ressourceService.getAllFromType(type.getId());
        datas = ressourceService.getAll();
    }

    public List<Ressource> getRessources() {
        return datas;
    }

    public RessourceType getType() {
        return type;
    }

    public void setType(RessourceType ressourceType) { this.type = ressourceType; }

    public void delete(Ressource ressource) {
        if(ressource != null) {
            ressourceService.delete(ressource);
            datas.remove(ressource);
            FacesTools.addMessage(FacesMessage.SEVERITY_INFO, message.get("app.delete"));
        } else {
            FacesTools.addMessage(FacesMessage.SEVERITY_ERROR, message.get("app.delete.error"));
        }
    }
}
