package data.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by sitora on 26.03.17.
 */
public enum Specification {
    MI, BC, PR, DR, BL, SH, TS, FZ;

    private static final List<Specification> SPECIFICATIONS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = SPECIFICATIONS.size();
    private static final Random RANDOM = new Random();

    public static Specification randomSpecification() {
        return SPECIFICATIONS.get(RANDOM.nextInt(SIZE));
    }
}
