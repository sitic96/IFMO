package data.enums;

import redis.clients.johm.Attribute;
import redis.clients.johm.Model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by sitora on 27.03.17.
 */
@Model
public enum Airport {
    KRR("KRR", "URKK", "KRASNODAR"), SVO("SVO", "UUEE", "MOSCOW"), DME("DME", "UUDD", "MOSCOW"),
    VKO("VKO", "UUWW", "MOSCOW"), LED("LED", "ULLI", "SAINT-PETERSBURG"), AER("AER", "URSS", "SOCHI"), SVX("SVX", "USSS", "EKATERENBURG"),
    LHR("LHR", "EGLL", "LONDON"), CDG("CDG", "LFPG", "PARIS"), MAD("MAD", "LEMD", "MADRID"), FCO("FCO", "LIRF", "ROME"), BCN("BCN", "LEBL", "BARCELONA");

    @Attribute
    private String code;
    @Attribute
    private String ikao;
    @Attribute
    private String city;

    private Airport(String code, String ikao, String city) {
        this.code = code;
        this.ikao = ikao;
        this.city = city;
    }

    private static final List<Airport> AIRPORTS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = AIRPORTS.size();
    private static final Random RANDOM = new Random();

    public static Airport randomAirport() {
        return AIRPORTS.get(RANDOM.nextInt(SIZE));
    }

    public String getCode() {
        return code;
    }

    public String getIkao() {
        return ikao;
    }

    public String getCity() {
        return city;
    }
}
