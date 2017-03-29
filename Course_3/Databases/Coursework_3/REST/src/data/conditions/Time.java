package data.conditions;

/**
 * Created by sitora on 26.03.17.
 */
public class Time {

    private int day, hours, mins;

    public Time() {
    }

    public Time(int day, int hours, int mins) {
        if (day==32){day--;}
        if (day > 0 && day <= 31 && hours <= 24 && hours >= 0 && mins >= 0 && mins < 60) {
            this.day = day;
            this.hours = hours;
            this.mins = mins;
        } else {
            throw new IllegalArgumentException("Wrong time params");
        }
    }

    public int getDay() {
        return day;
    }

    public int getHours() {
        return hours;
    }

    public int getMins() {
        return mins;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMins(int mins) {
        this.mins = mins;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (day < 10) {
            sb.append("0");

        }
        sb.append(day);
        if (hours < 10) {
            sb.append("0");
        }
        sb.append(hours);
        if (mins < 10) {
            sb.append("0");
        }
        sb.append(mins);

        /**
         * All dates always appended with Z to indicate UTC
         */
        sb.append("Z");
        return sb.toString();
    }
}
