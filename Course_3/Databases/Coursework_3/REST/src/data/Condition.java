package data;

import data.conditions.*;
import data.enums.Type;

/**
 * Created by sitora on 26.03.17.
 */

public class Condition {
    Type type;
    String IKAO;
    Time time;
    Wind wind;
    Visibility visibility;
    WeatherPhenomena weatherPhenomena;
    SkyCondition skyCondition;
    Temperature temperature;
    Pressure pressure;

    public Condition() {
    }

    public Condition(Type type, String IKAO, Time time, Wind wind,
                     Visibility visibility, WeatherPhenomena weatherPhenomena, SkyCondition skyCondition,
                     Temperature temperature, Pressure pressure) {
        this.type = type;
        this.IKAO = IKAO;
        this.time = time;
        this.wind = wind;
        this.visibility = visibility;
        this.weatherPhenomena = weatherPhenomena;
        this.skyCondition = skyCondition;
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public Type getType() {
        return type;
    }

    public String getIKAO() {
        return IKAO;
    }

    public Time getTime() {
        return time;
    }

    public Wind getWind() {
        return wind;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public WeatherPhenomena getWeatherPhenomena() {
        return weatherPhenomena;
    }

    public SkyCondition getSkyCondition() {
        return skyCondition;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Pressure getPressure() {
        return pressure;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setIKAO(String IKAO) {
        this.IKAO = IKAO;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public void setWeatherPhenomena(WeatherPhenomena weatherPhenomena) {
        this.weatherPhenomena = weatherPhenomena;
    }

    public void setSkyCondition(SkyCondition skyCondition) {
        this.skyCondition = skyCondition;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        sb.append(" ");
        sb.append(time);
        sb.append(" ");
        sb.append(wind);
        sb.append(" ");
        sb.append(visibility);
        sb.append(" ");
        sb.append(weatherPhenomena);
        sb.append(" ");
        sb.append(skyCondition);
        sb.append(" ");
        sb.append(temperature);
        sb.append(" ");
        sb.append(pressure);
        return sb.toString();
    }
}
