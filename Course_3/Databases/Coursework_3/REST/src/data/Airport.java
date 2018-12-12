package data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sitora on 16.05.17.
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Airport {
    Integer city;
    @XmlElement
    String code;
    @XmlElement
    String name;
    @XmlElement
    String home_city;
    @XmlElement
    String type;
    @XmlElement
    Integer runway_length;
    @XmlElement
    String icao;
    @XmlElement
    Integer direct_flights;
    @XmlElement
    Integer carriers;
    private transient AirportInfo info;

    public AirportInfo getInfo() {
        return info;
    }

    public void setInfo(AirportInfo info) {
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome_city() {
        return home_city;
    }

    public void setHome_city(String home_city) {
        this.home_city = home_city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRunway_length() {
        return runway_length;
    }

    public void setRunway_length(Integer runway_length) {
        this.runway_length = runway_length;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public Integer getDirect_flights() {
        return direct_flights;
    }

    public void setDirect_flights(Integer direct_flights) {
        this.direct_flights = direct_flights;
    }

    public Integer getCarriers() {
        return carriers;
    }

    public void setCarriers(Integer carriers) {
        this.carriers = carriers;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }
}
