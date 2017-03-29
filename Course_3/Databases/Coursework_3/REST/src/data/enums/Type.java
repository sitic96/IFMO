package data.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by sitora on 26.03.17.
 */
public enum Type {
    METAR("METAR"), SPECI("SPECI");

    private String type;

    private Type(String type) {
        this.type = type;
    }

    private static final List<Type> TYPES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = TYPES.size();
    private static final Random RANDOM = new Random();

    public static Type randomType() {
        return TYPES.get(RANDOM.nextInt(SIZE));
    }

    public String getType() {
        return type;
    }
}
