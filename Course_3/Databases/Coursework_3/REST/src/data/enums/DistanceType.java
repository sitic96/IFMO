package data.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by sitora on 26.03.17.
 */
public enum DistanceType {
    MILES("miles"), METERS("meters");

    private String distName;

    private DistanceType(String distName) {
        this.distName = distName;
    }

    private static final List<DistanceType> DISTANCE_TYPES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = DISTANCE_TYPES.size();
    private static final Random RANDOM = new Random();

    public static DistanceType randomDistanceType() {
        return DISTANCE_TYPES.get(RANDOM.nextInt(SIZE));
    }

    public String getDistName() {
        return distName;
    }
}
