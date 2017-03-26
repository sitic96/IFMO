package data;

/**
 * Created by sitora on 26.03.17.
 */

import data.enums.DistanceType;

/**
 * Formats:
 * Meters: xxxx
 * Miles: x (x/x) SM
 * If value < 1500m or 1/4SM: Rxx/xxxx
 * NDV if not available
 */
public class Visibility {
    int meters;
    double miles;
    DistanceType distanceType;
    Runway runway;

    public Visibility() {
    }

    public Visibility(double distance, DistanceType distanceType) {
        if (distanceType == DistanceType.METERS) {
            if (distance >= 1500) {
                this.meters = (int) distance;
            } else throw new IllegalArgumentException("Runway number required for visibility less than 1500 meters!");
        } else if (distanceType == DistanceType.MILES) {
            if (distance >= 0.25) {
                this.miles = distance;
            } else throw new IllegalArgumentException("Runway number required for visibility less than 1/4 miles!");
        } else throw new IllegalArgumentException("Exception in visibility params");
        this.distanceType = distanceType;
    }

    public Visibility(double distance, DistanceType distanceType, Runway runway) {
        if (distanceType == DistanceType.METERS) {
            if (distance > 0 && distance <= 1500) {
                this.meters = (int) distance;
                this.runway = runway;
            } else if (distance > 1500) {
                this.meters = (int) distance;
            } else throw new IllegalArgumentException("Exception in visibility params");
        } else if (distanceType == DistanceType.MILES) {
            if (distance >= 0 && distance <= 0.25) {
                this.miles = distance;
                this.runway = runway;
            } else if (distance >= 0.25) {
                this.miles = distance;
            } else throw new IllegalArgumentException("Exception in visibility params");
        } else throw new IllegalArgumentException("Exception in visibility params");
        this.distanceType = distanceType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (distanceType == DistanceType.METERS) {
            if (meters < 1500) {
                sb.append(runway.toString());
                sb.append("/");
                if (meters < 1000) {
                    sb.append(0);
                    if (meters < 100) {
                        sb.append(0);
                        if (meters < 10) {
                            sb.append(0);
                        }
                    }
                }
            } else sb.append(meters);
        } else if (distanceType == DistanceType.MILES) {
            if (miles >= 0.25) {
                sb.append(String.format("%.2f", miles));
                sb.append("SM");
            } else {
                sb.append(runway.toString());
                sb.append("/");
                sb.append(String.format("%.2f", miles));
                sb.append("SM");
            }
        }
        return sb.toString();
    }
}
