package montp.web.controllers;

import montp.data.dao.RessourceTypeDAO;
import montp.data.model.ressource.RessourceType;
import montp.locale.Messages;
import montp.services.RessourceTypeService;
import montp.web.FacesTools;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@ViewScoped
@Named("ressourceTypeDialog")
public class RessourceTypeDialog implements Serializable {
    @Inject protected Messages message;
    @Inject protected RessourceTypeService service;

    protected RessourceType instance;
    protected RessourceTypeView ressourceTypeView;

    public void create(RessourceTypeView ressourceTypeView) {
        this.ressourceTypeView = ressourceTypeView;
        instance = new RessourceType();
    }

    public void save() {
        if (instance.getId() == null) {
            service.insert(instance);
            FacesTools.addMessage(FacesMessage.SEVERITY_INFO, message.get("app.added"));
            ressourceTypeView.init();

        } else {
            service.update(instance);
            FacesTools.addMessage(FacesMessage.SEVERITY_INFO, message.get("app.updated"));
        }
    }

    public RessourceType getInstance() {
        return instance;
    }

    public void setInstance(RessourceType instance) {
        this.instance = instance;
    }

    // TODO: Dans le xhtml du dialog, le titre reste TOUJOURS a "nouveau type"
    public String getEditTitle(){
        return String.format(message.get("app.ressourcetype.newTitle"), instance.toString());
    }

}