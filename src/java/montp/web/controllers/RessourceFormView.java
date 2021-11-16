package montp.web.controllers;

import montp.data.model.person.Person;
import montp.data.model.ressource.Ressource;
import montp.locale.Messages;
import montp.services.PersonService;
import montp.services.RessourceService;
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
@Named("ressourceform")
public class RessourceFormView implements Serializable {

    @Inject private RessourceService service;
    @Inject private PersonService personService;
    @Inject private Messages message;
    private Ressource instance;
    private List<Person> persons;

    @PostConstruct
    public void init() {
        if(instance == null)
            instanciate();
        persons = personService.getAll();
        Logger.log(Logger.LogLevel.INFO, RessourceView.class.getSimpleName(), "Init de la vue");
    }

    public void instanciate(){
        instance = new Ressource();
    }

    // TODO : Gérer la redirection sur la liste des ressources
    public void save() {
        if (instance.getId() == null || instance.getId() == 0) {
            service.insert(instance);
            FacesTools.addMessage(FacesMessage.SEVERITY_INFO, message.get("app.added"));
        } else {
            service.update(instance);
            FacesTools.addMessage(FacesMessage.SEVERITY_INFO, message.get("app.updated"));
        }
    }

    public Ressource getInstance() { return instance; }

    public void setInstance(Ressource instance) { this.instance = instance; }

    public List<Person> getPersons() { return persons; }
}
