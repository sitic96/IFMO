package generator;

import com.google.gson.Gson;
import data.Airport;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

/**
 * Created by sitora on 16.05.17.
 */
public class AirportGenerator {
    private final static Random RANDOM = new Random();
    private final static String URL = "https://gist.githubusercontent.com/tdreyno/4278655/raw/7b0762c09b519f40397e4c3e100b097d861f5588/airports.json";

    private static Airport[] airports;

    public static Airport getRandomName() {
        if (airports == null) {
            init();
        }
        return airports[RANDOM.nextInt(airports.length - 1)];
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

    public static Airport[] getAirports() {
        if (airports == null) {
            init();
        }
        return airports;
    }

    private static void init() {
        if (airports == null) {
            String json;
            Gson gson = new Gson();
            try {
                json = readUrl(URL);
                airports = gson.fromJson(json, Airport[].class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
