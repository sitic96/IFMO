package data.conditions;

/**
 * Created by sitora on 27.03.17.
 */

public class Temperature {
    int temperature, dew;

    public Temperature() {
    }

    public Temperature(int temperature, int dew) {
        this.temperature = temperature;
        this.dew = dew;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getDew() {
        return dew;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setDew(int dew) {
        this.dew = dew;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (temperature < 0) {
            sb.append("M");
        }
        sb.append(temperature);
        sb.append("/");
        if (dew < 0) {
            sb.append("M");
        }
        sb.append(dew);
        return sb.toString();
    }
}
