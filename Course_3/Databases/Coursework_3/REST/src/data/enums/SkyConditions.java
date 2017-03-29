package data.enums;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by sitora on 27.03.17.
 */
public enum SkyConditions {
    SKS, NSC, FEW, SKT, BKN, OVC, CB, CAVOK, VV;

    private static final List<SkyConditions> SKY_CONDITIONS = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = SKY_CONDITIONS.size();
    private static final Random RANDOM = new Random();

    public static SkyConditions randomSkyCondition() {
        return SKY_CONDITIONS.get(RANDOM.nextInt(SIZE));
    }
}
