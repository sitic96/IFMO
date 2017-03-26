package data;

import data.enums.Qualifier;
import data.enums.Specification;

import java.util.List;

/**
 * Created by sitora on 26.03.17.
 */
public class WeatherPhenomena {
    Qualifier qualifier;
    Specification specification;
    List<data.enums.WeatherPhenomena> weatherPhenomenas;

    public WeatherPhenomena(){}

    public WeatherPhenomena(Qualifier qualifier, Specification specification) {
        this.qualifier = qualifier;
        this.specification = specification;
    }

    public WeatherPhenomena(Specification specification) {
        this.specification = specification;
    }

    public WeatherPhenomena(Qualifier qualifier) {
        this.qualifier = qualifier;
    }
}
