package montp.data.dao;

import javax.enterprise.context.ApplicationScoped;
import montp.data.model.reservation.Reservation;

@ApplicationScoped
public class ReservationDAO extends GenericDAO<Reservation> {

    public ReservationDAO() {
        super(Reservation.class);
    }

}
