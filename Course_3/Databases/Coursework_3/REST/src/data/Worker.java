package data;

/**
 * Created by sitora on 12.05.17.
 */
public class Worker {
    private String firstName;
    private String secondName;
    private City city;
    private String airportCode;

    public Worker(String firstName, String secondName, City city, String airportCode) {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }
}
