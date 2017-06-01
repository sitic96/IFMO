package data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sitora on 12.05.17.
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Worker {
    @XmlElement
    private String firstName;
    @XmlElement
    private String secondName;
    @XmlElement
    private String city;
    @XmlElement
    private String airportCode;

    public Worker(String firstName, String secondName, String city, String airportCode) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.city = city;
        this.airportCode = airportCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }
}
