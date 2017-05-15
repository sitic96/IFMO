package data.conditions;

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

    public WeatherPhenomena() {
    }

//    public WeatherPhenomena(String weatherPhenomena) {
//        switch (weatherPhenomena.substring(0, 1)) {
//            case "+": {
//                qualifier = Qualifier.HEAVY;
//                weatherPhenomena.replaceAll("//+", "");
//                break;
//            }
//            case "-": {
//                qualifier = Qualifier.LIGHT;
//                weatherPhenomena.replaceAll("-", "");
//                break;
//            }
//        }
//        if (EnumUtils.isValidEnum(data.enums.Qualifier.class, weatherPhenomena.substring(0, 1))) ;
//    }

    public WeatherPhenomena(Qualifier qualifier, Specification specification, List<data.enums.WeatherPhenomena> weatherPhenomenas) {
        this.qualifier = qualifier;
        this.specification = specification;
        this.weatherPhenomenas = weatherPhenomenas;
    }

    public WeatherPhenomena(Specification specification, List<data.enums.WeatherPhenomena> weatherPhenomenas) {
        this.specification = specification;
        this.weatherPhenomenas = weatherPhenomenas;
    }

    public WeatherPhenomena(Qualifier qualifier, List<data.enums.WeatherPhenomena> weatherPhenomenas) {
        this.qualifier = qualifier;
        this.weatherPhenomenas = weatherPhenomenas;
    }

    public Qualifier getQualifier() {
        return qualifier;
    }

    public Specification getSpecification() {
        return specification;
    }

    public List<data.enums.WeatherPhenomena> getWeatherPhenomenas() {
        return weatherPhenomenas;
    }

    public void setQualifier(Qualifier qualifier) {
        this.qualifier = qualifier;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public void setWeatherPhenomenas(List<data.enums.WeatherPhenomena> weatherPhenomenas) {
        this.weatherPhenomenas = weatherPhenomenas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (qualifier == Qualifier.HEAVY) {
            sb.append("+");
        } else if (qualifier == Qualifier.LIGHT) {
            sb.append("-");
        } else if (qualifier == Qualifier.VC) {
            sb.append("VC");
        }

        if (specification != null) {
            sb.append(qualifier);
        }

        for (data.enums.WeatherPhenomena phenomena : weatherPhenomenas) {
            sb.append(phenomena);
        }
        return sb.toString();
    }
}
