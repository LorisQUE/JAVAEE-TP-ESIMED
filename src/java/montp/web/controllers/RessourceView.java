package montp.web.controllers;

import montp.data.model.ressource.Ressource;
import montp.data.model.ressource.RessourceType;
import montp.locale.Messages;
import montp.services.RessourceService;
import montp.tools.Logger;

import javax.annotation.PostConstruct;
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

    private long typeId;
    private RessourceType type;
    private List<Ressource> datas;

    // TODO: Le init n'est jamais appelé ?
    //  Les logs ne sont pas présent en tout cas et datas n'est jamais remplis
    @PostConstruct
    public void init(RessourceType ressourceType) {
        Logger.log(Logger.LogLevel.INFO, null, "long typeid" + typeId);
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String typeId = params.get("typeId");
        type = ressourceType;
        datas = ressourceService.getAll();
        Logger.log(Logger.LogLevel.INFO, RessourceView.class.getSimpleName(), "initializing view controller :" + typeId);
    }

    public List<Ressource> getRessources() {
        return ressourceService.getAll();
        //return datas;
    }

    public RessourceType getType() {
        return type;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long id) {
        this.typeId = id;
    }
}
