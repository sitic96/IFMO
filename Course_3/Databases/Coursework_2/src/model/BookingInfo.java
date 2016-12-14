package model;

import java.io.Serializable;

/**
 * Created by sitora on 04.12.16.
 */
public class BookingInfo implements Serializable, Comparable<BookingInfo> {
    private Cat cat;
    private Host host;
    private Room room;
    private String id;
    public BookingInfo(Cat cat, Host host, Room room) {
        this.cat = cat;
        this.host = host;
        this.room = room;
//        this.price = price;
    }

    public BookingInfo() {

    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(BookingInfo o) {
        if (this.id.equals(o.getId())) return 0;
        else return -1;
    }
}
