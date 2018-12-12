package data.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by sitora on 26.03.17.
 */
public enum WeatherPhenomena {
    BR, SA, FU, HZ, VA, PY, DU, DZ, IC, UP, RA, SN, SG, PO, GR, GS, SQ, FC, SS, DS;

    private static final List<WeatherPhenomena> WEATHER_PHENOMENAS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = WEATHER_PHENOMENAS.size();
    private static final Random RANDOM = new Random();

    public static WeatherPhenomena randomWeatherPhenomena() {
        return WEATHER_PHENOMENAS.get(RANDOM.nextInt(SIZE));
    }
}
