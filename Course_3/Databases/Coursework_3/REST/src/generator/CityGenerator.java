package generator;

import com.google.gson.Gson;
import data.City;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Random;

/**
 * Created by sitora on 06.05.17.
 */
public class CityGenerator {
    private final static Random RANDOM = new Random();
    //private final static String URL = "http://data.okfn.org/data/core/world-cities/r/world-cities.json";
    private final static String URL = "https://raw.githubusercontent.com/David-Haim/CountriesToCitiesJSON/master/countriesToCities.json";

    private static City[] cities;

    public static City getRandomCity() {
        if (cities == null) {
            init();
        }
        return cities[RANDOM.nextInt(cities.length - 1)];
    }

    private static String readUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
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

    public static City[] getCities() {
        if (cities == null) {
            init();
        }
        return cities;
    }

    private static void init() {
        if (cities == null) {
            String json;
            Gson gson = new Gson();
            try {
                json = readUrl(URL);
                cities = gson.fromJson(json, City[].class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
