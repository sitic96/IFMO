import data.City;
import generator.CityGenerator;
import org.junit.Test;

/**
 * Created by sitora on 06.05.17.
 */
public class CityGeneratorTests {
    @Test
    public void testRandomCity() {
        City city = CityGenerator.getRandomCity();
        System.out.println(city.getName());
    }
}
