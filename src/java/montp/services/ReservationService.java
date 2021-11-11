package montp.services;

import montp.data.dao.ReservationDAO;
import montp.data.model.person.Person;
import montp.data.model.reservation.Reservation;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class ReservationService extends GenericService<Reservation, ReservationDAO> {

    @Transactional
    public void insert(Reservation reservation) {
        //reservation.setDateStart(reservation.getDateStart());
        //reservation.setDateEnd(reservation.getDateEnd());
        //reservation.setPerson(reservation.getPerson());
        //reservation.setRessource(reservation.getRessource());
        //reservation.setPersonsCount(reservation.getPersonsCount());
        super.insert(reservation);
    }

}
