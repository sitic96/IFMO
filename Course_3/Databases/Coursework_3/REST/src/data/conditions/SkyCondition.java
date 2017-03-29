package data.conditions;

import data.enums.SkyConditions;

/**
 * Created by sitora on 27.03.17.
 */
public class SkyCondition {
    private SkyConditions skyConditions;
    private int distance;

    public SkyCondition() {
    }

    public SkyCondition(SkyConditions skyConditions) {
        if (skyConditions == SkyConditions.CAVOK) {
            this.skyConditions = skyConditions;
        } else throw new IllegalArgumentException("Not enough information about sky conditions");
    }

    public SkyCondition(SkyConditions skyConditions, int distance) {
        if (skyConditions != SkyConditions.CAVOK) {
            if (distance >= 0 && distance <= 999) {
                this.distance = distance;
            } else throw new IllegalArgumentException("Wrong distance");
        }
        this.skyConditions = skyConditions;
    }

    public SkyConditions getSkyConditions() {
        return skyConditions;
    }

    public int getDistance() {
        return distance;
    }

    public void setSkyConditions(SkyConditions skyConditions) {
        this.skyConditions = skyConditions;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (skyConditions == SkyConditions.CAVOK) {
            sb.append(skyConditions);
        } else {
            sb.append(skyConditions);
            if (distance < 100) {
                if (distance < 10) {
                    sb.append(0);
                }
                sb.append(0);
            }
            sb.append(distance);
        }
        return sb.toString();
    }
}
