package montp.data;

import montp.data.model.person.Person;
import montp.data.model.reservation.Reservation;
import montp.data.model.ressource.Ressource;
import montp.data.model.security.Group;
import montp.data.model.security.User;
import montp.data.model.ressource.RessourceType;
import montp.services.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Singleton
@Startup
public class Seeder {

    @Inject private UserService userService;
    @Inject private PersonService personService;
    @Inject private RessourceService ressourceService;
    @Inject private RessourceTypeService ressourceTypeService;
    @Inject private ReservationService reservationService;

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

            // /!\ On ne précise jamais le grp de sécurité des persons, c'est à faire
            Person personUn = new Person(
                    "CARTIER",
                    "Jacques",
                    "J.CART@LaRoyale.fr",
                    "Xpl0rat0r",
                    "cartier",
                    true);
            personService.insert(personUn);

            Person personDeux = new Person(
                    "DE BOUGAINVILLE",
                    "Louis-Antoine",
                    "LA.BOUGAINVILLE@LaRoyale.fr",
                    "LeBoug",
                    "bougain",
                    false);
            personService.insert(personDeux);

            RessourceType typeRien = new RessourceType("Rien", null);
            ressourceTypeService.insert(typeRien);

            RessourceType typeVehicule = new RessourceType("Vehicule", 5);
            ressourceTypeService.insert(typeVehicule);


            Ressource vehiculeUn = new Ressource("Peugeot 206 Blanche", false, typeVehicule, personDeux);
            ressourceService.insert(vehiculeUn);

            Ressource vehiculeDeux = new Ressource("Renault C15 Blanc", false, typeVehicule, personUn);
            ressourceService.insert(vehiculeDeux);

            RessourceType typeSalle = new RessourceType("Salle", 10);
            ressourceTypeService.insert(typeSalle);

            Ressource salleUn = new Ressource("Salle de Réunion", true, typeSalle, personUn);
            ressourceService.insert(salleUn);

            Ressource salleDeux = new Ressource("Salle de Formation", true, typeSalle, personDeux);
            ressourceService.insert(salleDeux);

            Reservation reservationUne = new Reservation(personUn, salleUn, new Date(), new Date(), 10);
            reservationService.insert(reservationUne);

            Reservation reservationDeux = new Reservation(personUn, vehiculeUn, new Date(System.currentTimeMillis() - 7L * 24 * 3600 * 1000), new Date(), null);
            reservationService.insert(reservationDeux);

            Reservation reservationTrois = new Reservation(personDeux, vehiculeUn, new Date(System.currentTimeMillis() - 10L * 24 * 3600 * 1000), new Date(System.currentTimeMillis() - 8L * 24 * 3600 * 1000), null);
            reservationService.insert(reservationTrois);
        }
    }

}
