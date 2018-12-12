package data;

import data.conditions.*;
import data.enums.Type;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sitora on 26.03.17.
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Condition {

    @XmlElement
    String type;
    @XmlElement
    String IKAO;
    @XmlElement
    String time;
    @XmlElement
    Wind wind;
    @XmlElement
    String visibility;
    @XmlElement
    String weatherPhenomena;
    @XmlElement
    String skyCondition;
    @XmlElement
    String temperature;
    @XmlElement
    String pressure;

    public Condition() {
    }

    public Condition(Type type, String IKAO, Time time, Wind wind,
                     Visibility visibility, WeatherPhenomena weatherPhenomena, SkyCondition skyCondition,
                     Temperature temperature, Pressure pressure) {
        this.type = type.toString();
        this.IKAO = IKAO;
        this.time = time.toString();
        this.wind = wind;
        this.visibility = visibility.toString();
        this.weatherPhenomena = weatherPhenomena.toString();
        this.skyCondition = skyCondition.toString();
        this.temperature = temperature.toString();
        this.pressure = pressure.toString();
    }

    public String getType() {
        return type;
    }

    public String getIKAO() {
        return IKAO;
    }

    public String getTime() {
        return time;
    }

    public Wind getWind() {
        return wind;
    }

    public String getVisibility() {
        return visibility;
    }

    public String getWeatherPhenomena() {
        return weatherPhenomena;
    }

    public String getSkyCondition() {
        return skyCondition;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getPressure() {
        return pressure;
    }

    public void setType(Type type) {
        this.type = type.toString();
    }

    public void setIKAO(String IKAO) {
        this.IKAO = IKAO;
    }

    public void setTime(Time time) {
        this.time = time.toString();
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility.toString();
    }

    public void setWeatherPhenomena(WeatherPhenomena weatherPhenomena) {
        this.weatherPhenomena = weatherPhenomena.toString();
    }

    public void setSkyCondition(SkyCondition skyCondition) {
        this.skyCondition = skyCondition.toString();
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature.toString();
    }

    public void setPressure(Pressure pressure) {
        this.pressure = pressure.toString();
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public void setWeatherPhenomena(String weatherPhenomena) {
        this.weatherPhenomena = weatherPhenomena;
    }

    public void setSkyCondition(String skyCondition) {
        this.skyCondition = skyCondition;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setPressure(String pressure) {
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
