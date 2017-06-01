import data.Flight;
import data.Tablo;
import data.enums.Status;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sitora on 01.06.17.
 */
public class FlightTests {
    static List<Flight> departure, landing;
    static Tablo krrTablo = new Tablo();

    @BeforeClass
    public static void setUp() throws SQLException {
        departure= new ArrayList<>();
        departure.add(new Flight("KRR", "LED", new Date(2017, 2, 14), "SU6224", Status.CHECK_IN));
        departure.add(new Flight("KRR", "SVO", new Date(2017, 2, 14), "SU6225", Status.LANDED));
        departure.add(new Flight("KRR", "VKO", new Date(2017, 2, 14), "SU6226", Status.CANCELED));
        departure.add(new Flight("KRR", "AER", new Date(2017, 2, 14), "SU6227", Status.DELAYED));
        departure.add(new Flight("KRR", "LED", new Date(2017, 2, 14), "SU6228", Status.DEPARTURED));

        landing = new ArrayList<>();
        landing.add(new Flight("VKO", "KRR", new Date(2017, 2, 14), "SU6229", Status.BAGGAGE));
        landing.add(new Flight("SVO", "KRR", new Date(2017, 2, 14), "SU6234", Status.BOARDING));
        landing.add(new Flight("DME", "KRR", new Date(2017, 2, 14), "SU6244", Status.CHECK_IN));
        landing.add(new Flight("BCN", "KRR", new Date(2017, 2, 14), "SU6254", Status.CHECK_IN));
        landing.add(new Flight("VIE", "KRR", new Date(2017, 2, 14), "SU6264", Status.CHECK_IN));

        krrTablo.setArrival(landing);
        krrTablo.setDeparture(departure);
    }

    @Test
    public void changeStatus() throws SQLException {
        krrTablo.changeStatus(departure.get(0), Status.DELAYED);
        krrTablo.changeStatus(departure.get(3), Status.CANCELED);
        krrTablo.changeStatus(departure.get(4), Status.LANDED);

        krrTablo.changeStatus(landing.get(0), Status.LANDED);
        krrTablo.changeStatus(landing.get(1), Status.DEPARTURED);
        krrTablo.changeStatus(landing.get(2), Status.BOARDING);
        krrTablo.changeStatus(landing.get(3), Status.DELAYED);
        krrTablo.changeStatus(landing.get(4), Status.BAGGAGE);
    }
}
