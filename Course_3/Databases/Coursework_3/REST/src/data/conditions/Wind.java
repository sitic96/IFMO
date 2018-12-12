package data.conditions;

import data.enums.Speed;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by sitora on 26.03.17.
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Wind {
    @XmlElement
    private int dest, speed, maxObservedSpeed;
    @XmlElement
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

    public int getDest() {
        return dest;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMaxObservedSpeed() {
        return maxObservedSpeed;
    }

    public Speed getSpeedType() {
        return speedType;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setMaxObservedSpeed(int maxObservedSpeed) {
        this.maxObservedSpeed = maxObservedSpeed;
    }

    public void setSpeedType(Speed speedType) {
        this.speedType = speedType;
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
