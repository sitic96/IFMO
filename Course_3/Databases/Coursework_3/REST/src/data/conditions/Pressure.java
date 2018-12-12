package data.conditions;

import data.enums.PressureType;

/**
 * Created by sitora on 27.03.17.
 */
public class Pressure {
    private PressureType pressureType;
    private int value;

    public Pressure() {
    }

    public Pressure(PressureType pressureType, int value) {
        this.pressureType = pressureType;
        this.value = value;
    }

    public PressureType getPressureType() {
        return pressureType;
    }

    public int getValue() {
        return value;
    }

    public void setPressureType(PressureType pressureType) {
        this.pressureType = pressureType;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(pressureType);
        if (value < 1000) {
            if (value < 100) {
                if (value < 10) {
                    sb.append(0);
                }
                sb.append(0);
            }
            sb.append(0);
        }
        sb.append(value);
        return sb.toString();
    }
}
