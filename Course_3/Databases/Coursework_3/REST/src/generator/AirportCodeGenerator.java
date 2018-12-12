package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sitora on 05.05.17.
 */
public class AirportCodeGenerator {
    private static final Random RANDOM = new Random();
    static StringBuilder sb;
    static char[] chars = "QWERTYUIOPLKJHGFDSAZXCVBNM".toCharArray();

    private static List<String> codes;

    public static List<String> generate(int count) {
        codes = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                sb.append(chars[RANDOM.nextInt(chars.length)]);
            }
            if (!codes.contains(sb.toString())) {
                codes.add(sb.toString());
            } else i--;
            System.out.println(codes.size());
        }
        return codes;
    }

    public static String getRandomCode() {
        if (codes != null && codes.size() > 0) {
            return codes.get(RANDOM.nextInt(codes.size()));
        } else throw new NullPointerException("Codes not generated");
    }

    public static Integer getCodesCount() {
        return codes.size();
    }

    public static List<String> getCodes() {
        return codes;
    }
}
