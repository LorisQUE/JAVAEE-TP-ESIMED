package montp.data;

import montp.data.model.person.Person;
import montp.data.model.ressource.Ressource;
import montp.data.model.security.Group;
import montp.data.model.security.User;
import montp.data.model.ressource.RessourceType;
import montp.services.RessourceTypeService;
import montp.services.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Singleton
@Startup
public class Seeder {
    
    @Inject
    private UserService userService;
    private RessourceTypeService ressourceTypeService;

    @PersistenceContext
    private EntityManager em;
    
    @PostConstruct
    public void init() {
        if (userService.getGroup("USER") == null) {
            Group groupUser = new Group("USER");
            em.persist(groupUser);
            Group groupAdmin = new Group("ADMIN");
            em.persist(groupAdmin);

            User userUser1 = new User("user1", "user1");
            List<Group> groupes = new ArrayList<>();
            groupes.add(groupUser);
            userUser1.setGroups(groupes);
            userService.insert(userUser1);

            User userAdmin = new User("admin", "admin");
            groupes.add(groupAdmin);
            userAdmin.setGroups(groupes);
            userService.insert(userAdmin);

            Person personUn = new Person(
                    "CARTIER",
                    "Jacques",
                    "J.CART@LaRoyale.fr",
                    "Xpl0rat0r",
                    "cartier",
                    true);
            em.persist(personUn);

            Person personDeux = new Person(
                    "DE BOUGAINVILLE",
                    "Louis-Antoine",
                    "LA.BOUGAINVILLE@LaRoyale.fr",
                    "LeBoug",
                    "bougain",
                    false);
            em.persist(personDeux);

            RessourceType typeVehicule = new RessourceType("Vehicule");
            em.persist(typeVehicule);

            Ressource vehiculeUn = new Ressource("Peugeot 206 Blanche", null, false, typeVehicule, personDeux);
            em.persist(vehiculeUn);

            Ressource vehiculeDeux = new Ressource("Renault C15 Blanc", null, false, typeVehicule, personUn);
            em.persist(vehiculeDeux);

            RessourceType typeSalle = new RessourceType("Salle");
            em.persist(typeSalle);

            Ressource salleUn = new Ressource("Salle de Réunion", 15, false, typeSalle, personUn);
            em.persist(salleUn);

            Ressource salleDeux = new Ressource("Salle de Formation", 10, false, typeSalle, personDeux);
            em.persist(salleDeux);


        }
    }

}
