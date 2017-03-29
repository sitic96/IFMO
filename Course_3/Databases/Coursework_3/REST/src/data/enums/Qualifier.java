package data.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by sitora on 26.03.17.
 */
public enum Qualifier {
    LIGHT, MODERATE, HEAVY, VC;

    private static final List<Qualifier> QUALIFIERS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = QUALIFIERS.size();
    private static final Random RANDOM = new Random();

    public static Qualifier randomQualifier() {
        return QUALIFIERS.get(RANDOM.nextInt(SIZE));
    }
}
