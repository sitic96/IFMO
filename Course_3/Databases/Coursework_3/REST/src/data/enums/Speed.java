package data.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by sitora on 26.03.17.
 */
public enum Speed {
    KMH, KT, MPS;

    private static final List<Speed> SPEEDS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = SPEEDS.size();
    private static final Random RANDOM = new Random();

    public static Speed randomSpeed() {
        return SPEEDS.get(RANDOM.nextInt(SIZE));
    }
}
