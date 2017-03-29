package data.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by sitora on 27.03.17.
 */
public enum PressureType {
    Q("Q"), A("A");

    private String pressure;
    private PressureType(String pressure){this.pressure = pressure;}
    private static final List<PressureType> PRESSURE_TYPES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = PRESSURE_TYPES.size();
    private static final Random RANDOM = new Random();

    public static PressureType randomPressureType() {
        return PRESSURE_TYPES.get(RANDOM.nextInt(SIZE));
    }

    public String getPressure() {
        return pressure;
    }
}
