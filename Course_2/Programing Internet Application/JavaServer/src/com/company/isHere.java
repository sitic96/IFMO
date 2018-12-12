
package com.company;


/**
 * Created by sitora on 06.12.15.
 */
public class isHere {
    public static boolean inFigure(double r, double x, double y) {
        return (x >= 0 && y <= 0 && x <= r && -y <= r
                || x >= 0 && y >= 0 && (x * x + y * y) <= r * r
                || x <= 0 && y >= 0 && x >= -r && y <= r / 2 && y <= x / 2 + r / 2);
    }
}
