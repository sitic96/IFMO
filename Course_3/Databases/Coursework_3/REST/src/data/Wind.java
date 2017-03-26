package data;

import data.enums.Speed;

/**
 * Created by sitora on 26.03.17.
 */
public class Wind {

    private int dest, speed, maxObservedSpeed;
    Speed speedType;

    public Wind() {
    }

    public Wind(int dest, int speed) {
        if (dest >= 0 && dest <= 360 && speed >= 0 && speed <= 99) {
            this.dest = dest;
            this.speed = speed;
        } else throw new IllegalArgumentException("Exception in wind args");
    }

    public Wind(int dest, int speed, int maxObservedSpeed) {
        if (dest >= 0 && dest <= 360 && speed >= 0 && speed <= 99 && maxObservedSpeed >= 0 && maxObservedSpeed <= 99) {
            this.dest = dest;
            this.speed = speed;
            this.maxObservedSpeed = maxObservedSpeed;
        } else throw new IllegalArgumentException("Exception in wind args");
    }

    public Wind(int dest, int speed, int maxObservedSpeed, Speed speed1) {
        if (dest >= 0 && dest <= 360 && speed >= 0 && speed <= 99 && maxObservedSpeed >= 0 && maxObservedSpeed <= 99) {
            this.dest = dest;
            this.speed = speed;
            this.maxObservedSpeed = maxObservedSpeed;
            this.speedType = speed1;
        } else throw new IllegalArgumentException("Exception in wind args");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (dest < 100) {
            if (dest < 10) {
                sb.append("0");
            }
            sb.append("0");
        }
        sb.append(dest);
        if (speed < 10) {
            sb.append("0");
        }
        sb.append(speedType);
        if (maxObservedSpeed != 0) {
            sb.append("G");
            sb.append(maxObservedSpeed);
        }
        if (speedType != null) {
            sb.append(speedType);
        } else sb.append(Speed.KMH);
        return sb.toString();
    }
}
