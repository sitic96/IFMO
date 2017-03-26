package data;

/**
 * Created by sitora on 26.03.17.
 */
public class Runway {
    private int number;
    private char side;

    public Runway() {
    }

    public Runway(int number, char side) {
        if (number < 10 && number > 0) {
            this.number = number;
            this.side = side;
        } else throw new IllegalArgumentException("Exception in runwayNumber");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("R");
        sb.append(0);
        sb.append(number);
        sb.append(side);
        return sb.toString();
    }
}
