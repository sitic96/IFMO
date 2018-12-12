package generator;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

/**
 * Created by sitora on 12.05.17.
 */
public class NamesGenerator {
    private final static Random RANDOM = new Random();
    private final static String URL = "https://raw.githubusercontent.com/dominictarr/random-name/master/first-names.json";

    private static String[] names;

    public static String getRandomName() {
        if (names == null) {
            init();
        }
        return names[RANDOM.nextInt(names.length - 1)];
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            java.net.URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public static String[] getNames() {
        if (names == null) {
            init();
        }
        return names;
    }

    private static void init() {
        if (names == null) {
            String json;
            Gson gson = new Gson();
            try {
                json = readUrl(URL);
                names = gson.fromJson(json, String[].class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
