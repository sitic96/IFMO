package data;

import data.enums.Status;

import java.util.Date;

/**
 * Created by sitora on 31.05.17.
 */
public class Flight {
    String id;
    String from;
    String to;
    Date date;
    String code;
    Status status;

    public Flight(String from, String to, Date date, String code, Status status) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.code = code;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
