package data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by sitora on 27.03.17.
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class AirportInfo {
    @XmlElement
    private String id;
    @XmlElement
    private String airport;
    @XmlElement
    private Condition condition;
    @XmlElement
    private Date date;

    public AirportInfo() {
    }

    public AirportInfo(String airport, Condition condition, Date date) {
        this.airport = airport;
        this.condition = condition;
        this.date = date;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
